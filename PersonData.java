public class PersonData extends HasState implements Cloneable {

    protected String lastName;
    protected String firstName;
    protected String address;
    protected String phone;

    public PersonData() {
        this("", "", "", "");
    }

    public PersonData(String firstName, String lastName, String address, String phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }

    // Accessor methods
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Mutator methods
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public PersonData clone() {
        try {
            return (PersonData) super.clone();
        } catch (CloneNotSupportedException e) {
            // Handle CloneNotSupportedException gracefully
            System.err.println("Clone not supported for PersonData");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonData other = (PersonData) obj;
        return this.lastName.equals(other.lastName) &&
                this.firstName.equals(other.firstName) &&
                this.address.equals(other.address) &&
                this.phone.equals(other.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, address, phone);
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "; Last name: " + lastName + "; Address: " + address + "; Phone: " + phone;
    }
}
