public class AccountHolder {
    String name, mailid, dob, password, address, phoneno;
    int acno;
    Account accountInfo;

    AccountHolder(String name, String mailid, String dob, String password, String address, String phoneno, int acno,
            Account accountInfo) {
        this.accountInfo = accountInfo;
        this.acno = acno;
        this.name = name;
        this.mailid = mailid;
        this.dob = dob;
        this.password = password;
        this.address = address;
        this.phoneno = phoneno;
    }

    AccountHolder() {
    }

    void displayInfo() {
        System.out.println("Name :" + this.name + "\n" + "Mail :" + this.mailid + "\n" + "Acno :" + this.acno);
    }

}
