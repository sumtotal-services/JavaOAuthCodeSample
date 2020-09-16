import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class UserOperations {

    private static final String USER_CREATE_ADVANCED_URL = "/apis/api/v1/advanced/users";
    private static final String USER_GET_ADVANCED_URL = "/apis/api/v1/advanced/users";
    private static String UserPostJson = "";

    public void CreateUserAdvanced(String accessToken) {
        Properties prop = new Properties();
        String fileName = "app.config";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {

        }

        try {
            prop.load(is);
        } catch (IOException ex) {

        }

        String env = prop.getProperty("Environment");
        String Post_Url = env + USER_CREATE_ADVANCED_URL;
        String Get_Url = env + USER_GET_ADVANCED_URL;

        try {
            Console.writeLine("Performing Advanced User Create POST");
            Console.writeLine("************************************");

            UserResponseObject createdUser = this.sendUserCreatPOST(Post_Url, accessToken);
            Get_Url += "/" + createdUser.getUserId();

            if (createdUser.getUserId() == null) {
                ObjectMapper mapper = new ObjectMapper();
                String validationMessages = mapper.writeValueAsString(createdUser.getValidationMessages());
                Console.writeLine("Advanced User Create Completed with Errors");
                Console.writeLine("Reponse: " + createdUser.getResponse());
                Console.writeLine("ValidationMessages: " + validationMessages);
                return;
            }

            Console.writeLine("Advanced User Create Completed Succesfully");
            Console.writeLine("************************************");
            Console.writeLine("");

            Console.writeLine("Performing Advanced User GET");
            Console.writeLine("************************************");
            String user = GetUserFromAdvancedPost(Get_Url, accessToken);
            Console.writeLine("Advanced User GET Completed Succesfully");
            Console.writeLine("User: " + user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GetUserFromAdvancedPost(String url, String accessToken) throws IOException {
        String userCredentials = "Bearer " + accessToken;
        ObjectMapper mapper = new ObjectMapper();

        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Authorization", userCredentials);
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("Accept", "*/*");

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httpGet);
        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        UserGetObject user = mapper.readValue(responseBody, UserGetObject.class);

        return responseBody;
    }

    static class Console {

        static void writeLine(String a) {
            System.out.println(a);
        }
    }

    private UserResponseObject sendUserCreatPOST(String url, String accessToken) throws IOException {

        //build user object
        //assign one by one for debugging purpose
        UserObject user = new UserObject(null,null,null);
        user.FirstName = "Jon";
        user.LastName = "Wayne";

        user.UserLogin = new UserLogin(null, null);
        user.UserLogin.Username = "bobcharles";
        user.UserLogin.UserPassword = "password123";

        //serliaze user object
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        UserPostJson = mapper.writeValueAsString(user);

        String userCredentials = "Bearer " + accessToken;
        byte[] postData = UserPostJson.getBytes();

        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Authorization", userCredentials);
        httppost.setHeader("Content-Type", "application/json");;

        StringEntity entity = new StringEntity(UserPostJson);

        httppost.setEntity(entity);

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

        UserResponseObject userResponse = mapper.readValue(responseBody.getBytes(), UserResponseObject.class);
        return  userResponse;
    }
    public class UserObject {

        @JsonProperty("firstName")
        public String FirstName;
        @JsonProperty("lastName")
        public String LastName;
        @JsonProperty("userLogin")
        public UserLogin UserLogin;

        public UserObject(String FirstName, String LastName, UserLogin UserLogin) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.UserLogin = UserLogin;
        }
        // Getter
        public String getfirstName() {
            return FirstName;
        }

        // Setter
        public void setfirstName(String newName) {
            this.FirstName = newName;
        }

        // Getter
        public UserLogin getuserLogin() {
            return UserLogin;
        }

        // Setter
        public void setlastName(UserLogin newName) {
            this.UserLogin = newName;
        }

        // Getter
        public String getlastName() {
            return LastName;
        }

        // Setter
        public void setlastName(String newName) {
            this.LastName = newName;
        }
    }

    public class UserLogin {
        @JsonProperty("username")
        public String Username;
        @JsonProperty("userPassword")
        public String UserPassword;

        UserLogin(String Username, String UserPassword) {
            this.Username = Username;
            this.UserPassword = UserPassword;
        }

        // Getter
        public String getusername() {
            return Username;
        }

        // Setter
        public void setusername(String newName) {
            this.Username = newName;
        }

        // Getter
        public String getuserPassword() {
            return UserPassword;
        }

        // Setter
        public void setuserPassword(String newName) {
            this.UserPassword = newName;
        }
    }
}
