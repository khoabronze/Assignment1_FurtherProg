import java.util.ArrayList;

public class Customer  {
    private String id;
    private String Fullname;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;

    public Customer(){
        this.id = "default";
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
}
