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
                loginMenu(choice,ach);

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

    static void loginMenu(int choice,AccountHolder ach){
        switch(choice){
            case 1:
            //display 
            ach.displayInfo();
             break;
            case 2:
            //deposit
            break;
            case 3:
            //withdrawal
            break;
            case 4:
            //transfer 
            break;
            case 5:
            //statement
            break;
            default:
            System.out.println("Invalid choice");
        }
    }
}