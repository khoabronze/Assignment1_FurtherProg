import java.util.ArrayList;
import java.util.Date;

public class Claim {
    private String id;
    private Date claimDate;
    private String InsuredPerson;
    private String cardNumber;
    private Date examDate;
    private ArrayList<String> documents;
    private double claimAmount;
    private ClaimStatus status;
    private BankingInfo reiveBankingInfo;

}
