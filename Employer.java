public class Employer extends Candidate{
    private String employerName;
    private String employerPhone;
    private int yearsEmployed;

    //constructors
    public Employer(String fullName, String email, String address, String city, String state, String zip, String phone, String employerName, String employerPhone, int yearsEmployed){
        super(fullName, email, address, city, state, zip, phone);
        if(!employerName.equals(null) && employerPhone.length() == 10 && yearsEmployed > 0){
            this.employerName = employerName;
            this.employerPhone = employerPhone;
            this.yearsEmployed = yearsEmployed;
        }
    }

    //accessors
    public String getEmployerName(){
        return this.employerName;
    }
    public String getEmployerPhone(){
        return this.employerPhone;
    }
    public int getYearsEmployed(){
        return this.yearsEmployed;
    }

    //mutators
    public void setEmployerName(String employerName){
        if(!employerName.equals(null)){
            this.employerName=employerName;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setEmployerPhone(String employerPhone){
        if(employerPhone.length() == 10){
            this.employerPhone = employerPhone;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setYearsEmployed(int yearsEmployed){
        if(yearsEmployed > 0){
            this.yearsEmployed = yearsEmployed;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }

    //special purpose
    public String toString(){
        return "Employed Candidate: "
        +"\nName: " + this.getFullName()
        +"\nEmail: " + this.getEmail()
        +"\nAddress: " + this.getAddress()
        +"\nCity: " + this.getCity()
        +"\nState: " + this.getState()
        +"\nZIP: " + this.getZip()
        +"\nPhone: " + this.getPhone()
        +"\nEmployer Name: " + this.getEmployerName()
        +"\nEmployer Phone: " + this.getEmployerPhone()
        +"\nYears Employed: " + this.getYearsEmployed();
    }
}