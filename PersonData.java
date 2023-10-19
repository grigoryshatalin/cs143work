/**
 * 
 * @author YOUR NAME 
 *
 */

public class PersonData extends HasState 
{
    
    protected String lastName;
    protected String firstName;
    protected String address;
    protected String phone;
    
    
    public String toString()
    {
        //Do not change this implementation
        return "First name: "+firstName+"; Last name: "+lastName+"; Address: "+address+"; Phone: "+phone;
    }
 }