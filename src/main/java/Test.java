import com.vonage.client.VonageClient;
import com.vonage.client.verify.CheckResponse;
import com.vonage.client.verify.VerifyResponse;
import com.vonage.client.verify.VerifyStatus;

public class Test {
    public static void main(String[] args) {


//        verify();
        checkCode();

    }


    public static void verify(){
        VonageClient client = VonageClient.builder().apiKey("your_api_key").apiSecret("app_secret_key").build();

        VerifyResponse response = client.getVerifyClient().verify("mobile_number", "Vonage");

        if (response.getStatus() == VerifyStatus.OK) {
            System.out.printf("RequestID: %s", response.getRequestId());
        } else {
            System.out.printf("ERROR! %s: %s", response.getStatus(), response.getErrorText());
        }
    }


    public static void checkCode(){
        VonageClient client = VonageClient.builder().apiKey("your_api_key").apiSecret("app_secret_key").build();

        CheckResponse response = client.getVerifyClient().check("request_id", "otp_code");

        if (response.getStatus() == VerifyStatus.OK) {
            System.out.println("Verification Successful");
        } else {
            System.out.println("Verification failed: " + response.getErrorText());
        }
    }


    public static void cancel(){
        VonageClient client = VonageClient.builder().apiKey("your_api_key").apiSecret("app_secret_key").build();
        client.getVerifyClient().cancelVerification("REQUEST_ID");
        System.out.println("Verification cancelled.");
    }

}
