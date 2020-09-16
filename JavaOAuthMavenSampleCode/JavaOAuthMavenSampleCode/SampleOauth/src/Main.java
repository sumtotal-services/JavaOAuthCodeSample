import com.nimbusds.oauth2.sdk.*;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.token.AccessToken;
import com.nimbusds.oauth2.sdk.token.RefreshToken;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponseParser;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;
import org.cef.callback.CefAuthCallback;
import org.cef.callback.CefRequestCallback;
import org.cef.handler.CefLoadHandler;
import org.cef.handler.CefRequestHandler;
import org.cef.handler.CefResourceHandler;
import org.cef.misc.BoolRef;
import org.cef.misc.StringRef;
import org.cef.network.CefRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Date;
import java.util.Properties;

public class Main {

    // If _storedRefreshToken is null, CodeGrantFlow goes
    // through the entire process of getting the user credentials
    // and permissions. If _storedRefreshToken contains the refresh
    // token, CodeGrantFlow returns the new access and refresh tokens.
    private static String _storedRefreshToken = null;

    private static AccessTokenValues _tokens = null;
    public static String _authorizationCode = null;
    private static Date _tokenExpiration;

    // Production OAuth server endpoints.
    public static String env = null;
    public static String redirect = null;
    public static String clientId = null;
    public static String clientSecret = null;
    public static String scopes = null;
    public static String grantType = null;
    public static String rop_username = null;
    public static String rop_password = null;

    private static String CodeQueryString = "?client_id={0}&client_secret={1}&scope=" + scopes + "&response_type=code&redirect_uri={2}";
    private static String B2BAccessBody = "client_id={0}&client_secret={1}&grant_type=client_credentials&redirect_uri={2}";
    private static String AuthCodeAccessBody = "client_id={0}&client_secret={1}&code={2}&grant_type=authorization_code&redirect_uri={3}";
    private static String ROPAccessBody = "grant_type=password&username={0}&password={1}&client_id={2}&client_secret={3}";
    private String RefreshBody = "client_id={0}&client_secret={1}&grant_type=refresh_token&redirect_uri={2}&refresh_token={3}";
    private static String _uri = null;

    private static String AuthorizationUri = env + "/apisecurity/connect/authorize";  // Authorization code endpoint
    private static String RedirectUri = redirect;  // Callback endpoint
    private static String RefreshUri = env + "/apisecurity/connect/token";  // Get tokens endpoint

    public static void main(String[] args) throws Exception {
        Console.writeLine("Starting Java Oauth Sample App");
        Console.writeLine("");

        Properties prop = new Properties();
        String fileName = "app.config";
        try {
            String path = new File(fileName).getCanonicalPath();
            FileInputStream fis = new FileInputStream(path);

            prop.load(fis);
        } catch (Exception ex) {
            Console.writeLine("Something went wrong: " + ex.getMessage());
        }

        //The real work starts here
        //load all app settings first;
        env = prop.getProperty("Environment");
        redirect = prop.getProperty("RedirectUri");
        clientId = prop.getProperty("ClientId");
        clientSecret = prop.getProperty("ClientSecret");
        scopes = prop.getProperty("Scope");
        grantType = prop.getProperty("grant");
        rop_username = prop.getProperty("rop_username");
        rop_password = prop.getProperty("rop_password");


        AuthorizationUri = env + "/apisecurity/connect/authorize";  // Authorization code endpoint
        RedirectUri = redirect;  // Callback endpoint
        RefreshUri = env + "/apisecurity/connect/token";  // Get tokens endpoint

        //Get authorization code for token api request, performs token request after auth code is populated
        //After token fetch has completed Create User Request will follow in method see GetTokensByGrantType() method
        RunGetTokens(grantType);
    }

    private static AccessTokenValues GetOauthTokens_ClientCredentials() {
        try {
            // Construct the client credentials grant
            AuthorizationGrant clientGrant = new ClientCredentialsGrant();

            // The credentials to authenticate the client at the token endpoint
            ClientID clientID = new ClientID(clientId);
            Secret _clientSecret = new Secret(clientSecret);
            ClientAuthentication clientAuth = new ClientSecretBasic(clientID, _clientSecret);

            // The request scope for the token (may be optional)
            Scope scope = new Scope(scopes);

            // The token endpoint
            //client_id={0}&client_secret={1}&grant_type=client_credentials&redirect_uri={2}
            String tokenConnectUrl = B2BAccessBody;
            tokenConnectUrl = tokenConnectUrl.replace("{0}", clientId);
            tokenConnectUrl = tokenConnectUrl.replace("{1}", clientSecret);
            tokenConnectUrl = tokenConnectUrl.replace("{2}", RedirectUri);


            // The token endpoint
            URI tokenEndpoint = new URI(RefreshUri + "?" + tokenConnectUrl);

            // Make the token request
            TokenRequest request = new TokenRequest(tokenEndpoint, clientAuth, clientGrant, scope);

            com.nimbusds.oauth2.sdk.http.HTTPRequest httpRequest = request.toHTTPRequest();

            //Set request headers
            httpRequest.setAccept("application/json");
            httpRequest.setHeader("Method", "POST");
            httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");

            //Set response headers
            com.nimbusds.oauth2.sdk.http.HTTPResponse httpResonse = httpRequest.send();
            httpResonse.setHeader("Content-Type", "application/json");

            TokenResponse response = TokenResponse.parse(httpResonse);

            if (!response.indicatesSuccess()) {
                // We got an error response...
                TokenErrorResponse errorResponse = response.toErrorResponse();
            }

            AccessTokenResponse successResponse = response.toSuccessResponse();

            // Get the access token, the server may also return a refresh token
            AccessToken accessToken = successResponse.getTokens().getAccessToken();
            RefreshToken refreshToken = successResponse.getTokens().getRefreshToken();

            AccessTokenValues tokenValues = new AccessTokenValues();
            tokenValues.AccessToken = accessToken.getValue();
            tokenValues.Expiration = accessToken.getLifetime();
            tokenValues.RefreshToken = refreshToken != null ? refreshToken.getValue() : null;

            Console.writeLine("Completed Running Client Credentials Grant for Get Token");
            Console.writeLine("**********************TOKEN VALUES**********************");
            Console.writeLine("AccessToken " + tokenValues.AccessToken);
            Console.writeLine("RefreshToken " + tokenValues.RefreshToken);
            Console.writeLine("Expiration " + tokenValues.Expiration);

            return tokenValues;
        } catch (Exception ex) {
            return  null;
        }
    }

    public static AccessTokenValues GetOauthTokens_AuthorizationCode() {
        try {
            // Construct the code grant from the code obtained from the authz endpoint
            // and the original callback URI used at the authz endpoint
            AuthorizationCode code = new AuthorizationCode(_authorizationCode);
            URI callback = new URI(redirect);
            AuthorizationGrant codeGrant = new AuthorizationCodeGrant(code, callback);

            // The credentials to authenticate the client at the token endpoint
            ClientID clientID = new ClientID(clientId);
            Scope scope = new Scope(scopes);

            Secret clientSecretCreated = new Secret(clientSecret);
            ClientAuthentication clientAuth = new ClientSecretBasic(clientID, clientSecretCreated);

            //client_id={0}&client_secret={1}&code={2}&grant_type=authorization_code&redirect_uri={3}
            String tokenConnectUrl = AuthCodeAccessBody;
            tokenConnectUrl = tokenConnectUrl.replace("{0}", clientId);
            tokenConnectUrl = tokenConnectUrl.replace("{1}", clientSecret);
            tokenConnectUrl = tokenConnectUrl.replace("{2}", _authorizationCode);
            tokenConnectUrl = tokenConnectUrl.replace("{3}", RedirectUri);

            // The token endpoint
            URI tokenEndpoint = new URI(RefreshUri + "?" + tokenConnectUrl) ;

            // Make the token request
            TokenRequest request = new TokenRequest(tokenEndpoint, clientAuth, codeGrant, scope);
            com.nimbusds.oauth2.sdk.http.HTTPRequest httpRequest = request.toHTTPRequest();

            //Set request headers
            httpRequest.setAccept("application/json");
            httpRequest.setHeader("Method", "POST");
            httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");


            //Set response headers
            com.nimbusds.oauth2.sdk.http.HTTPResponse httpResonse = httpRequest.send();
            httpResonse.setHeader("Content-Type", "application/json");


            TokenResponse tokenResponse = OIDCTokenResponseParser.parse(httpResonse);

            if (!tokenResponse.indicatesSuccess()) {
                // We got an error response...
                TokenErrorResponse errorResponse = tokenResponse.toErrorResponse();
                Console.writeLine("errorResponse : " + errorResponse);
            }

            OIDCTokenResponse successResponse = (OIDCTokenResponse) tokenResponse.toSuccessResponse();

            // Get the ID and access token, the server may also return a refresh token
            AccessToken accessToken = successResponse.getOIDCTokens().getAccessToken();
            RefreshToken refreshToken = successResponse.getOIDCTokens().getRefreshToken();

            AccessTokenValues response = new AccessTokenValues();
            response.AccessToken = accessToken.getValue();
            response.Expiration = accessToken.getLifetime();
            response.RefreshToken = refreshToken != null ? refreshToken.getValue() : null;

            Console.writeLine("Completed Running Authorization Code Grant for Get Token");
            Console.writeLine("**********************TOKEN VALUES**********************");
            Console.writeLine("AccessToken " + response.AccessToken);
            Console.writeLine("RefreshToken " + response.RefreshToken);
            Console.writeLine("Expiration " + response.Expiration);

            return response;
        } catch (Exception ex) {
            return null;
        }
    }

    public static AccessTokenValues GetOauthTokens_ResourceOwnerPassword(String passedUsername, String passedPassword) {
        try {
            // Construct the password grant from the username and password
            String username = passedUsername;
            Secret password = new Secret(passedPassword);
            AuthorizationGrant passwordGrant = new ResourceOwnerPasswordCredentialsGrant(username, password);

            // The credentials to authenticate the client at the token endpoint
            ClientID clientID = new ClientID(clientId);
            Secret _clientSecret = new Secret(clientSecret);
            ClientAuthentication clientAuth = new ClientSecretBasic(clientID, _clientSecret);

            // The request scope for the token (may be optional)
            Scope scope = new Scope(scopes);

            // The token endpoint
            //grant_type=password&username={0}&password={1}&client_id={2}&client_secret={3}
            String tokenConnectUrl = ROPAccessBody;
            tokenConnectUrl = tokenConnectUrl.replace("{0}", passedUsername);
            tokenConnectUrl = tokenConnectUrl.replace("{1}", passedPassword);
            tokenConnectUrl = tokenConnectUrl.replace("{2}", clientId);
            tokenConnectUrl = tokenConnectUrl.replace("{3}", clientSecret);

            // The token endpoint
            URI tokenEndpoint = new URI(RefreshUri + "?" + tokenConnectUrl) ;

            // Make the token request
            TokenRequest request = new TokenRequest(tokenEndpoint, clientAuth, passwordGrant, scope);

            com.nimbusds.oauth2.sdk.http.HTTPRequest httpRequest = request.toHTTPRequest();

            //Set request headers
            httpRequest.setAccept("application/json");
            httpRequest.setHeader("Method", "POST");
            httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");

            //Set response headers
            com.nimbusds.oauth2.sdk.http.HTTPResponse httpResonse = httpRequest.send();
            httpResonse.setHeader("Content-Type", "application/json");

            TokenResponse response = TokenResponse.parse(httpResonse);

            if (! response.indicatesSuccess()) {
                // We got an error response...
                TokenErrorResponse errorResponse = response.toErrorResponse();
            }

            AccessTokenResponse successResponse = response.toSuccessResponse();

            // Get the access token, the server may also return a refresh token
            AccessToken accessToken = successResponse.getTokens().getAccessToken();
            RefreshToken refreshToken = successResponse.getTokens().getRefreshToken();

            AccessTokenValues tokenValues = new AccessTokenValues();
            tokenValues.AccessToken = accessToken.getValue();
            tokenValues.Expiration = accessToken.getLifetime();
            tokenValues.RefreshToken = refreshToken != null ? refreshToken.getValue() : null;

            Console.writeLine("Completed Running Resource Owner Password Grant for Get Token");
            Console.writeLine("**********************TOKEN VALUES**********************");
            Console.writeLine("AccessToken " + tokenValues.AccessToken);
            Console.writeLine("RefreshToken " + tokenValues.RefreshToken);
            Console.writeLine("Expiration " + tokenValues.Expiration);

            return  tokenValues;
        }
        catch (Exception ex) {
            return null;
        }
    }

    public static void RunGetTokens(String grantType) throws Exception {

        if (_tokens != null) {
            Console.writeLine("Fetching Access Token Values - DONE - Populated from previous request");
        }

        if (grantType.equals("auth_code")) {
            //get authorization code for auth_code api tokens request
            showBrowserGetAuthCode(_authorizationCode);
        }
        //b2b or rop flow
        else {
            GetTokensByGrantType();
        }
        Console.writeLine("");
    }

    private static void showBrowserGetAuthCode(String passedAuthCode) {

        if (passedAuthCode == null) {

            _uri = String.format(AuthorizationUri + CodeQueryString, clientId, clientSecret, scopes, RedirectUri);
            _uri = _uri.replace("{0}", clientId);
            _uri = _uri.replace("{1}", clientSecret);
            _uri = _uri.replace("null", scopes);
            _uri = _uri.replace("{2}", RedirectUri);


            CefApp cefApp = CefApp.getInstance();
            CefClient client = cefApp.createClient();
            CefBrowser browser = client.createBrowser(_uri, false, false);
            Component browserUI = browser.getUIComponent();
            JFrame mainFrame = new JFrame("SumTotal Java OAuth2 Login");
            mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            mainFrame.getContentPane().add(browserUI, BorderLayout.CENTER);
            mainFrame.setSize(420, 580);
            mainFrame.setVisible(true);
            browser.setFocus(true);
            mainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    mainFrame.dispose();
                    cefApp.dispose();
                }
            });

            client.addRequestHandler(new CefRequestHandler() {
                @Override
                public boolean onBeforeBrowse(CefBrowser browser, CefRequest request, boolean is_redirect) {
                    return false;
                }

                @Override
                public boolean onBeforeResourceLoad(CefBrowser browser, CefRequest request) {
                    return false;
                }

                @Override
                public CefResourceHandler getResourceHandler(CefBrowser browser, CefRequest request) {
                    String responseUrl = request.getURL();

                    if (responseUrl.contains("https://test.sumtotal.com/oidc?")) {

                        Console.writeLine("CefBrowser Response URL: " + responseUrl);
                        _authorizationCode = responseUrl.substring(responseUrl.indexOf('?') + 6, responseUrl.indexOf('&'));
                        Console.writeLine("CefBrowser _authorizationCode: " + _authorizationCode);

                        if (_authorizationCode != null) {
                            //close browser window
                            mainFrame.dispose();
                            cefApp.dispose();

                            GetTokensByGrantType();
                        }
                    }
                    return null;
                }

                @Override
                public void onResourceRedirect(CefBrowser browser, CefRequest request, StringRef new_url) {

                }

                @Override
                public boolean getAuthCredentials(CefBrowser browser, boolean isProxy, String host, int port, String realm, String scheme, CefAuthCallback callback) {
                    return false;
                }

                @Override
                public boolean onQuotaRequest(CefBrowser browser, String origin_url, long new_size, CefRequestCallback callback) {
                    return false;
                }

                @Override
                public void onProtocolExecution(CefBrowser browser, String url, BoolRef allow_os_execution) {
                    Console.writeLine("CefBrowser onProtocolExecution");
                }

                @Override
                public boolean onCertificateError(CefBrowser browser, CefLoadHandler.ErrorCode cert_error, String request_url, CefRequestCallback callback) {
                    return false;
                }

                @Override
                public void onPluginCrashed(CefBrowser browser, String pluginPath) {

                }

                @Override
                public void onRenderProcessTerminated(CefBrowser browser, TerminationStatus status) {

                }
            });
        }
        else {
            Console.writeLine("Auth Code already populated from previous request");
            GetTokensByGrantType();
        }
    }

    private static void GetTokensByGrantType() {
        Console.writeLine("Current Grant Type: " + grantType);
        Console.writeLine("");

        switch(grantType) {
            case "auth_code":
                _tokens = GetOauthTokens_AuthorizationCode();
                break;
            case "b2b":
                _tokens = GetOauthTokens_ClientCredentials();
                break;
            case "rop":
                _tokens = GetOauthTokens_ResourceOwnerPassword(rop_username, rop_password);
                // code block
                break;
        }

        Console.writeLine("**********************Finished getting tokens**********************");
        Console.writeLine("");
        Console.writeLine("");

        Console.writeLine("Starting Advanced User Create");
        UserOperations userOperations = new UserOperations();
        userOperations.CreateUserAdvanced(_tokens.AccessToken);
    }

    static class Console {

        static void writeLine(String a) {
            System.out.println(a);
        }
    }
}
