package com.test.hudl.pages;

import java.util.HashMap;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static com.test.hudl.utils.ConfigUtils.getPropertyByKey;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static com.test.hudl.utils.ConfigUtils.*;

public class ApiPage {
    public ApiPage() {
        loadProperties();
        RestAssured.baseURI = "https://www.hudl.com";
    }

    public static HashMap map = new HashMap();
    boolean successResponse = false;
    String firstName = null;
    String resetEmailTriggered = "false";


    /**************************************************************************************************
     Function to generate test data for API input & response validation 
     **************************************************************************************************/
    public void loginApiData(String userName, String password) {
        map.put("username", getPropertyByKey(userName));
        map.put("password", getPropertyByKey(password));
        RestAssured.basePath = "/login";

        // Data for response validation is updated in case of valid credentials
        if (userName.equals("validEmail") && password.equals("validPassword")) {
            successResponse = true;
            firstName = getPropertyByKey("userName");
        }
    }

    public void loginApiData(String userName) {
        map.put("username", getPropertyByKey(userName));
        RestAssured.basePath = "/password/reset/start";
    }

    /**************************************************************************************************
     Verify API response time & response data based on user input
     **************************************************************************************************/
    public void apiLogin(String userName, String password) {
        loginApiData(userName, password);
        given()
                .contentType("application/json")
                .body(map)
                .post()
                .then()
                .assertThat()
                .log()
                .all()
                .time(Matchers.lessThan(2000L))
                .statusCode(200)
                .body("success", equalTo(successResponse))
                .and()
                .body("firstName", equalTo(firstName));
    }

    public void resetPwdAPI(String userName) {
        loginApiData(userName);

        // Data for response validation is updated in case of valid credentials
        if (userName.equals("validEmail")) {
            resetEmailTriggered = "true";
        }

        given()
                .contentType("application/json")
                .body(map)
                .post()
                .then()
                .log()
                .all()
                .time(Matchers.lessThan(2000L))
                .assertThat()
                .statusCode(200)
                .body(equalTo(resetEmailTriggered));
    }
}
