package test;
/*
given()
content type , set cookies , add auth, add param, set headers info etc..

when()
get,post,put, delete

then()
validate status code, extract response , extract headers cookies and response body...
*/

import org.testng.annotations.Test;
import java.util.HashMap;


import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HTTPRequests {
    int id; //global variable for class Httpreq

  @Test
          void GetUsers()
    {
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")


                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();
    }
    @Test

    void PostUser() {
        HashMap hm = new HashMap();
        hm.put("name", "");
        hm.put("job", "QA engineer");

        id = given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post(Config.BASE_URL + "/users")
                .jsonPath().getInt("id");
    }

 @Test
    void GetUser2() {
        given()
                .when()
                .get(Config.BASE_URL+ "/users")

                .then()
                .statusCode(200)

                .log().all();




    }
    @Test
    void Get_user_with_noPageno(){
      given()
              .when()
              .get(Config.BASE_URL+ "/users/0")
              .then()
              .statusCode(404)

              .log().all()
      ;
    }



}

