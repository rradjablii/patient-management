import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthIntegrationTests implements IntegrationTests{

    @Test
    public void shouldReturnOkWithValidToken(){
        String loginPayload = """
                {
                    "email": "testuser@test.com",
                    "password": "wrongpassword"
                }
                """;

        given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(401);

    }

}
