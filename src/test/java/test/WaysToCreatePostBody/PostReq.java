package test.WaysToCreatePostBody;
import groovy.json.JsonOutput;
import org.testng.annotations.Test;
import test.Config;

import java.sql.SQLOutput;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostReq {



    @Test
        public void PostData() {
        Pojo hm = new Pojo();
        hm.setName("Anmol");
        hm.setJob("QA");

given()
        .contentType("application/json")
        .body(hm)
        .when()
        .post(Config.BASE_URL + "/users")
        .then()
        .statusCode(201)
        .body("name",equalTo("Anmol Dahal"))
;
    }
    @Test
    public void DelUser(){
        given()
                .contentType("application/json")

                .when()
                .delete(Config.BASE_URL + "/users"+ "/2")

                .then()
                .statusCode(204)

        ;
    }


}
