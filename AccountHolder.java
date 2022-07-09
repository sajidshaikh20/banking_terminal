import javax.swing.plaf.synth.SynthSeparatorUI;

class AccountHolder extends Account {
    String name, mailid, dob, password, address, phoneno;

    AccountHolder(String name, String mailid, String dob, String password, String address, String phoneno, int acno,
            int balance) {
        this.balance = balance;
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
        System.out.println("acno :" + acno);
        System.out.println("name :" + name);
        System.out.println("mailid :" + mailid);
        System.out.println("dob :" + dob);
        System.out.println("balance :" + balance);
        System.out.println("branc :" + branch);
    }

    void showStatements() {
        for (Statement statement : transHistory) {
            System.out.println("Transaction ID :" + statement.tranID);
            System.out.println("Status :" + statement.status);
            System.out.println("Amount :" + statement.amount);
            if (statement.status == Status.TRANSFER) {
                System.out.println("Sender Acno :" + statement.sacno);
                System.out.println("Reciever Acno :" + statement.racno);
            }
            System.err.println();
        }
    }

}
