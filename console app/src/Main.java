import java.util.Date;12
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClaimProcessViewText view = new ClaimProcessViewText();
        ClaimProcessController controller = new ClaimProcessController(new Claim(), view, new ArrayList<Claim>());
        view.MainMenu();
    }
}