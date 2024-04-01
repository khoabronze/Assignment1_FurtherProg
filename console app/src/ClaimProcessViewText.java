import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClaimProcessViewText extends ClaimProcessView{
    @Override
    public void display(Claim claim) {

        System.out.println("Begin console view:");
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured person: " + claim.getInsuredPerson());
        System.out.println("Card number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Documents: " + claim.getDocuments());
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Claim Status: " + claim.getStatus());
        System.out.println("Banking info: " + claim.getReiveBankingInfo());
        System.out.println("End console view:");
        System.out.println();
    }

    @Override
    public Map<String, String> NewClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        Map<String, String> data = new HashMap<>();
        System.out.println("New Student Form: ");
        System.out.println("Enter Claim id: ");
        data.put(CLAIM_ID, scanner.nextLine());

        System.out.println("Enter Claim Date : ");
        data.put(CLAIM_DATE, scanner.nextLine());

        System.out.println("Enter Insured Person: ");
        data.put(INSURED_PERSON, scanner.nextLine());

        System.out.println("Enter Card Number: ");
        data.put(CARD_NUMBER, scanner.nextLine());

        System.out.println("Enter Exam Date: ");
        data.put(EXAM_DATE, scanner.nextLine());

        System.out.println("Enter Document: ");
        data.put(DOCUMENT, scanner.nextLine());

        System.out.println("Enter Claim amount: ");
        data.put(CLAIM_AMOUNT, scanner.nextLine());

        System.out.println("Enter Claim Status: ");
        data.put(CLAIM_STATUS, scanner.nextLine());

        System.out.println("Enter Banking Info: ");
        data.put(BANKING_INFO, scanner.nextLine());
        return data;    }
}
