import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Filewriter {

    Claim claim;

    public void writeTripToFile(Claim claim) {
        String filePath = "claim.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            // Write container information to the file
            writer.write("Claim ID: " + claim.getId());
            writer.newLine();
            writer.write("Claim Date: " + claim.getClaimDate());
            writer.newLine();
            writer.write("Insured person: " + claim.getInsuredPerson());
            writer.newLine();
            writer.write("Card number: " + claim.getCardNumber());
            writer.newLine();
            writer.write("Exam Date: " + claim.getExamDate());
            writer.newLine();
            writer.write("Documents: " + claim.getDocuments());
            writer.newLine();
            writer.write("Claim Amount: " + claim.getClaimAmount());
            writer.newLine();
            writer.write("Claim Status: " + claim.getStatus());
            writer.newLine();
            writer.write("Banking info: " + claim.getReiveBankingInfo());
            writer.newLine();
            writer.write("-----------------------------------");
            writer.newLine(); // Add this line
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}