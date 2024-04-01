
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public abstract class ClaimProcessView {
    public static final String CLAIM_ID = "Claim_ID";
    public static final String CLAIM_DATE = "Claim_Date";
    public static final String INSURED_PERSON = "Insured_Person";

    public static final String CARD_NUMBER = "Card_Number";
    public static final String EXAM_DATE = "Exam_Date";
    public static final String DOCUMENT = "Documents" ;
    public static final String CLAIM_AMOUNT = "Claim_Amount";

    public static final String CLAIM_STATUS = "Claim_Status";
    public static final String BANKING_INFO = "Banking_Info";

    public abstract void display(Claim claim);
    public abstract Map<String, String> NewClaimForm();


}
