import java.util.Date;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ClaimProcessController controller = new ClaimProcessController(new Claim(), new ClaimProcessViewText());
        controller.add();
            controller.getAll();

        }

}