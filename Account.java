import java.util.ArrayList;

public class Account {
    int acno,balance;
    String branch;
    ArrayList<Statement> transHistory = new ArrayList<Statement>();

    Account(int acno,int balance){
        this.acno = acno ;
        this.balance = balance;
        this.branch = "Dewas";
    }
    Account(){}

    static int  getAcno(){
        return Database.acno++;
    }


}
