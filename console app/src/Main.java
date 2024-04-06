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

        ClaimProcessViewText view = new ClaimProcessViewText();
        ClaimProcessController controller = new ClaimProcessController(new Claim(), view, claims);
        view.setController(controller);
        view.MainMenu();
    }
}
