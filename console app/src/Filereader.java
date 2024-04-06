import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Filereader {

    private SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

    public HashMap<String, Claim> readClaimsFromFile(String filePath) {
        HashMap<String, Claim> claims = new HashMap<>();
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Claim claim = readClaim(scanner);
                if (claim != null) {
                    claims.put(claim.getId(), claim);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }

        return claims;
    }

    private Claim readClaim(Scanner scanner) {
        String id = "";
        Date claimDate = null;
        String insuredPerson = "";
        String cardNumber = "";
        Date examDate = null;
        ArrayList<String> documents = new ArrayList<>();
        double claimAmount = 0;
        ClaimStatus status = null;
        BankingInfo bankingInfo = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("-----------------------------------")) {
                break;
            }

            String[] parts = line.split(": ");
            String key = parts[0];
            String value = parts[1];

            try {
                switch (key) {
                    case "Claim ID":
                        id = value;
                        break;
                    case "Claim Date":
                        claimDate = formatter.parse(value);
                        break;
                    case "Insured person":
                        insuredPerson = value;
                        break;
                    case "Card number":
                        cardNumber = value;
                        break;
                    case "Exam Date":
                        examDate = formatter.parse(value);
                        break;
                    case "Documents":
                        documents.addAll(Arrays.asList(value.substring(1, value.length() - 1).split(", ")));
                        break;
                    case "Claim Amount":
                        claimAmount = Double.parseDouble(value);
                        break;
                    case "Claim Status":
                        status = ClaimStatus.valueOf(value);
                        break;
                    case "Banking info":
                        String[] bankingInfoParts = value.split(" – ");
                        bankingInfo = new BankingInfo(bankingInfoParts[0], bankingInfoParts[1], bankingInfoParts[2]);
                        break;
                }
            } catch (ParseException e) {
                System.out.println("An error occurred while parsing the date.");
                e.printStackTrace();
            }
        }

        return new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, bankingInfo);
    }
    public void updateFromFile(String filePath, String claimId, Claim newClaimData) {
        HashMap<String, Claim> claims = readClaimsFromFile(filePath);

        // Update the claim if it exists in the map
        if (claims.containsKey(claimId)) {
            claims.put(claimId, newClaimData);
        }

        // Write the updated claims back to the file
        Filewriter filewriter = new Filewriter();
        for (Claim claim : claims.values()) {
            filewriter.writeTripToFile(claim);
        }
    }

    public void deleteFromFile(String filePath, String claimId) {
        HashMap<String, Claim> claims = readClaimsFromFile(filePath);

        // Remove the claim if it exists in the map
        if (claims.containsKey(claimId)) {
            claims.remove(claimId);
        }

        // Write the remaining claims back to the file
        Filewriter filewriter = new Filewriter();
        for (Claim claim : claims.values()) {
            filewriter.writeTripToFile(claim);
        }
    }
}
