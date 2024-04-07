import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * @author <Dong Dang Khoa- s3986281>
 */


// ClaimProcessViewText.java
public class ClaimProcessViewText extends ClaimProcessView {
    private ClaimProcessController controller;
    private InsuranceCardController icController;


    public void setController(ClaimProcessController controller, InsuranceCardController icController) {
        this.controller = controller;
        this.icController = icController;
    }

    @Override
    public void MainMenu(ClaimProcessController controller, InsuranceCardController icController) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insurance Claim Processing System");
        System.out.println("Choose an option: ");
        System.out.println("'1' to add a Claim");
        System.out.println("'2' to update a Claim");
        System.out.println("'3' to delete a Claim");
        System.out.println("'4' to get one Claim");
        System.out.println("'5' to get all Claim");
        System.out.println("'6' to add an Insurance Card");
        System.out.println("'7' to update an Insurance Card");
        System.out.println("'8' to delete an Insurance Card");
        System.out.println("'9' to get one Insurance Card");
        System.out.println("'10' to get all Insurance Card");
        System.out.println("'11' to exit the system");
        int menuChoice = scanner.nextInt();

        switch (menuChoice) {
            case 1:
                controller.add();
                MainMenu(controller, icController);
                return;
            case 2:
                controller.update();
                MainMenu(controller, icController);
                return;
            case 3:
                controller.delete();
                MainMenu(controller, icController);
                return;
            case 4:
                controller.getOne();
                MainMenu(controller, icController);
                return;
            case 5:
                controller.getAll();
                MainMenu(controller, icController);
                return;
            case 6:
                icController.add();
                MainMenu(controller, icController);
                return;
            case 7:
                icController.update();
                MainMenu(controller, icController);
                return;
            case 8:
                icController.delete();
                MainMenu(controller, icController);
                return;
            case 9:
                icController.getOne();
                MainMenu(controller, icController);
                return;
            case 10:
                icController.getAll();
                MainMenu(controller, icController);
                return;
            case 11:
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option");
        }
    }

    @Override
    public void displayAdd(Claim claim) {
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured person: " + claim.getInsuredPerson());
        System.out.println("Card number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Documents: " + claim.getDocuments());
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Claim Status: " + claim.getStatus());
        System.out.println("Banking info: " + claim.getReiveBankingInfo());
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
        System.out.println("Enter the ID of the Claim that you want to update:");
        data.put(CLAIM_ID, scanner.nextLine());
        ClaimProcessView view = new ClaimProcessViewText();
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

                String bankingInfoFormatted = String.format("BankingInfo{Bank='%s', Name='%s', Number='%s'}", bankname, name, number);
                data.put("RECEIVER_BANKING_INFO", bankingInfoFormatted);
                break;
            case 8:
                view.MainMenu(controller, icController);
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