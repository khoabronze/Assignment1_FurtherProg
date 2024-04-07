import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * @author <Dong Dang Khoa- s3986281>
 */

public class ClaimProcessController implements ClaimProcessManager {
    Claim claim;
    ClaimProcessView view;
    private Filewriter filewriter;
    private String filePath = "claim.txt"; // replace with your file path
    private HashMap<String, Claim> claimList = new  HashMap<String, Claim>();
    InsuranceCardController insuranceCardController = new InsuranceCardController();


    public ClaimProcessController() {
        this.claim = claim;
        this.view = view;
        this.claimList = claimList;
        this.filewriter = new Filewriter();
    }

    public ClaimProcessController(Claim claim, ClaimProcessView view, HashMap<String, Claim> claimList, Filewriter filewriter) {
        this.claim = claim;
        this.view = view;
        this.claimList = claimList;
        this.filewriter = filewriter;
    }

    @Override
    public void add() {
        String answer = "Yes";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Yes")) {
            HashMap<String, String> data = view.NewClaimForm();
            String id = data.get(view.CLAIM_ID);

            // Check if a claim with the same ID already exists
            if (claimList.containsKey(id)) {
                System.out.println("A claim with the ID " + id + " already exists. Please use a different ID.");
                continue;
            }

            Date claimDate = new Date(Long.parseLong(data.get("CLAIM_DATE"))); // Convert String to Date
            String insuredPerson = data.get(view.INSURED_PERSON);
            String cardNumber = data.get(view.CARD_NUMBER);
            Date examDate = new Date(Long.parseLong(data.get("EXAM_DATE"))); // Convert String to Date
            ArrayList<String> documentList = new ArrayList<>(Arrays.asList(data.get(String.valueOf(view.DOCUMENT)).split(","))); // Convert String to ArrayList
            double claimAmount = Double.parseDouble(data.get(String.valueOf(view.CLAIM_AMOUNT))); // Convert String to double
            ClaimStatus status = ClaimStatus.valueOf(data.get(view.CLAIM_STATUS_KEY));
            BankingInfo receiverBankingInfo = new BankingInfo(data.get("RECEIVER_BANKING_INFO_BANK"), data.get("RECEIVER_BANKING_INFO_NAME"), data.get("RECEIVER_BANKING_INFO_NUMBER"));

            claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documentList, claimAmount, status, receiverBankingInfo);
            claimList.put(id, claim); // Add the claim to the HashMap
            view.displayAdd(claim); // Display the claim after it's fully created
            Filewriter filewriter = new Filewriter();
            filewriter.writeClaimToFile(claim);

            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
        view.MainMenu(this, insuranceCardController);
    }

    @Override
    public void update() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = view.displayGetOneClaimForm();
        String id = data.get(view.CLAIM_ID);
        if (claimList.containsKey(id)) {
            Claim claim = claimList.get(id);

            // Assuming displayUpdateClaimForm() returns a HashMap containing updated claim data
            HashMap<String, String> updatedData = view.displayUpdateClaimForm();

            // Update fields based on user input
            if (updatedData.containsKey(view.INSURED_PERSON)) {
                claim.setInsuredPerson(updatedData.get(view.INSURED_PERSON));
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);

            }
            if (updatedData.containsKey(view.CARD_NUMBER)) {
                claim.setCardNumber(updatedData.get(view.CARD_NUMBER));
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);
            }
            if (updatedData.containsKey("EXAM_DATE")) {
                // Parse the date string to a Date object
                Date examDate = new Date();
                claim.setExamDate(examDate);
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);
            }
            if (updatedData.containsKey(view.DOCUMENT)) {
                // Split the document string and convert it to ArrayList
                ArrayList<String> documentList = new ArrayList<>(Arrays.asList(updatedData.get(view.DOCUMENT).split(",")));
                claim.setDocuments(documentList);
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);


            }
            if (updatedData.containsKey(view.CLAIM_AMOUNT)) {
                claim.setClaimAmount(Double.parseDouble(updatedData.get(view.CLAIM_AMOUNT)));
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);

            }
            if (updatedData.containsKey(view.CLAIM_STATUS_KEY)) {
                try {
                    ClaimStatus status = ClaimStatus.valueOf(updatedData.get(view.CLAIM_STATUS_KEY));
                    claim.setStatus(status);
                    filewriter.rewriteFileWithClaims(claimList, filePath);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Claim Status provided.");
                }
                view.MainMenu(this, insuranceCardController);


            }
            if (updatedData.containsKey("RECEIVER_BANKING_INFO_BANK") && updatedData.containsKey("RECEIVER_BANKING_INFO_NAME") && updatedData.containsKey("RECEIVER_BANKING_INFO_NUMBER")) {
                BankingInfo receiverBankingInfo = new BankingInfo(updatedData.get("RECEIVER_BANKING_INFO_BANK"), updatedData.get("RECEIVER_BANKING_INFO_NAME"), updatedData.get("RECEIVER_BANKING_INFO_NUMBER"));
                claim.setReiveBankingInfo(receiverBankingInfo);
                filewriter.rewriteFileWithClaims(claimList, filePath);
                view.MainMenu(this, insuranceCardController);


            }

            // Display the updated claim after all fields have been updated
        } else {
            System.out.println("Claim with the ID " + id + " not found.");
        }
    }



    @Override
    public void delete() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = view.displayDeleteClaimForm();
        String id = data.get(view.CLAIM_ID);

        if (claimList.containsKey(id)) {
            claimList.remove(id);
            System.out.println("Claim with the ID " + id + " has been deleted.");
            filewriter.rewriteFileWithClaims(claimList, filePath);
        } else {
            System.out.println("Claim with the ID " + id + " not found.");
        }
    }

    @Override
    public void getOne() {
        Scanner scanner = DataInput.getDataInput().getScanner();
        HashMap<String, String> data = view.displayGetOneClaimForm();
        String id = data.get(view.CLAIM_ID);

        if (claimList.containsKey(id)) {
            Claim claim = claimList.get(id);
            view.displayAdd(claim);
        } else {
            System.out.println("Claim with the ID " + id + " not found.");
        }
    }


    @Override
    public HashMap<String, Claim> getAll() {
        if (claimList.isEmpty()) {
            System.out.println("No claims available.");
        } else {
            System.out.println("All Claims:");
            System.out.println();
            Iterator<Claim> iterator = claimList.values().iterator();
            while (iterator.hasNext()) {
                Claim claim = iterator.next();
                view.displayAdd(claim);
            }
        }
        return claimList;
    }
}