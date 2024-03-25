import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements ClaimProcessManager {
    private ArrayList<Claim> claims;


    public void loop(){
        for (int i = 0; i < claims.size(); i ++){
            Claim CurrentClaim = claims.get(i);
        }
    }

    public Admin(ArrayList<Claim> claims) {
        this.claims = new ArrayList<>();
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

                case 2:
                    System.out.println("Claim Date is:" + " " + claim.getClaimDate());

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