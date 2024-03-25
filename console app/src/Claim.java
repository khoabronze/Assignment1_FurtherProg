import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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

    public Claim() {
        this.id = generateUniqueId();
        this.claimDate = new Date();
        InsuredPerson = "Default";
        this.cardNumber = "default";
        this.examDate = new Date();
        this.documents = new ArrayList<>();
        this.claimAmount = 0.00;
        this.status = null;
        this.reiveBankingInfo = reiveBankingInfo;
    }
    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, ArrayList<String> documents, double claimAmount, ClaimStatus status, BankingInfo reiveBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        InsuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.reiveBankingInfo = reiveBankingInfo;
    }

    private String generateUniqueId() {
        StringBuilder sb = new StringBuilder("f-");
        Random random = new Random();
        // Generate 10 random digits
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return sb.toString();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPerson() {
        return InsuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        InsuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public BankingInfo getReiveBankingInfo() {
        return reiveBankingInfo;
    }

    public void setReiveBankingInfo(BankingInfo reiveBankingInfo) {
        this.reiveBankingInfo = reiveBankingInfo;
    }
}
