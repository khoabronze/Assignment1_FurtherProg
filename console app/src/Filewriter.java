/**
 * @author <Dong Dang Khoa- s3986281>
 */


import java.io.*;
import java.util.HashMap;
public class Filewriter {

    public void rewriteFileWithClaims(HashMap<String, Claim> claimList, String filePath) {
        // Clear the file
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Write the claims to the file
        for (Claim claim : claimList.values()) {
            writeClaimToFile(claim);
        }
    }

    public void writeClaimToFile(Claim claim) {
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
            public void rewriteFileWithInsuranceCards(HashMap<String, InsuranceCard> insuranceCardList, String filePath) {
                // Clear the file
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(filePath);
                    writer.print("");
                    writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // Write the insurance cards to the file
                for (InsuranceCard insuranceCard : insuranceCardList.values()) {
                    writeInsuranceCardToFile(insuranceCard);
                }
            }

            public void writeInsuranceCardToFile(InsuranceCard insuranceCard) {
                String filePath = "insuranceCard.txt";
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                    // Write insurance card information to the file
                    writer.write("Card Number: " + insuranceCard.getCardNumber());
                    writer.newLine();
                    writer.write("Card Holder: " + insuranceCard.getCardHolder());
                    writer.newLine();
                    writer.write("Policy Owner: " + insuranceCard.getPolicyOwner());
                    writer.newLine();
                    writer.write("Expiration Date: " + insuranceCard.getExpirationDate());
                    writer.newLine();
                    writer.write("-----------------------------------");
                    writer.newLine();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

