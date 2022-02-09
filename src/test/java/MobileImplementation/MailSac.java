package MobileImplementation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;

public class MailSac {
    public static void createInbox(String email){
        RestAssured.baseURI = "https://mailsac.com/inbox/" + email;

        RequestSpecification httpRequest = RestAssured.given();


        httpRequest.header("Mailsac-Key", "k_XBMIoKOf4PR8tsw2euxDEdVvFC8X0to8LADwf05e");

        Response response = httpRequest.request(Method.GET);
        response.getHeader("Content-Type");
        String responseBody = response.getBody().asString();




    }

    public static String getOTP(String email){

        RestAssured.baseURI = "https://mailsac.com/api/addresses/" + email + "/messages";
        RequestSpecification httpRequest = RestAssured.given();


        httpRequest.header("Mailsac-Key", "k_XBMIoKOf4PR8tsw2euxDEdVvFC8X0to8LADwf05e");

        Response response = httpRequest.request(Method.GET);
        response.getHeader("Content-Type");
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        //jsonPath.prettyPrint();

        ArrayList<HashMap<String, String>> arraylist = jsonPath.get();


        HashMap<String, String> hashMap = arraylist.get(0);


        String emailId = hashMap.get("_id");
        return getMessages(email, emailId);




    }

    public static String getMessages(String email, String emailId){

        String OTP = null;
        RestAssured.baseURI = "https://mailsac.com/api/text/" + email + "/" + emailId;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Mailsac-Key", "k_XBMIoKOf4PR8tsw2euxDEdVvFC8X0to8LADwf05e");

        Response response = httpRequest.request(Method.GET);
        response.getHeader("Content-Type");
        String responseBody = response.getBody().asString();
        if(responseBody.contains("Your OTP to continue:")){
            OTP = responseBody.substring(responseBody.indexOf(": ")+2);

            //System.out.println("zWIVHUYA pRINTKING "+OTP);
        }

        return OTP;

    }

    public static String getEmail(String email, String emailId){

        String OTP = null;
        RestAssured.baseURI = "https://mailsac.com/api/text/" + email + "/" + emailId;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Mailsac-Key", "k_XBMIoKOf4PR8tsw2euxDEdVvFC8X0to8LADwf05e");

        Response response = httpRequest.request(Method.GET);
        response.getHeader("Content-Type");
        String responseBody = response.getBody().asString();
        if(responseBody.contains("Your OTP to continue:")){
            OTP = responseBody.substring(responseBody.indexOf(": ")+2);

            //System.out.println("zWIVHUYA pRINTKING "+OTP);
        }

        return responseBody;

    }

    public static String getOTPs(String email){

        RestAssured.baseURI = "https://mailsac.com/api/addresses/" + email + "/messages";
        RequestSpecification httpRequest = RestAssured.given();


        httpRequest.header("Mailsac-Key", "k_XBMIoKOf4PR8tsw2euxDEdVvFC8X0to8LADwf05e");

        Response response = httpRequest.request(Method.GET);
        response.getHeader("Content-Type");
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        //jsonPath.prettyPrint();

        ArrayList<HashMap<String, String>> arraylist = jsonPath.get();


        HashMap<String, String> hashMap = arraylist.get(0);


        String emailId = hashMap.get("_id");
        return getEmail(email, emailId);




    }



}

