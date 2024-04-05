import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
public class ClaimProcessController implements ClaimProcessManager {
    Claim claim;
    ClaimProcessView view;
    private HashMap<String, Claim> claimList = new  HashMap<String, Claim>();

    public ClaimProcessController() {
        this.claim = claim;
        this.view = view;
        this.claimList = claimList;
    }

    public ClaimProcessController(Claim claim, ClaimProcessView view, HashMap<String, Claim> claimList) {
        this.claim = claim;
        this.view = view;
        this.claimList = claimList;
    }

    @Override
    public void add() {
        String answer = "Yes";
        Scanner scanner = DataInput.getDataInput().getScanner();
        while (answer.equalsIgnoreCase("Yes")) {
            HashMap<String, String> data = view.NewClaimForm();
            String id = data.get(view.CLAIM_ID);
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
            System.out.println("Continue? ");
            answer = scanner.nextLine();
        }
        view.MainMenu();
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
                view.MainMenu();
            }
            if (updatedData.containsKey(view.CARD_NUMBER)) {
                claim.setCardNumber(updatedData.get(view.CARD_NUMBER));
                view.MainMenu();
            }
            if (updatedData.containsKey("EXAM_DATE")) {
                // Parse the date string to a Date object
                Date examDate = new Date(Long.parseLong(updatedData.get("EXAM_DATE")));
                claim.setExamDate(examDate);
                view.MainMenu();

            }
            if (updatedData.containsKey(view.DOCUMENT)) {
                // Split the document string and convert it to ArrayList
                ArrayList<String> documentList = new ArrayList<>(Arrays.asList(updatedData.get(view.DOCUMENT).split(",")));
                claim.setDocuments(documentList);
                view.MainMenu();

            }
            if (updatedData.containsKey(view.CLAIM_AMOUNT)) {
                claim.setClaimAmount(Double.parseDouble(updatedData.get(view.CLAIM_AMOUNT)));
                view.MainMenu();

            }
            if (updatedData.containsKey(view.CLAIM_STATUS_KEY)) {
                try {
                    ClaimStatus status = ClaimStatus.valueOf(updatedData.get(view.CLAIM_STATUS_KEY));
                    claim.setStatus(status);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Claim Status provided.");
                }
                view.MainMenu();

            }
            if (updatedData.containsKey("RECEIVER_BANKING_INFO_BANK") && updatedData.containsKey("RECEIVER_BANKING_INFO_NAME") && updatedData.containsKey("RECEIVER_BANKING_INFO_NUMBER")) {
                BankingInfo receiverBankingInfo = new BankingInfo(updatedData.get("RECEIVER_BANKING_INFO_BANK"), updatedData.get("RECEIVER_BANKING_INFO_NAME"), updatedData.get("RECEIVER_BANKING_INFO_NUMBER"));
                claim.setReiveBankingInfo(receiverBankingInfo);
                view.MainMenu();

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