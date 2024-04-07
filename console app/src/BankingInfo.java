/**
 * @author <Dong Dang Khoa- s3986281>
 */

public class BankingInfo {
    private String Bank;
    private String Name;
    private String Number;

    public BankingInfo() {
        this.Bank = "Default";
        this.Name = "Default";
        this.Number = "Default";
    }

    public BankingInfo(String bank, String name, String number) {
        this.Bank = bank;
        this.Name = name;
        this.Number = number;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    @Override
    public String toString() {
        return String.format("%s – %s – %s", Bank, Name, Number);
    }
}