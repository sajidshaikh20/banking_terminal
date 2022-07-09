enum Status{
    DEBIT,CREDIT,FAILED,TRANSFER
}

public class Statement {
    int racno,sacno,amount,tranID;
    Status status;

    Statement(int racno,int sacno,int amount,int tranID,String date , Status status){
        this.status = status;
        this.racno=racno;
        this.sacno=sacno;
        this.amount=amount;
        this.tranID=tranID;
    }
    Statement(){}


}
