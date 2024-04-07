import java.util.HashMap;

public abstract class InsuranceCardView {
    public static final String CARD_HOLDER = "CARD_HOLDER";
    public static final String CARD_NUMBER = "CARD_NUMBER";
    public static final String POLICY_OWNER = "POLICY_OWNER";
    public static final String EXPIRATION_DATE = "EXPIRATION_DATE";

    public abstract void display(InsuranceCard insuranceCard);

    public abstract HashMap<String, String> displayNewInsuranceForm();

    public abstract HashMap<String, String> displayGetOneInsuranceForm();

    public abstract  HashMap<String, String> displayDeleteForm();

    public abstract HashMap<String, String> displayUpdateInsuranceCardForm();
}
