/**
 * @author <Dong Dang Khoa- s3986281>
 */
import java.util.ArrayList;


class Dependent extends Customer{
    // Attributes
    private PolicyHolder policyHolder;

    // Default Constructor
    public Dependent() {};

    // Constructor
    public Dependent(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Dependent(String id, String fullname, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(id, fullname, insuranceCard, claims);
    }

    // Getters and Setters
    protected PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    protected void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }
}



