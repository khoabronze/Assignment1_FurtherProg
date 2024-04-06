import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class InsuranceCardController {
    // Attributes
    HashMap<String, InsuranceCard> insuranceCardList;
    InsuranceCard insuranceCard;
    InsuranceCardView InsuranceView;

    // Constructor
    public InsuranceCardController(InsuranceCard insuranceCard, InsuranceCardView InsuranceView) {
        this.insuranceCard = insuranceCard;
        this.InsuranceView = InsuranceView;
        this.insuranceCardList = new HashMap<>();
    }

    public void add() {
        String answer = "Yes";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Yes")) {
            HashMap<String, String> data = InsuranceView.displayNewInsuranceCardForm();
            String cardNumber = data.get(InsuranceCardView.CARD_NUMBER);
            String cardHolder = data.get(InsuranceCardView.CARD_HOLDER);
            String policyOwner = data.get(InsuranceCardView.POLICY_OWNER);
            String expirationDate = data.get(InsuranceCardView.EXPIRATION_DATE);

            insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);

            insuranceCardList.put(cardHolder, insuranceCard);  // Add the Insurance Card to the Insurance Card list

            InsuranceView.display(insuranceCard);

            System.out.println("Continue? (Yes/No) ");
            answer = scanner.nextLine();
        }
    }

    public void getAll() {
        if (insuranceCardList.isEmpty()) {
            System.out.println("No insurance card available.");
        } else {
            System.out.println("All insurance card: ");
            System.out.println();
            Iterator<InsuranceCard> iterator = insuranceCardList.values().iterator();
            while (iterator.hasNext()) {
                InsuranceCard insuranceCard = iterator.next();
                InsuranceView.display(insuranceCard);
            }
        }
    }

    public void getOne() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = InsuranceView.displayGetOneInsuranceCardForm();
        String cardHolder = data.get(InsuranceCardView.CARD_HOLDER);

        if (insuranceCardList.containsKey(cardHolder)) {
            InsuranceCard insuranceCard = insuranceCardList.get(cardHolder);
            InsuranceView.display(insuranceCard);
        } else {
            System.out.println("Insurance Card with the Card Holder " + cardHolder + " not found.");
        }
    }

    public void delete() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = InsuranceView.displayDeleteInsuranceCardForm();
        String cardHolder = data.get(InsuranceCardView.CARD_HOLDER);

        if(insuranceCardList.containsKey(cardHolder)) {
            InsuranceCard insuranceCard = insuranceCardList.get(cardHolder);
            System.out.println("Claim with the ID " + cardHolder + " has been removed.");
            System.out.println();
            insuranceCardList.remove(cardHolder);
        } else {
            System.out.println("Claim with the ID " + cardHolder + " not found.");
        }
    }

    public void update() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = InsuranceView.displayUpdateInsuranceCardForm();
        String cardHolder = data.get(InsuranceCardView.CARD_HOLDER);

        if (insuranceCardList.containsKey(cardHolder)) {
            InsuranceCard insuranceCard = insuranceCardList.get(cardHolder);
            String cardNumber = data.get(InsuranceCardView.CARD_NUMBER);
            String policyOwner = data.get(InsuranceCardView.POLICY_OWNER);
            String expirationDate = data.get(InsuranceCardView.EXPIRATION_DATE);

            // Update specific attributes
            insuranceCard.setCardNumber(cardNumber);
            insuranceCard.setPolicyOwner(policyOwner);
            insuranceCard.setExpirationDate(expirationDate);

            // Update insurance card in the insurace card list
            insuranceCardList.put(cardHolder, insuranceCard);

            InsuranceView.display(insuranceCard);
        }
    }
}
