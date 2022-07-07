public class Account {
    int acno,balance;
    String branch;
    Statement[] transHistory = new Statement[10];

    Account(int acno,int balance,Statement[] transHistory){
        this.acno = acno ;
        this.balance = balance;
        this.transHistory = transHistory;
        this.branch = "Dewas";
    }
    Account(){}

    void createAccount(AccountHolder ach){
        Account act = new Account();
        act.balance = 0;
        ach.acno = Database.acno;
        act.acno = Database.acno++;
        ach.accountInfo = act;

    }


}
