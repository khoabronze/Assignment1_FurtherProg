import java.time.LocalDate;
import java.util.*;

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
            HashMap<String, Object> data = view.NewClaimForm();
            String ID = (String) data.get(ClaimProcessView.CLAIM_ID);
            LocalDate Date = (LocalDate) data.get(ClaimProcessView.CLAIM_DATE);
            String Insured = (String) data.get(ClaimProcessView.INSURED_PERSON);
            String Number = (String) data.get(ClaimProcessView.CARD_NUMBER);
            LocalDate Exam = (LocalDate) data.get(ClaimProcessView.EXAM_DATE);
            String Documents = (String) data.get(ClaimProcessView.DOCUMENT);
            Double Amount = (Double) data.get(ClaimProcessView.CLAIM_AMOUNT);
            String Status = (String) data.get(ClaimProcessView.CLAIM_STATUS);
            String BankInfo = (String) data.get(ClaimProcessView.BANKING_INFO);

            // Assuming Exam should be of type String in the Claim constructor
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
