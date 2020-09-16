![Sumtotal](https://plsadaptive.s3.amazonaws.com/gmedia/jpg/_i_a6a0bc8dba67fd7c5a4a86c08c49ff20_sumtotal_logo.jpg)
# Introduction
This Java sample code base is intended to demonstrate the authentication and basic functionality of Sumtotal’s Advanced User related Rest API. It utilizes SumTotal’s OAuth 2.0 authentication to obtain an access token via User Authorization, Client Credentials (B2B) or Password Credentials (ROP) 
## Prerequisites
- SumTotal Admin account (Permission level tied to OAuth Client Configuration)
- Java complaint IDE, recommend using [IntelliJ IDE](https://www.jetbrains.com/idea/)
- [Java](https://www.java.com/en/) (Use 'java -version' cmd command to check java version)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.getpostman.com)
## Swagger
- https://{site-url}/apis/swagger/ui/index
- https://{site-url}/apis/documentation
## Authentication Types
### [Authorization Code](https://www.oauth.com/oauth2-servers/server-side-apps/authorization-code/)
 The authorization code is a temporary code that the client will exchange for an access token. The code itself is obtained from the authorization server where the user gets a chance to see what the information the client is requesting, and approve or deny the request.
### [Client Credentials](https://oauth.net/2/grant-types/client-credentials/)
The Client Credentials grant type is used by clients to obtain an access token outside of the context of a user. This is typically used by clients to access resources about themselves rather than to access a user's resources.
### [Resource Owner Password](https://www.oauth.com/oauth2-servers/access-tokens/password-grant/)
The Password grant is used when the application exchanges the user’s username and password for an access token. This is exactly the thing OAuth was created to prevent in the first place, so you should never allow third-party apps to use this grant
## Functionality
1. Authorization Code
    - Create User (POST > apis/api/v1/advanced/users)
    - Get Users (GET > apis/api/v1/advanced/users)
2. Client Credentials (B2B)
    - Create User (POST > apis/api/v1/advanced/users)
    - Get Users (GET > apis/api/v1/advanced/users
3. Resource Owner Password (ROP)
    - Create User (POST > apis/api/v1/advanced/users)
    - Get Users (GET > apis/api/v1/advanced/users)
## Setup Guide
1. OAuth Configuration 
    - Login in as an Admin
    - Administration > Common Objects > Configuration > OAuth Configuration
    - Click 'Add' to create a new OAuth Client
    - Enter desired Client ID
    - PKCE disabled (Enabling this will block API calls)
    - Enter secure Client Secret
    - Select desired scopes 
        - allapis (Access SumTotal Rest APIs)
        - odatapis (Access to OData APIs)
        - offline_access (Responsible for granting a refresh token)
    - Add a redirect URL you wish to use (Used for Authorization Code Grant Type)
    - Submit
## Code Structure
1. Main.cs
    - The start and end of your Java console application.
    - The Main method is where you are able to create objects and execute methods throughout your solution.
    - Reads weather or not you want to use Client Credentials or Authorization code authentication, this is indicated by the 'b2b' key (Boolean) within your App.Config.
    - Contains the relevant functions required to obtain access tokens & refresh tokens.
2. AccessTokenValues.cs
    - Class that represents Access Token properties and values.
    - Contains Access Token value, refresh token and expiration lifetime.
3. UserGetObject.cs
    - Serializable model that contains property definition for advanced user GET request.
4. UserResponseObject.cs
    - Serializable User model returned for advanced user create (POST).
5. UserOperations.cs
    - Contains methods relating to user operations.
        - Create Advanced User POST (Authorization Code, Client Credentials and Password Credentials).
        - Get Advanced User (Authorization Code, Client Credentials and Password Credentials).
    - Creates a user object that reads from App.Config.
6. app.config
    - Configuration needed in order to successfully execute the program.
```sh
  ClientId = sumtotal_auth
  ClientSecret = sumtotal_auth
  Scope = allapis
  Environment = https://au05sales.sumtotaldevelopment.net
  RedirectUri = https://test.sumtotal.com/oidc
  grant = auth_code
  rop_username = admin
  rop_password = mCudGP0RfCgiVHm24wIsrq6dixH154uXEXz3fneW+dpuOJMFD0rQT3xozegahv8aUlBtSqx7w4/FOcLDgz7UeQ==
  
  //the de-encrypted ROP password is set to - Beluga!Savin
  //Change 'grant' to one of Avalabile grant type values:
  //Authorization Code - auth_code
  //Client Credentials - b2b
  //Resrouce Owner Password - rop
  
  //**NOTE FOR DEVELOPERS**:
  //if the application returns a NullReferenceError on app run then be sure to check
  //that the clientId, clientSecret, Environment, Scope and RedirectUrl values specified are correct and
  //do actually exist in the propgataion environment you are running against
```
## Example Requests & Responses
##### AUTHENTICATION REQUEST
    - POST https://{site-url}/apisecurity/connect/token HTTP/1.1
        Accept: application/json
        Content-Type: application/x-www-form-urlencoded
        Host: {site-url}
        Content-Length: 73
        Expect: 100-continue
        Connection: Keep-Alive
        
        client_id=b2b_oidc&client_secret=b2b_secret&grant_type=client_credentials
        
##### AUTHENTICATION RESPONSE
    {"access_token":"eyJhbGciOiJSUzI1NiIsImtpZCI6IkEwQjVCMUFCMTUzMjI1MzRDNUIxQUU3QTdEMjZDRkI3NDYzNTIwMzMiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJvTFd4cXhVeUpUVEZzYTU2ZlNiUHQwWTFJRE0ifQ.eyJuYmYiOjE1NzExMzU3ODgsImV4cCI6MTU3MTE0Mjk4OCwiaXNzIjoiaHR0cHM6Ly9hdTA0c2FsZXMuc3VtdG90YWxkZXZlbG9wbWVudC5uZXQvYXBpc2VjdXJpdHkiLCJhdWQiOlsiaHR0cHM6Ly9hdTA0c2FsZXMuc3VtdG90YWxkZXZlbG9wbWVudC5uZXQvYXBpc2VjdXJpdHkvcmVzb3VyY2VzIiwiZXh0YXBpcyJdLCJjbGllbnRfaWQiOiJiMmJfb2lkYyIsImJyb2tlcnNlc3Npb24iOiJkZjZhMzI5Zi02MjRkLTRkN2ItODBkYy1kNDdhM2U1ODVkYzIiLCJzY29wZSI6WyJhbGxhcGlzIl19.VKurjJBPar7K-KjExPJhInA9T5aIpm6NZyjVCaLLN5Dt4QJkQZTZq7p0EhEfzshtqVck2GSba-pxLNkPLbeONkBKTcYQGRKUgzlk787NPnn4_fSHCOxy-LDykIbv6G_zWcT3RW9_DE4ap5t2tmTPPgEHi3huYx_YabYL4WSpSslbs7tttIi1qI2m9NpN3apsT8uMT7izr5PbmrHGGWPhBI-lmwjx2l2Y8mh62ErPm281VSYVSrTkRPPSQHrkySLskYYiGXy0zUZuIa5abveTnTqFH9uxWL1Nt-wuC4AgRhacJTcmdaBynN8mguvQaL64fcNTt1yl9Tnf2T6XFDKogQ","expires_in":7200,"token_type":"Bearer","scope":"allapis"}
    
##### CREATE ADVANCED USER REQUEST
    POST https://{site-url}/apis/api/v1/advanced/users HTTP/1.1
    
    Authorization: Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkEwQjVCMUFCMTUzMjI1MzRDNUIxQUU3QTdEMjZDRkI3NDYzNTIwMzMiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJvTFd4cXhVeUpUVEZzYTU2ZlNiUHQwWTFJRE0ifQ.eyJuYmYiOjE1NzA4NzUxNTAsImV4cCI6MTYxNDA3NTE1MCwiaXNzIjoiaHR0cHM6Ly9hdTEwaW50LnN1bXRvdGFsZGV2ZWxvcG1lbnQubmV0L2FwaXNlY3VyaXR5IiwiYXVkIjpbImh0dHBzOi8vYXUxMGludC5zdW10b3RhbGRldmVsb3BtZW50Lm5ldC9hcGlzZWN1cml0eS9yZXNvdXJjZXMiLCJleHRhcGlzIl0sImNsaWVudF9pZCI6InN1bXRvdGFsX29pZGNhIiwic3ViIjoiYWRtaW5pc3RyYXRvciIsImF1dGhfdGltZSI6MTU3MDg3NTE0NiwiaWRwIjoibG9jYWwiLCJuYW1lIjoiYWRtaW5pc3RyYXRvciIsInVzZXJuYW1lIjoiYWRtaW5pc3RyYXRvciIsInJvbGUiOiJQb3J0YWwgVXNlciIsInRlbmFudCI6IkFVMTBfSU5UX1RFU1QiLCJicm9rZXJzZXNzaW9uIjoiYzJkZjYyMTBmNDBkNGNlNTljMGUwZmYyZjRmOTE2MzkiLCJjdWx0dXJlIjoiZW4tVVMiLCJsYW5ndWFnZSI6ImVuLXVzIiwiZGF0ZWZvcm1hdCI6Ik1NL2RkL3l5eXkiLCJ0aW1lZm9ybWF0IjoiaGg6bW0gYSIsInVzZXJpZCI6IjEiLCJwZXJzb25wayI6Ii0xIiwiZ3Vlc3RhY2NvdW50IjoiMCIsInVzZXJ0aW1lem9uZWlkIjoiQW1lcmljYS9OZXdfWW9yayIsInByb3Blcm5hbWUiOiJTeXN0ZW0rQWRtaW4iLCJzY29wZSI6WyJwcm9maWxlIiwib3BlbmlkIiwiYWxsYXBpcyJdLCJhbXIiOlsicHdkIl19.Xfy4v7L9jLSyghS3NBjYC12h1goc-Sv12KSAxguVr9b_jOQezATPatbr8l4pS8iQXRyNqnu5BIdafKd7FzLk_tjYkSpSdDhjDdhUY6R3IZvBJDIzqdablVCBzBi2ZQPUwwiJn-RBI2J289VmEY9YLh7zy7QrD53aQ3-1NzUmj1BQdJkyFXtQgqOCDtK9ocSQ4voL7od-B8_8oyxtqWpteXVV6r4gqos8KkJc9-jh2IHGRAnMayCZuL7oSTcoDhYDWmLUiSatFI2UUmHbFGYU53ig6vSaswideIe8mr-qyIbVS9gaXf7FGKoHjD0wXK6P4qXGo4RpevbS9bGNeak9hg
    
    Content-Type: application/json
    Host: {site-url}
    Content-Length: 216
    Expect: 100-continue
    Connection: Keep-Alive
    {"loginName":"sampleAPP8","userId":"","password":"p","domainId":-1,"userTypeId":3,"usersecurityRoleId":-100,"firstName":"TEST","lastName":"TEST","email":"test8@testing.com","languageId":1,"timeZoneId":8,"status":"1"}
    
##### CREATE ADVANCED USER RESPONSE
   
    {
        "validationMessages": [],
        "response": "User created",
        "userId": 123123123,
        "status": 2
    }
    
##### GET ADVANCED USERS REQUEST
    
    GET https://{site-url}/apis/api/v1/advanced/users HTTP/1.1
    
    Authorization: Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkMyNTFGQzY0REExNDkxOTgxREIxQUIzQjVGNTkwNUQxRjlBRkNEQkIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJ3bEg4Wk5vVWtaZ2RzYXM3WDFrRjBmbXZ6YnMifQ.eyJuYmYiOjE1NzExNDQ4OTcsImV4cCI6MTU3MTE0ODQ5NywiaXNzIjoiaHR0cDovL3N0cy1kZXYvYXBpc2VjdXJpdHkiLCJhdWQiOlsiaHR0cDovL3N0cy1kZXYvYXBpc2VjdXJpdHkvcmVzb3VyY2VzIiwiZXh0YXBpcyJdLCJjbGllbnRfaWQiOiJzdW10b3RhbF9wb3dlcmJpIiwic3ViIjoiYWRtaW4iLCJhdXRoX3RpbWUiOjE1NzExNDQ4OTUsImlkcCI6ImxvY2FsIiwibmFtZSI6ImFkbWluIiwidXNlcm5hbWUiOiJhZG1pbiIsInJvbGUiOiJQb3J0YWwgVXNlciIsInRlbmFudCI6InN0cy1kZXYiLCJicm9rZXJzZXNzaW9uIjoiNDk1YTY2MTY5ZmE4NDJlNGEzMmM5YjQ1M2RjYzQ3MGUiLCJjdWx0dXJlIjoiZW4tVVMiLCJsYW5ndWFnZSI6ImVuLXVzIiwiZGF0ZWZvcm1hdCI6Ik1NL2RkL3l5eXkiLCJ0aW1lZm9ybWF0IjoiaGg6bW0gYSIsInVzZXJpZCI6IjEiLCJwZXJzb25wayI6Ii0xIiwiZ3Vlc3RhY2NvdW50IjoiMCIsInVzZXJ0aW1lem9uZWlkIjoiRXVyb3BlL1p1cmljaCIsInByb3Blcm5hbWUiOiJIZWF0aGVyK1Jvc2UiLCJwaG90b3VybCI6IjE5ZTM1MzNiYWY5YTQ3YTc5YjBlNjVlZTU4NTc0ZTM4LnBuZyIsInNjb3BlIjpbInByb2ZpbGUiLCJvcGVuaWQiLCJhbGxhcGlzIl0sImFtciI6WyJwd2QiXX0.KUk9booNAjrwk84cLcVSAOGdAu5sA3duj8xCvJ1B74EbJVRWRCy_O5ZpWUIojLzOOeOXrUGJ8yiwnGOMS2Ih5x-EFERARAo3nXHBHlDxd-nbYoyG5_F3DBf-Zcat9isKd2rW8mvT0b1gJ4PQSb4PGnGG7wd3jCM2_sqelWAn1GnhIKNQPHs2K5Z6_YFT-epj_toiWYfleg0G50Kb2OPL5dtCK7_jNZskdUeGaX7ZDHwi9Px8nOabuUrGNl-NbBDRnOajm8YoyGHeR3-mUtOrX4SO78MnjtqZoV0gRfc6G6nmrXyePFr8PsBiFPR-MCH_5SBtJmzdsftvy5JfbWOdVA
    
    Content-Type: application/x-www-form-urlencoded
    Host: {site-url}
##### GET ADVANCED USERS RESPONSE
    {
      "userId": "string",
      "personId": 0,
      "active": true,
      "firstName": "string",
      "middleName": "string",
      "lastName": "string",
      "fullName": "string",
      "firstNameNative": "string",
      "lastNameNative": "string",
      "friendlyName": "string",
      "timezoneId": 0,
      "languageId": 0,
      "currencyId": 0,
      "ethnicityCode": "string",
      "genderCode": "string",
      "startDate": "2020-09-16T07:34:44.269Z",
      "endDate": "2020-09-16T07:34:44.269Z",
      "lastReviewDate": "2020-09-16T07:34:44.269Z",
      "companyCode": "string",
      "companyName": "string",
      "statusCode": 0,
      "typeCode": 0,
      "birthDate": "2020-09-16T07:34:44.270Z",
      "prefixCode": "string",
      "prefixText": "string",
      "suffixCode": "string",
      "suffixText": "string",
      "noteText": "string",
      "imagePath": "string",
      "govtId": "string",
      "personDescription": "string",
      "url": "string",
      "publishCalendar": true,
      "internalInd": true,
      "deleted": true,
      "welcomeEmailEnabled": true,
      "homeAddress": {
        "email1": "string",
        "email2": "string",
        "address1": "string",
        "address2": "string",
        "address3": "string",
        "city": "string",
        "stateName": "string",
        "county": "string",
        "country": "string",
        "zip": "string",
        "phone": "string",
        "phoneExt": "string",
        "pagerNumber": "string",
        "fax1": "string",
        "fax2": "string",
        "isPrimary": true,
        "mobile": "string",
        "emailFormat": true,
        "emergency": "string",
        "twitterURL": "string",
        "linkedInURL": "string",
        "facebookURL": "string",
        "googlePlusURL": "string"
      },
      "businessAddress": {
        "email1": "string",
        "email2": "string",
        "address1": "string",
        "address2": "string",
        "address3": "string",
        "city": "string",
        "stateName": "string",
        "county": "string",
        "country": "string",
        "zip": "string",
        "phone": "string",
        "phoneExt": "string",
        "pagerNumber": "string",
        "fax1": "string",
        "fax2": "string",
        "isPrimary": true,
        "mobile": "string",
        "emailFormat": true,
        "emergency": "string",
        "twitterURL": "string",
        "linkedInURL": "string",
        "facebookURL": "string",
        "googlePlusURL": "string"
      },
      "personDomain": [
        {
          "domainId": 0,
          "userSecurityRoleId": 0,
          "isPrimary": true,
          "deleted": 0,
          "code": "string"
        }
      ],
      "personOrganization": [
        {
          "organizationId": 0,
          "isPrimary": true,
          "joiningDate": "2020-09-16T07:34:44.270Z",
          "code": "string",
          "deleted": 0,
          "mainOrganization": true
        }
      ],
      "personJob": [
        {
          "jobTemplateId": 0,
          "isPrimary": true,
          "joiningDate": "2020-09-16T07:34:44.270Z",
          "code": "string",
          "deleted": 0
        }
      ],
      "personRelation": {
        "manager1Id": "string",
        "jobTitle": "string",
        "locationName": "string",
        "locationCode": "string"
      },
      "personELM": {
        "approverId": "string",
        "defApproverId": "string",
        "viewAllEmpsInd": true,
        "reqConfirm": 0,
        "instructorActive": 0
      },
      "personOptional": {
        "text1": "string",
        "text2": "string",
        "text3": "string",
        "text4": "string",
        "text5": "string",
        "text6": "string",
        "text7": "string",
        "text8": "string",
        "text9": "string",
        "text10": "string",
        "text11": "string",
        "text12": "string",
        "text13": "string",
        "text14": "string",
        "text15": "string",
        "text16": "string",
        "text17": "string",
        "text18": "string",
        "text19": "string",
        "text20": "string",
        "date1": "2020-09-16T07:34:44.270Z",
        "date2": "2020-09-16T07:34:44.270Z",
        "date3": "2020-09-16T07:34:44.270Z",
        "date4": "2020-09-16T07:34:44.270Z",
        "date5": "2020-09-16T07:34:44.270Z",
        "money1": 0,
        "money2": 0,
        "money3": 0,
        "money4": 0,
        "money5": 0,
        "integer1": 0,
        "integer2": 0,
        "integer3": 0,
        "integer4": 0,
        "integer5": 0,
        "float1": 0,
        "float2": 0,
        "float3": 0,
        "float4": 0,
        "float5": 0,
        "ind1": true,
        "ind2": true,
        "ind3": true,
        "ind4": true,
        "ind5": true,
        "memo1": "string",
        "memo2": "string",
        "memo3": "string",
        "memo4": "string",
        "memo5": "string",
        "decimal1": 0,
        "decimal2": 0,
        "decimal3": 0,
        "decimal4": 0,
        "decimal5": 0
      },
      "personMobileUser": {
        "isMobileEnabled": true,
        "mobileUsername": "string",
        "userPassword": "string"
      },
      "userLogin": {
        "username": "string",
        "userPassword": "string",
        "userEnabled": true,
        "currentDomainId": 0,
        "userCulture": "string",
        "userTypeId": 0,
        "isLocked": true,
        "mustChangePassword": true,
        "passwordExpiryDate": "2020-09-16T07:34:44.270Z"
      },
      "userLoginProfile": [
        {
          "loginName": "string",
          "profileUrl": "string"
        }
      ],
      "personTM": {
        "maritalCode": "string",
        "veteranCode": "string"
      }
    }