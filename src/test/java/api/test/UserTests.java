package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    User userpayload;

    @BeforeClass
    public  void setupData(){
        faker=new Faker();
        userpayload=new User();

        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());
        userpayload.setPassword(faker.internet().password(5,10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
        Response response =UserEndPoints.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2)
    public void testGetUserByName(){
      Response response=  UserEndPoints.readUser(this.userpayload.getUsername());
      response.then().log().all();
      response.statusCode();
      Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void testupdateUserByName(){
        //update data using payload
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());

        Response response =UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        //check data after update
        Response responseAfterupdate=  UserEndPoints.readUser(this.userpayload.getUsername());
        response.then().log().all();
        response.statusCode();
        Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
