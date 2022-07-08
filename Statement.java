enum Status{
    DEBIT,CREDIT,FAILED
}

public class Statement {
    int racno,sacno,amount,tranID;
    String date;
    Status status;

    Statement(int racno,int sacno,int amount,int tranID,String date , Status status){
        this.status = status;
        this.racno=racno;
        this.sacno=sacno;
        this.amount=amount;
        this.tranID=tranID;
        this.date=date; 
    }


}
