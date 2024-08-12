package endpoints;

// Create User (POST): https://petstore.swagger.io/v2/user
// Get User (GET): https://petstore.swagger.io/v2/user/{username}
// Update User (PUT): https://petstore.swagger.io/v2/user/{username}
// Delete User (Delete): https://petstore.swagger.io/v2/user/{username}
// Path Parameter: {username}

public class Routes {
    // User Module
    public static String base_url = "https://petstore.swagger.io/v2";

    public static String post_url = base_url + "/user";

    public static String get_url = base_url + "/user/{username}";

    public static String put_url = base_url + "/user/{username}";

    public static String delete_url = base_url + "/user/{username}";

}
