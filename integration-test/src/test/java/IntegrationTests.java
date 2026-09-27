import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public interface IntegrationTests {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:4003";
    }

}
