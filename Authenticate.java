
public class Authenticate {

    static AccountHolder login(int acno, String pwd) {

        for (AccountHolder ach : Database.totalAccounts) {
           if(ach.acno == acno && ach.password.equals(pwd))
                return ach;
        }
        return null;
    }
}
