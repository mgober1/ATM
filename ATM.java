import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

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

    public void closeAccount (String userID)
    {
        if (Objects.equals(mapOfAccounts.get(userID), 0.0))
        {
            mapOfAccounts.remove(userID);
        }
        else
        {
            throw new IllegalArgumentException("Withdraw " + mapOfAccounts.get(userID) + "$ before closing");
        }
    }

    public double checkBalance (String userID)
    {
        if (mapOfAccounts.containsKey(userID))
        {
            return mapOfAccounts.get(userID);
        }
        else
        {
            throw new IllegalArgumentException("This account does not exist");
        }
    }

    public double depositMoney (String userID, double amount)
    {
        if (mapOfAccounts.containsKey(userID))
        {
            amount += mapOfAccounts.get(userID);
            mapOfAccounts.put(userID, amount);
            return amount;
        }
        else
        {
            throw new IllegalArgumentException("You have no money");
        }
    }
    
    public double withdrawMoney (String userID, double amount)
    {
        if (amount <= mapOfAccounts.get(userID))
        {
            amount =  mapOfAccounts.get(userID) - amount;
            mapOfAccounts.put(userID, amount);
            return amount;
        }
        else
        {
            throw new IllegalArgumentException("You have insufficient funds");
        }
    }
    
    public boolean transferMoney (String fromAccount, String toAccount, double amount)
    {
        if (amount <= mapOfAccounts.get(fromAccount))
        {
            double balance = amount;
            amount = mapOfAccounts.get(fromAccount) - amount;
            mapOfAccounts.put(fromAccount, amount);
            amount += mapOfAccounts.get(toAccount);
            mapOfAccounts.put(toAccount, balance);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void audit() throws FileNotFoundException 
    {
        PrintWriter writer = new PrintWriter ("AccountAudit.txt");
        for (String account : mapOfAccounts.keySet())
        {
            writer.println(account);
            writer.println("" + mapOfAccounts.get(account));
        }
        writer.close();
    }
}