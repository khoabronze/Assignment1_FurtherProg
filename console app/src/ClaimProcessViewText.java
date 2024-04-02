import java.util.HashMap;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Object;

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
    public HashMap<String, Objects> NewClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("New Student Form: ");
        System.out.println("Enter Claim id: ");
        data.put(CLAIM_ID, scanner.nextLine());

        System.out.println("Enter Claim Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Claim Month (1-12): ");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Claim Day: ");
        int day = Integer.parseInt(scanner.nextLine());

        // Create LocalDate object
        LocalDate claimDate = LocalDate.of(year, month, day);
        data.put(CLAIM_DATE, claimDate);

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