import java.util.ArrayList;
/**
 * 
 * @author YOUR NAME 
 *
 */

public class CustomerData 
{
    private int customerNumber;
    private boolean mailingList;
    private ArrayList<Long> transactions;

    public String toString()
    {
        //Do not change this implementation
        String str = super.toString()+"; Customer number: "+customerNumber+"; Mailing list: "+mailingList+"; Transactions: "+transactions.toString();
        return str;
    }

}
