package tests;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import payloads.User;
import utilities.Dataproviders;

public class DDT {

    @Test(priority = 1, dataProvider = "AllData", dataProviderClass = Dataproviders.class)
    // Parameters should be passed in the same Order as in the excel sheet
    public void testPostUser(String userID, String userName, String firstName, String lastName, String userEmail, String userPassword, String userPhone){
        User userPayLoad = new User();

        userPayLoad.setId(Integer.parseInt(userID));
        userPayLoad.setUsername(userName);
        userPayLoad.setFirstname(firstName);
        userPayLoad.setLastname(lastName);
        userPayLoad.setEmail(userEmail);
        userPayLoad.setPassword(userPassword);
        userPayLoad.setPhone(userPhone);

        Response response = UserEndPoints.createUser(userPayLoad);
//        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = Dataproviders.class)
    public void testDeleteUserByName(String userName){

        Response response = UserEndPoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);


    }

}
