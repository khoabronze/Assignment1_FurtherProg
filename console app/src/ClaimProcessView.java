import java.util.*;
/**
 * @author <Dong Dang Khoa- s3986281>
 */

public abstract class ClaimProcessView {
    public static final String CLAIM_ID = "Claim_ID";
    public static final Date CLAIM_DATE = new Date(); // Initialize with current date
    public static final String INSURED_PERSON = "Insured_Person";

    public static final String CARD_NUMBER = "Card_Number";
    public static final Date EXAM_DATE = new Date(); // Initialize with current date
    public static final ArrayList<String> DOCUMENT = new ArrayList<>(); // Initialize as empty ArrayList
    public static final String CLAIM_AMOUNT = "Claim_Amount";

    public static final String CLAIM_STATUS_KEY = "Claim_Status";
    public static final String BANKING_INFO = "Banking_Info";
    public abstract void MainMenu(ClaimProcessController claimProcessController, InsuranceCardController insuranceCardController);
    public abstract void displayAdd(Claim claim);
    public abstract HashMap<String, String> NewClaimForm();
    public abstract HashMap<String, String> displayUpdateClaimForm();
    public abstract HashMap<String, String> displayDeleteClaimForm();


    public abstract HashMap<String, String> displayGetOneClaimForm();
}