import java.util.Date;

public class InsuranceCard {
    private String cardNumber;
    private String CardHolder;
    private String policyOwner;
    private String expirationDate;

    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, String expirationDate) {
        this.cardNumber = cardNumber;
        CardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return CardHolder;
    }

    public void setCardHolder(String cardHolder) {
        CardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
