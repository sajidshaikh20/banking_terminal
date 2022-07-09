import java.util.ArrayList;

public class Account {
    int acno, balance;
    String branch;
    ArrayList<Statement> transHistory = new ArrayList<Statement>();

    Account(int acno, int balance) {
        this.acno = acno;
        this.balance = balance;
        this.branch = "Dewas";
        // generate statement

    }

    Account() {
    }

    static int getAcno() {
        return Database.acno++;
    }

    boolean depositAmount(int amount) {
        this.balance += amount;
        transHistory.add(createStatement(amount, Status.CREDIT));
        return true;
    }

    boolean withdrawalAmount(int amount) {
        if (validateTransaction(amount)) {
            this.balance -= amount;
            transHistory.add(createStatement(amount, Status.DEBIT));
            return true;
        }
        return false;
    }

    boolean validateTransaction(int amount) {
        return balance >= amount;
    }

    Statement createStatement(int amount, Status status, int... sacno) {
        Statement s = new Statement();
        if (status == Status.CREDIT) {
            // deposit
            s.status = Status.DEBIT;
            s.amount = amount;
            s.tranID = Database.tranID++;
        } else if (status == Status.DEBIT) {
            // withdrwal
            s.status = Status.CREDIT;
            s.amount = amount;
            s.tranID = Database.tranID++;

        } else {
            // transfer
            s.sacno = sacno[0];
            s.amount = amount;
            s.racno = this.acno;
            s.tranID = Database.tranID++;
        }
        return s;
    }

    boolean runTransaction(int amount, int sacno) {
        if (validateTransaction(amount)) {
            AccountHolder senderAch = fetchAccount(sacno);
            if (senderAch != null) {
                this.balance -= amount;
                senderAch.balance += amount;
                transHistory.add(createStatement(amount, Status.TRANSFER, sacno));
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    AccountHolder fetchAccount(int sacno) {

        for (AccountHolder accountHolder : Database.totalAccounts) {
            if (accountHolder.acno == sacno)
                return accountHolder;
        }
        return null;
    }
}
