import java.util.*;

public class Main{
    public static void main(String args[]){
        final Scanner sc = new Scanner(System.in);
       
       while(true){
        System.out.println("1. login \n 2. create account");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            //user login
            System.out.println("Enter your Account Number");
            int input_acno = sc.nextInt();
            System.out.println("Enter your Password");
            String input_pwd = sc.next();
            Authenticate auth = new Authenticate();
            AccountHolder ach =  auth.login(input_acno, input_pwd);
            if(ach.acno == 0){
                System.out.println("invalid account or password");
            }else{
                //next phase starts here 
            }
            

        }else if(input == 2){
            //create account
            AccountHolder ach = new AccountHolder();
            System.out.println("Enter your name");
            ach.name = sc.nextLine();
            System.out.println("Enter your mailid");
            ach.mailid = sc.nextLine();
            System.out.println("Enter your dob");
            ach.dob = sc.nextLine();
            System.out.println("Enter your phone no");
            ach.phoneno = sc.nextLine();
            System.out.println("Enter your address");
            ach.address = sc.nextLine();
            System.out.println("Enter your password");
            ach.password = sc.nextLine();
            
            new Account().createAccount(ach);
            //saved the user into our database array
            Database.totalAccounts[Database.idx++] = ach;
            System.out.println("Account successfuly create , Please login with your credentials");
        }else{
            //invalid input 
            System.out.println("invalid input retry");
        }
        }
    }
}