import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ClaimProcessController implements ClaimProcessManager {
    Claim claim;
    ClaimProcessView view;

    public ClaimProcessController(Claim claim, ClaimProcessView view) {
        this.claim = claim;
        this.view = view;
    }

    @Override
    public void add(Claim claim) {
            String answer = "Y";
            Scanner scanner = DataInput.getDataInput().getScanner();
            while (answer.equalsIgnoreCase("Y")) {
                Map<String, String> data = view.NewClaimForm();
                String ID = data.get(ClaimProcessView.CLAIM_ID);
                String Date = data.get(ClaimProcessView.CLAIM_DATE);
                String Insured = data.get(ClaimProcessView.INSURED_PERSON);
                String Number = data.get(ClaimProcessView.CARD_NUMBER);
                String Exam = data.get(ClaimProcessView.EXAM_DATE);
                String Documents = data.get(ClaimProcessView.DOCUMENT);
                String Amount = data.get(ClaimProcessView.CLAIM_AMOUNT);
                String Status = data.get(ClaimProcessView.CLAIM_STATUS);
                String BankInfo = data.get(ClaimProcessView.BANKING_INFO);

                claim = new Claim(ID, Date, Insured, Number, Exam, Documents, Amount, Status, BankInfo);
                view.display(claim);

                System.out.println("Continue? ");
                answer = scanner.nextLine();
            }
    }

    @Override
    public void update(Claim claim) {

    }

    @Override
    public void delete(String claimId) {

    }

    @Override
    public Claim getOne(String claimId) {
        return null;
    }

    @Override
    public ArrayList<Claim> getAll() {
        return null;
    }
}
