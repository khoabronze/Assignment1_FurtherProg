/**
 * @author <Dong Dang Khoa- s3986281>
 */


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
    public HashMap<String, InsuranceCard> readInsuranceCardsFromFile(String filePath) {
        HashMap<String, InsuranceCard> insuranceCards = new HashMap<>();
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                InsuranceCard insuranceCard = readInsuranceCard(scanner);
                if (insuranceCard != null) {
                    insuranceCards.put(insuranceCard.getCardHolder(), insuranceCard);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }

        return insuranceCards;
    }

    private InsuranceCard readInsuranceCard(Scanner scanner) {
        String cardHolder = "";
        String cardNumber = "";
        String policyOwner = "";
        String expirationDate = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("-----------------------------------")) {
                break;
            }

            String[] parts = line.split(": ");
            if (parts.length < 2) {
                continue;
            }
            String key = parts[0];
            String value = parts[1];

            switch (key) {
                case "Card Holder":
                    cardHolder = value;
                    break;
                case "Card Number":
                    cardNumber = value;
                    break;
                case "Policy Owner":
                    policyOwner = value;
                    break;
                case "Expiration Date":
                    expirationDate = value;
                    break;
            }
        }

        return new InsuranceCard(cardNumber, cardHolder, policyOwner, expirationDate);
    }

}
