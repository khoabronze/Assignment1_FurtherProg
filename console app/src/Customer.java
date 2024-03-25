import java.util.ArrayList;
import java.util.Random;

public abstract class Customer  {
    private String id;
    private String Fullname;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    public Customer(){
        this.id = generateUniqueId();
        Fullname = "default";
        this.insuranceCard = null;
        this.claims = null;
    }


    public Customer(String id, String fullname, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        this.id = id;
        Fullname = fullname;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
    }

    private String generateUniqueId() {
        StringBuilder sb = new StringBuilder("c-");
        Random random = new Random();
        // Generate 10 random digits
        for (int i = 0; i < 7; i++) {
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

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }
}
