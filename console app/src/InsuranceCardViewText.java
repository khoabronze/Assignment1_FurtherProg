/**
 * @author <Dong Dang Khoa- s3986281>
 */

import java.util.HashMap;
import java.util.Scanner;

public class InsuranceCardViewText extends InsuranceCardView{
    @Override
    public void display(InsuranceCard ic) {
        System.out.println("Card Holder: " + ic.getCardHolder());
        System.out.println("Policy Owner: " + ic.getPolicyOwner());
        System.out.println("Expiration Date: " + ic.getExpirationDate());
        System.out.println("==============================================================================================");
        System.out.println();
    }

    @Override
    public HashMap<String, String> displayNewInsuranceForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("New Insurance Card Form");
        System.out.println();
        System.out.println("Enter card holder: ");
        data.put(CARD_HOLDER, scanner.nextLine());
        System.out.println("Enter card number (10 numbers): ");
        String CardNumber;
        do {
            CardNumber = scanner.nextLine();
            if (!CardNumber.matches("\\d{10}")) {
                System.out.println("Invalid card number. Must be in the format 10 numbers");
            }
        } while (!CardNumber.matches("\\d{10}"));
        data.put(CARD_NUMBER, CardNumber);
        System.out.println("Enter policy owner: ");
        data.put(POLICY_OWNER, scanner.nextLine());
        System.out.println("Enter expiration date (DD/MM/YYYY): ");
        String ExpirationDate;
        do {
            ExpirationDate = scanner.nextLine();
            if (!ExpirationDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Invalid expiration date. Must be in the format DD/MM/YYYY.");
            }
        } while (!ExpirationDate.matches("\\d{2}/\\d{2}/\\d{4}"));
        data.put(EXPIRATION_DATE, ExpirationDate);
        return data;
    }

    @Override
    public HashMap<String, String> displayDeleteForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter the insurance card's card holder name that you want to delete: ");
        data.put(CARD_HOLDER, scanner.nextLine());
        return data;
    }

    @Override
    public HashMap<String, String> displayGetOneInsuranceForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter the insurance card's card holder name that you want to check: ");
        data.put(CARD_HOLDER, scanner.nextLine());
        return data;
    }

    @Override
    public HashMap<String, String> displayUpdateInsuranceCardForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Update card number (10 numbers): ");
        String CardNumber;
        do {
            CardNumber = scanner.nextLine();
            if (!CardNumber.matches("\\d{10}")) {
                System.out.println("Invalid card number. Must be in the format 10 numbers");
            }
        } while (!CardNumber.matches("\\d{10}"));
        data.put(CARD_NUMBER, CardNumber);
        System.out.println("Update policy owner: ");
        data.put(POLICY_OWNER, scanner.nextLine());
        System.out.println("Update expiration date: (DD/MM/YYYY): ");
        String ExpirationDate;
        do {
            ExpirationDate = scanner.nextLine();
            if (!ExpirationDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Invalid expiration date. Must be in the format DD/MM/YYYY.");
            }
        } while (!ExpirationDate.matches("\\d{2}/\\d{2}/\\d{4}"));
        data.put(EXPIRATION_DATE, ExpirationDate);
        return data;
    }
}