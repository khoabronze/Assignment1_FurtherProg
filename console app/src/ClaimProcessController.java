import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;
import java.text.SimpleDateFormat;
public class ClaimProcessController implements ClaimProcessManager {
    Claim claim;
    ClaimProcessView view;
    private ArrayList<Claim> claimList = new ArrayList<>();


    public ClaimProcessController(Claim claim, ClaimProcessView view, ArrayList<Claim> claimList) {
        this.claim = claim;
        this.view = view;
        this.claimList = claimList;
    }

    @Override
    public void add() {
        String answer = "Yes";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Yes")) {
            HashMap<String, String> data = view.NewClaimForm();
            String id = data.get(view.CLAIM_ID);
            Date claimDate = new Date(Long.parseLong(data.get("CLAIM_DATE"))); // Convert String to Date
            String insuredPerson = data.get(view.INSURED_PERSON);
            String cardNumber = data.get(view.CARD_NUMBER);
            Date examDate = new Date(Long.parseLong(data.get("EXAM_DATE"))); // Convert String to Date
            ArrayList<String> documentList = new ArrayList<>(Arrays.asList(data.get(String.valueOf(view.DOCUMENT)).split(","))); // Convert String to ArrayList
            double claimAmount = Double.parseDouble(data.get(String.valueOf(view.CLAIM_AMOUNT))); // Convert String to double
            ClaimStatus status = ClaimStatus.valueOf(data.get(view.CLAIM_STATUS_KEY));
            BankingInfo receiverBankingInfo = new BankingInfo(data.get("RECEIVER_BANKING_INFO_BANK"), data.get("RECEIVER_BANKING_INFO_NAME"), data.get("RECEIVER_BANKING_INFO_NUMBER"));

            claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documentList, claimAmount, status, receiverBankingInfo);
            claimList.add(claim); // Add the claim to the ArrayList
            view.displayAdd(claim); // Display the claim after it's fully created
            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
        view.MainMenu();
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
        System.out.println("Getting all claims...");
        view.DisplaygetAll(claimList);
        return new ArrayList<>(claimList);
    }
}