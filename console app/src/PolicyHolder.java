/**
 * @author <Dong Dang Khoa- s3986281>
 */

import java.util.ArrayList;
import java.util.HashMap;

// Policy Holder
class PolicyHolder extends Customer {
    // Attributes
    private HashMap<String, Dependent> dependentList;

    // Constructors
    public PolicyHolder() {}


    public PolicyHolder(String id, String fullname, InsuranceCard insuranceCard, ArrayList<Claim> claims) {
        super(id, fullname, insuranceCard, claims);
    }

    // Getters and Setters
    protected HashMap<String, Dependent> getDependentList() {
        return dependentList;
    }

    protected void setDependentList(HashMap<String, Dependent> dependentList) {
        this.dependentList = dependentList;
    }
}