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
            AccountHolder ach  =  Authenticate.login(input_acno, input_pwd);
            if(ach == null){
                System.out.println("invalid account or password");
            }else{
                System.out.println("1. Account Details \n 2. Deposit \n 3. Withdrawal \n 4. Transfer 5. Statement");
                int choice = sc.nextInt();
                loginMenu(choice,ach,sc);
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

            ach.acno = Account.getAcno();
            //saved the user into our database array
            Database.totalAccounts.add(ach);
            System.out.println("Account successfuly create , Please login with your credentials, your acno is "+ach.acno);
        }else{
            //invalid input 
            System.out.println("invalid input retry");
        }
        }
    }

    static void loginMenu(int choice,AccountHolder ach,Scanner sc){
        switch(choice){
            case 1:
            //display 
            ach.displayInfo();
             break;
            case 2:
            System.out.println("enter amount to deposit");
            int amount = sc.nextInt();
            boolean status = ach.depositAmount(amount);
            if(status)
                System.out.println("amount deposited");
            else 
                System.out.println("Please try again");

            break;
            case 3:
            //withdrawal
            System.out.println("enter the amount to withdrawal");
            int wdAmount = sc.nextInt();
            boolean wdstatus = ach.withdrawalAmount(wdAmount);
            if(wdstatus)
                System.out.println("Collect your amount");
            else 
                System.out.println("Insuffecient Fund");
            break;
            case 4:
            System.out.println("Enter third party Ac no");
            int sacno = sc.nextInt();
            System.out.println("Enter amount to transfer");
            int tranAmount = sc.nextInt();
            boolean trnStatus = ach.runTransaction(tranAmount, sacno);
            if(trnStatus)
                System.err.println("Transaction successful");
            else 
                System.out.println("Something went wrong");
            break;
            case 5:
            //statement
            ach.showStatements();
            break;
            default:
            System.out.println("Invalid choice");
        }
    }
}