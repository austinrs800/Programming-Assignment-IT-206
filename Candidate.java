public class Candidate{
    private String fullName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private Exam exam;

    //constructors
    public Candidate(String fullName, String email, String address, String city, String state, String zip, String phone){
        //validation
        if(!fullName.equals(null) && !email.equals(null) && !address.equals(null) && !city.equals(null) && !state.equals(null) && zip.length() == 5 && phone.length() == 10){
            this.fullName = fullName;
            this.email = email;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
        }
        else{
            throw new IllegalArgumentException("Invalid inputs provided. Make sure no field is blank and the zip and phone have exactly 5 and 10 characters respectively.");
        }
    }
    public Candidate(String fullName, String email, String address, String city, String state, String zip, String phone, String examID, String organization, String examName, int passingScore, int experienceNeeded){
        //validation
        if(!fullName.equals(null) && !email.equals(null) && !address.equals(null) && !city.equals(null) && !state.equals(null) && zip.length() == 5 && phone.length() == 10){
            this.fullName = fullName;
            this.email = email;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
        }
        else{
            throw new IllegalArgumentException("Invalid inputs provided. Make sure no field is blank and the zip and phone have exactly 5 and 10 characters respectively.");
        }
        try{
            this.exam = new Exam(examID, organization, examName, passingScore, experienceNeeded);
        }catch(IllegalArgumentException e){
            throw e;
        }
    }

    //accessors
    public String getFullName(){
        return this.fullName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getZip(){
        return this.zip;
    }
    public String getPhone(){
        return this.phone;
    }
    public Exam getExam(){
        return this.exam;
    }

    //mutators
    public void setFullName(String fullName){
        if(!fullName.equals(null)){
            this.fullName = fullName;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setEmail(String email){
        if(!email.equals(null)){
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setAddress(String address){
        if(!address.equals(null)){
            this.address = address;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setCity(String city){
        if(!city.equals(null)){
            this.city = city;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setState(String state){
        if(!state.equals(null)){
            this.state = state;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setZip(String zip){
        if(zip.length() == 5){
            this.zip = zip;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setPhone(String phone){
        if(phone.length() == 10){
            this.phone = phone;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setExam(String examID, String organization, String examName, int passingScore, int experienceNeeded){
        try{
            this.exam = new Exam(examID, organization, examName, passingScore, experienceNeeded);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
    public void setExam(Exam exam){
        if(!exam.equals(null)){
            this.exam=exam;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }

    //special purpose
    public boolean passFail(){
        if(this.exam.getCurrentScore() >= this.exam.getPassingScore()){
            return true;
        }
        else{
            return false;
        }
    }
    public String printResults(){
        return "Candidate Information: "
        +"\nName: " + this.getFullName()
        +"\nEmail: " + this.getEmail()
        +"\nExam Taken: " + this.exam.getExamName()
        +"\nPassing?: " + this.passFail();
    }
    public String toString(){
        return "Candidate: "
        +"\nName: " + this.getFullName()
        +"\nEmail: " + this.getEmail()
        +"\nAddress: " + this.getAddress()
        +"\nCity: " + this.getCity()
        +"\nState: " + this.getState()
        +"\nZIP: " + this.getZip()
        +"\nPhone: " + this.getPhone();
    }
}