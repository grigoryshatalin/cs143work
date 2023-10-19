import java.util.ArrayList;
import java.util.Objects;

public class CustomerData extends PersonData implements Cloneable {
    private int customerNumber;
    private boolean mailingList;
    private ArrayList<Long> transactions;

    public CustomerData() {
        super(); // Call the parent class constructor to initialize inherited fields
        this.customerNumber = 0;
        this.mailingList = false;
        this.transactions = new ArrayList<>();
    }

    public CustomerData(String lastName, String firstName, String address, String phone,
                        int customerNumber, boolean mailingList, ArrayList<Long> transactions) {
        super(lastName, firstName, address, phone); // Call the parent class constructor
        this.customerNumber = customerNumber;
        this.mailingList = mailingList;
        this.transactions = new ArrayList<>(transactions); // Create a deep copy
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public ArrayList<Long> getTransactions() {
        return new ArrayList<>(transactions); // Return a deep copy
    }

    public void setTransactions(ArrayList<Long> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions cannot be set to null.");
        }
        this.transactions = new ArrayList<>(transactions); // Create a deep copy
    }

    public void addTransaction(long t) {
        if (t < 0 || Long.toString(t).length() > 15) {
            throw new IllegalArgumentException("Invalid transaction value.");
        }
        transactions.add(t);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        CustomerData that = (CustomerData) other;
        return customerNumber == that.customerNumber &&
               mailingList == that.mailingList &&
               transactions.equals(that.transactions);
    }

    @Override
    public CustomerData clone() {
        try {
            CustomerData cloned = (CustomerData) super.clone();
            cloned.transactions = new ArrayList<>(transactions);
            return cloned;
        } catch (Exception e) {
            System.err.println("Clone not supported: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    @Override
    public String toString() {
        String str = super.toString() + "; Customer number: " + customerNumber + "; Mailing list: " + mailingList + "; Transactions: " + transactions.toString();
        return str;
    }
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public boolean getMailingList() {
        return mailingList;
    }
    
}
