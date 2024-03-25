import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements ClaimProcessManager {
    private ArrayList<Claim> claims;


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