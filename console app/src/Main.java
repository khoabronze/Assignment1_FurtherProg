import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;

// Main.java
public class Main {
    public static void main(String[] args) {
        ClaimProcessViewText view = new ClaimProcessViewText();
        ClaimProcessController controller = new ClaimProcessController(new Claim(), view, new HashMap<>());
        view.setController(controller);
        view.MainMenu();
    }
}
