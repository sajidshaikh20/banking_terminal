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
        System.out.println("name :" +name);
        System.out.println("mailid :" +mailid);
        System.out.println("dob :" +dob);
        System.out.println("balance :" +balance);
        System.out.println("branc :" + branch); }

}
