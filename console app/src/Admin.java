import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Admin implements ClaimProcessManager {
    private ArrayList<Claim> claims;


    public void loop(){
        for (int i = 0; i < claims.size(); i ++){
            Claim CurrentClaim = claims.get(i);
        }
    }

    public Admin(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public void add(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void update(Claim claim) {
        Scanner scanner = new Scanner(System.in);
        String claimId = scanner.nextLine();
        loop();
        if (claim.getId().equals(claimId)){
            System.out.println(claim);
            System.out.println("Select attribute to update");
            int choice = scanner.nextInt();
            System.out.println("1: ID");
            System.out.println("2: Claim Date");
            System.out.println("3: Insured person");
            System.out.println("4: Card number");
            System.out.println("5: Exam Date");
            System.out.println("6: Document");
            System.out.println("7: Claim amount");
            System.out.println("8: Status");
            System.out.println("9 Banking info");

            switch (choice){
                case 1:
                    System.out.println("Claim ID is:" + " " + claim.getId());
                    System.out.println("Enter new ID");
                    String newId = scanner.nextLine();
                    claim.setId(newId);
                    System.out.println("The new ID is" +" " + claim.getId());

                case 2:
                    System.out.println("Claim Date is:" + " " + claim.getClaimDate());

                case 3:
                    System.out.println("The insured person is " + " " + claim.getInsuredPerson());
                    System.out.println("Enter new insured person:");
                    String newinsuredPerson = scanner.nextLine();
                    claim.setInsuredPerson(newinsuredPerson);
                    System.out.println("The new insured person is " +" " + claim.getInsuredPerson());
                case 4:
                    System.out.println("The card number is" +" " + claim.getCardNumber());
                    System.out.println("Enter new card number:");
                    String newCardNumber = scanner.nextLine();
                    claim.setCardNumber(newCardNumber);
                    System.out.println("The new card number is" + " " + claim.getCardNumber());
                case 5:
                    System.out.println("The exam date is " + " " + claim.getExamDate());
                    System.out.println("Enter new exam date:");
                    String newDateStr = scanner.nextLine();

                    // Parse the user input string into a Date object
                    Date newDate = null;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        newDate = dateFormat.parse(newDateStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                        // Handle the error as needed
                    }

                    // Set the new exam date for the claim
                    claim.setExamDate(newDate);

                case 6:
                    System.out.println("The document is" +" " + claim.getDocuments());
                    System.out.println("Enter new document");

                case 7:
                    System.out.println("The claim amount is" + " " + claim.getClaimAmount());
                    System.out.println("Enter new claim amount");
                    double newClaimAmount = scanner.nextDouble();
                    claim.setClaimAmount(newClaimAmount);
                    System.out.println("The new claim amount is" + " " + claim.getClaimAmount());
                case 8:
                    System.out.println("The status is" + " " + claim.getStatus());
                    System.out.println("Choose new status");
                    int statuschoice = scanner.nextInt();
                    System.out.println("1: New");
                    System.out.println("2: Processing");
                    System.out.println("3: Done");
                    switch (statuschoice){
                        case 1:
                            claim.setStatus(ClaimStatus.New);
                            System.out.println("Claim status is " +" " + claim.getStatus());
                        case 2:
                            claim.setStatus(ClaimStatus.Processing);
                            System.out.println("Claim status is " +" " + claim.getStatus());
                        case 3:
                            claim.setStatus(ClaimStatus.Done);
                            System.out.println("Claim status is " +" " + claim.getStatus());
                    }
                case 9:
                }

        }

    }

    @Override
    public void delete(String claimId) {
        Scanner scanner = new Scanner(System.in);
        claimId = scanner.nextLine();
        for (int i = 0; i < claims.size(); i++) {
            Claim claim = claims.get(i);
            if (claim.getId().equals(claimId)) {
                claims.remove(i);
                System.out.println("Claim with ID" + "" + claimId + "" + "has been removed");
            } else {
                System.out.println("Claim with ID" + "" + claimId + "" + "has not found removed");
            }
        }

    }

    @Override
    public Claim getOne(String claimId) {
        Scanner scanner = new Scanner(System.in);
        claimId = scanner.nextLine();

        for (int i = 0; i < claims.size(); i++) {
            Claim claim = claims.get(i);

            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }

        // If no matching claim is found, print a message and return null
        System.out.println("Claim with ID " + claimId + " has not been found.");
        return null;
    }

    @Override
    public ArrayList<Claim> getAll() {
        return claims;
    }
}