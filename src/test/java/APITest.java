import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest {
    @Test
     void test1(){
        Response top250 = get("https://imdb-api.com/en/API/Top250TVs/k_8rtu00s8");
        System.out.print(top250.asString());
        System.out.print("                      ");
        System.out.println("Status Code "+top250.getStatusCode());
        Response rating = get("https://imdb-api.com/en/API/UserRatings/k_8rtu00s8/tt1375666");
        System.out.println(rating.asString());
        System.out.println("Status Code "+rating.getStatusCode());



    }
}
