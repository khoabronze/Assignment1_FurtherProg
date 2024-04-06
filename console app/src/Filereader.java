import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Filereader {

    public HashMap<String, Claim> readClaimsFromFile(String filePath) {
        HashMap<String, Claim> claims = new HashMap<>();
        File file = new File(filePath);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String id = "";
                Date claimDate = null;
                String insuredPerson = "";
                String cardNumber = "";
                Date examDate = null;
                ArrayList<String> documents = new ArrayList<>();
                double claimAmount = 0;
                ClaimStatus status = null;
                BankingInfo bankingInfo = null;

                String line;
                while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
                    if (line.startsWith("Claim ID:")) {
                        id = line.split(": ")[1];
                    } else if (line.startsWith("Claim Date:")) {
                        claimDate = formatter.parse(line.split(": ")[1]);
                    } else if (line.startsWith("Insured person:")) {
                        insuredPerson = line.split(": ")[1];
                    } else if (line.startsWith("Card number:")) {
                        cardNumber = line.split(": ")[1];
                    } else if (line.startsWith("Exam Date:")) {
                        examDate = formatter.parse(line.split(": ")[1]);
                    } else if (line.startsWith("Documents:")) {
                        documents.addAll(Arrays.asList(line.split(": ")[1].substring(1, line.split(": ")[1].length() - 1).split(", ")));
                    } else if (line.startsWith("Claim Amount:")) {
                        claimAmount = Double.parseDouble(line.split(": ")[1]);
                    } else if (line.startsWith("Claim Status:")) {
                        status = ClaimStatus.valueOf(line.split(": ")[1]);
                    } else if (line.startsWith("Banking info:")) {
                        String[] bankingInfoParts = line.split(": ")[1].split(" – ");
                        bankingInfo = new BankingInfo(bankingInfoParts[0], bankingInfoParts[1], bankingInfoParts[2]);
                    }
                }

                Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, bankingInfo);
                claims.put(id, claim);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("An error occurred while parsing the date.");
            e.printStackTrace();
        }

        return claims;
    }

}
