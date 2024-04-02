import java.util.HashMap;
import java.util.Date;
import java.util.Scanner;

public class ClaimProcessViewText extends ClaimProcessView {
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
    public HashMap<String, String> NewClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("New Claim Form: ");
        System.out.println("Enter Claim id: ");
        data.put(CLAIM_ID, scanner.nextLine());

        Date currentDate = new Date();
        data.put(CLAIM_DATE, currentDate.toString()); // Convert Date to String

        System.out.println("Enter Insured Person: ");
        data.put(INSURED_PERSON, scanner.nextLine());

        System.out.println("Enter Card Number: ");
        data.put(CARD_NUMBER, scanner.nextLine());

        System.out.println("Enter Exam Date: ");
        data.put(EXAM_DATE.toString(), scanner.nextLine()); // Convert Date to String

        System.out.println("Enter Document: ");
        data.put(DOCUMENT.toString(), scanner.nextLine()); // Convert ArrayList to String

        System.out.println("Enter Claim amount: ");
        data.put(CLAIM_AMOUNT, scanner.nextLine());

        System.out.println("Select Claim Status: ");
        System.out.println("1: New ");
        System.out.println("2: Processing ");
        System.out.println("3: Done");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String claimStatus = ""; // declare variable to store claim status
        switch (choice) {
            case 1:
                claimStatus = ClaimStatus.New.toString();
                break;
            case 2:
                claimStatus = ClaimStatus.Processing.toString();
                break;
            case 3:
                claimStatus = ClaimStatus.Done.toString();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to New.");
                claimStatus = ClaimStatus.New.toString(); // default to New status
                break;
        }
        data.put(CLAIM_STATUS.toString(), claimStatus);

        System.out.println("Enter Banking Info: ");
        data.put(BANKING_INFO, scanner.nextLine());
        return data;
    }
}
