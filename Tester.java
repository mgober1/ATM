import java.io.IOException;
import java.util.HashMap;

public class Tester 
{
    public static void main (String [] args) throws IOException
    {
        ATM teller = new ATM();
        HashMap accounts = teller.getAccounts();
        teller.openAccount("mgober1", 69.00);
        teller.openAccount("test transfer", 0.0);
        //System.out.println(teller.checkBalance("mgober1"));
        teller.depositMoney("mgober1", 351.00);
        teller.transferMoney("mgober1", "test transfer", 420.00);
        teller.depositMoney("mgober1", 69.00);
        teller.audit();
        //teller.withdrawMoney("mgober1", 69420.00);
        //teller.closeAccount("mgober1");
        //System.out.println(teller.checkBalance("mgober1"));
        //System.out.println(teller.checkBalance("test transfer"));
        //teller.getAccounts();
    }
}
