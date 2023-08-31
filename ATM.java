import java.util.HashMap;

public class ATM
{
    String email;
    double balance;
    HashMap<String, Double> mapOfAccounts;
    //public ATM (String email, double balance)
    public ATM()
    {
        //this.email = email;
        //this.balance = balance;
		mapOfAccounts = new HashMap <String, Double>();
    }

    public HashMap getAccounts()
    {
        return mapOfAccounts;
    }
    public void openAccount (String userID, double amount)
    {
        if (!mapOfAccounts.containsKey(userID))
        {
            mapOfAccounts.put(userID, amount);
        }
        else
        {
            throw new IllegalArgumentException("User ID already exists");
        }
    }
}