package Restassured;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateUser {

    @Test
    public void creationOfUser() throws JSONException {

        Faker fake = new Faker();
        JSONObject requestBody = new JSONObject();
        JSONArray department = new JSONArray();
        department.put("8ecd4214-b54e-467f-9012-564c33ffd950");
        department.put("8ecd4214-b54e-467f-9012-564c33ffd950");



        requestBody.put("contactNumber",fake.phoneNumber().cellPhone());
        requestBody.put("firstName",fake.name().firstName());
        requestBody.put("lastName",fake.name().lastName());
        requestBody.put("role", "ADMINISTRATOR");
        requestBody.put("organization", "31782b21-0f1a-46c2-a55e-cb5a9a95d6dd");
        requestBody.put("departments",department);
        requestBody.put("email","lucky014@cmdq.co.za");

        Map<String, String> header = new HashMap<>();
        header.put("authorization","Bearer eyJraWQiOiJPQXdwMGF2U0xhakFwV1pwM0xVK2p0Z1FOUVhiVnVyRUZ3ZWJkdGVQUlJNPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmNzg1NWYzMy1jOTliLTQyMmUtYjVhMy0zNWU1YWNiNzZhZTkiLCJhdWQiOiI1MDNkOWoxcTQ0djRsODdpZDdoNW45cTNodSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJldmVudF9pZCI6ImRiNGQ2ODMzLTZiMGUtNGNiYS04OWQzLTg1MzU2YjkwOTJlNSIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjQ1MDI1NDgxLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuZXUtd2VzdC0xLmFtYXpvbmF3cy5jb21cL2V1LXdlc3QtMV91NWhOUE9GdlAiLCJjb2duaXRvOnVzZXJuYW1lIjoiZjc4NTVmMzMtYzk5Yi00MjJlLWI1YTMtMzVlNWFjYjc2YWU5IiwiZXhwIjoxNjQ1MDI5MDgxLCJpYXQiOjE2NDUwMjU0ODEsImVtYWlsIjoibHVja3kwMTFAY21kcS5jby56YSJ9.Ni87izKLsDzrD3BvEetRZBgr0x7iCnIBPjwk032uPqBmzTA9f8k-zZjGzGqb9_NXrUdsu-RUr3-bTrmXFcwNrGbry15-_DwaX4V-2XUodDC72AKL7rSBtUiNiQ11GZ-2W9y0fw9ePEKS_Y2SbpxHWy-zQ42bMwo9C1JYb7hVcHx0jBwO3pGQvkwcYcW4qXXkhY71r80Fj40kzNzwkVHnpjiRb-1q3xsT0Z4hGso1I5G4y7IiQw8u-IARqGD_GlSrDnozRHJBlrX5RaVsrXFZmhJI0T_wp08AaZ-a9g7uDQFE82wKQNLge5ZhXBxN1Z_0fcXhH_GJy835ZH9zwtdZ_A");

        Response response = RestAssured.given().
                baseUri("https://api.uatwamly.co.za/wamly/v1/add/user").
                headers(header).contentType("application/json").
                when().body(requestBody.toString()).post();

        response.andReturn().getBody().prettyPrint();






    }


}
