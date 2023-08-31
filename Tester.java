import java.util.HashMap;

public class Tester 
{
    public static void main (String [] args)
    {
        ATM teller = new ATM();
        teller.openAccount("mgober1", 12.00);
        HashMap accounts = teller.getAccounts();
        System.out.println(accounts.get("mgober1"));
        teller.openAccount("mgober1", 12.00);
    }
}
