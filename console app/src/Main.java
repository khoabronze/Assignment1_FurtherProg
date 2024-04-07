/**
 * @author <Dong Dang Khoa- s3986281>
 */



import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a new instance of Filereader
        Filereader filereader = new Filereader();

        // Call the readClaimsFromFile method with the path to your file
        HashMap<String, Claim> claims = filereader.readClaimsFromFile("claim.txt");
        HashMap<String, InsuranceCard> insurancecards = filereader.readInsuranceCardsFromFile("insurancecard.txt");
        InsuranceCardViewText ICview = new InsuranceCardViewText();
        ClaimProcessViewText view = new ClaimProcessViewText();
        InsuranceCardController ICcontroller = new InsuranceCardController(new InsuranceCard(), ICview, insurancecards);
        ClaimProcessController controller = new ClaimProcessController(new Claim(), view, claims, new Filewriter());
        view.setController(controller,ICcontroller);
        view.MainMenu(controller,ICcontroller);
    }
}
