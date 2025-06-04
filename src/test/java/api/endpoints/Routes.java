package api.endpoints;
//This class is for minitaining the URL
/*
Swagger URI: https://petstore.swagger.io
Create user(Post): https://petstore.swagger.io/v2/user
Get user(Get): https://petstore.swagger.io/v2/user/{username}
Update user(Put): https://petstore.swagger.io/v2/user/{username}
Delete user(Delete): https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {
    public static  String base_url="https://petstore.swagger.io/v2/";

   //user module
    public static String post_url=base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";
}
