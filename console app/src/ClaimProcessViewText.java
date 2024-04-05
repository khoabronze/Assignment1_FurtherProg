import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

// ClaimProcessViewText.java
public class ClaimProcessViewText extends ClaimProcessView {
    private ClaimProcessController controller;

    public void setController(ClaimProcessController controller) {
        this.controller = controller;
    }

    @Override
    public void MainMenu() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        System.out.println("Main Menu: ");
        System.out.println("1: Add claim");
        System.out.println("2: Update claim");
        System.out.println("3: Delete claim");
        System.out.println("4: Get one claim");
        System.out.println("5: Get all claims");
        System.out.println("6: Exit");
        System.out.println("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                controller.add();
                break;
            case 2:
                controller.update();
                break;
            case 3:
                controller.delete();
            case 4:
                controller.getOne();
                break;
            case 5:
                HashMap<String, Claim> allClaims = controller.getAll();
                break;
        }
        MainMenu();
    }

    // Rest of the class...


    @Override
    public void displayAdd(Claim claim) {
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


        System.out.println("Enter Claim id (10 numbers): ");
        String id;
        do {
            id = scanner.nextLine();
            if (!id.matches("\\d{10}")) {
                System.out.println("Invalid claim id. Must be 10 numbers.");
            }
        } while (!id.matches("\\d{10}"));
        String ClaimID = "f-" + id;
        data.put(CLAIM_ID, ClaimID);

        data.put("CLAIM_DATE", String.valueOf(CLAIM_DATE.getTime()));


        System.out.println("Enter Insured Person: ");
        data.put(INSURED_PERSON, scanner.nextLine());

        System.out.println("Enter Card Number: ");
        String cardNumber = scanner.nextLine();
        data.put(CARD_NUMBER, cardNumber);


        data.put("EXAM_DATE", String.valueOf(EXAM_DATE.getTime()));


        System.out.println("Enter Document: ");
        String PDFname = ClaimID + "_" + cardNumber + "_" + scanner.nextLine() + ".PDF";
        data.put(DOCUMENT.toString(), PDFname); // Convert ArrayList to String

        System.out.println("Enter Claim amount: ");
        data.put(CLAIM_AMOUNT, scanner.nextLine());

        System.out.println("Select Claim Status: ");
        System.out.println("1: New ");
        System.out.println("2: Processing ");
        System.out.println("3: Done");


        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

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
        data.put(CLAIM_STATUS_KEY, claimStatus);

        System.out.println("Enter Banking Info: ");
        System.out.println("Enter Bank name: ");
        String bankname = scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number");
        String number = scanner.nextLine();
        data.put("RECEIVER_BANKING_INFO_BANK", bankname);
        data.put("RECEIVER_BANKING_INFO_NAME", name);
        data.put("RECEIVER_BANKING_INFO_NUMBER", number);
        return data;
    }

    @Override
    public HashMap<String, String> displayUpdateClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter the information you want to update: ");
        System.out.println("1: Insured Person");
        System.out.println("2: Card Number");
        System.out.println("3: Exam Date");
        System.out.println("4: Document");
        System.out.println("5: Claim Amount");
        System.out.println("6: Claim Status");
        System.out.println("7: Banking Info");
        System.out.println("8: Exit");
        System.out.println("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over after reading int
        switch (choice) {
            case 1:
                System.out.println("Enter Insured Person: ");
                data.put(INSURED_PERSON, scanner.nextLine());
                break;
            case 2:
                System.out.println("Enter Card Number: ");
                data.put(CARD_NUMBER, scanner.nextLine());
                break;
            case 3:
                System.out.println("Enter Exam Date (in milliseconds): ");
                data.put("EXAM_DATE", scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter Document: ");
                data.put(DOCUMENT.toString(), scanner.nextLine());
                break;
            case 5:
                System.out.println("Enter Claim Amount: ");
                data.put(CLAIM_AMOUNT, scanner.nextLine());
                break;
            case 6:
                System.out.println("Select Claim Status: ");
                System.out.println("1: New ");
                System.out.println("2: Processing ");
                System.out.println("3: Done");
                int status = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over after reading int
                String claimStatus = ""; // declare variable to store claim status
                switch (status) {
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
                data.put(CLAIM_STATUS_KEY, claimStatus);
                break;
            case 7:
                System.out.println("Enter Banking Info: ");
                System.out.println("Enter Bank name: ");
                String bankname = scanner.nextLine();
                System.out.println("Enter Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter number: ");
                String number = scanner.nextLine();
                data.put("RECEIVER_BANKING_INFO_BANK", bankname);
                data.put("RECEIVER_BANKING_INFO_NAME", name);
                data.put("RECEIVER_BANKING_INFO_NUMBER", number);
                break;
            case 8:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        return data;
    }


    @Override
    public HashMap<String, String> displayDeleteClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter the ID of the Claim that you want to check: ");
        data.put(CLAIM_ID, scanner.nextLine());
        return data;
    }

    @Override
    public HashMap<String, String> displayGetOneClaimForm() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Enter the ID of the Claim that you want to check: ");
        data.put(CLAIM_ID, scanner.nextLine());
        return data;
    }
}