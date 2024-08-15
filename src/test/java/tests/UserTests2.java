package tests;

import com.github.javafaker.Faker;
import endpoints.UserEndPoints2;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.User;

public class UserTests2 {

    Faker faker;
    User userPayload;

    public Logger logger;

    @BeforeClass
    public void setUp(){

        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode()); // Generate Random IDs
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        // Logs:
        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){
        logger.info("**********************************************************");
        logger.info("******************** Start og logging ********************");
        logger.info("******************** Creating a new user ********************");
        System.out.println("Execution Started");
        System.out.println("Create User");
        System.out.println("Username: "+userPayload.getUsername());
        Response response = UserEndPoints2.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******************** User is created ********************");
        Assert.fail("failing the case");


    }

    @Test(priority = 2)
    public void testGetUserByName(){
        logger.info("******************** Reading user info ********************");
        System.out.println("Read User Data");
        System.out.println("User ID: "+userPayload.getId());
        System.out.println("Username: "+userPayload.getUsername());
        Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
        response.then().log().all();
        response.statusCode();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******************** User info is displayed ********************");

    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        logger.info("******************** Updating a user ********************");

        System.out.println("Update User Data");
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(), this.userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);


        testGetUserByName();
//        System.out.println("User Data after Update");
//        Response responseAFterUpdate = UserEndPoints2.readUser(this.userPayload.getUsername());
//        response.then().log().all();
//        Assert.assertEquals(responseAFterUpdate.getStatusCode(), 200);
        logger.info("******************** User updated ********************");

    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        logger.info("******************** Deleting a user ********************");

        System.out.println("Delete User Data");
        System.out.println("User ID: "+userPayload.getId());
        System.out.println("Username: "+userPayload.getUsername());
        Response response = UserEndPoints2.deleteUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******************** User deleted ********************");
        logger.info("******************** End Of Logger ********************");
        logger.info("**********************************************************");

    }

}
