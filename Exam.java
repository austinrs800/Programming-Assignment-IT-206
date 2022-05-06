public class Exam{
    private String examID;
    private String organization;
    private String examName;
    private int passingScore;
    private int currentScore;
    private int experienceNeeded;

    //constructors
    public Exam(String examID, String organization, String examName, int passingScore, int experienceNeeded){
        //validation
        if(!examID.equals(null) && !organization.equals(null) && !examName.equals(null) && passingScore > 0 && experienceNeeded >=0){
            //validate examID
            if(examID.equalsIgnoreCase("C1") || examID.equalsIgnoreCase("C2") || examID.equalsIgnoreCase("C3") || examID.equalsIgnoreCase("C4") 
            || examID.equalsIgnoreCase("I1") || examID.equalsIgnoreCase("I2") || examID.equalsIgnoreCase("I3") || examID.equalsIgnoreCase("I4")){
                this.examID = examID;
                this.organization = organization;
                this.examName = examName;
                this.passingScore = passingScore;
                this.experienceNeeded = experienceNeeded;
            }
            //Im going to assume the user will enter a valid organization, name, etc.
        }
        else{
            throw new IllegalArgumentException("Invalid inputs provided. Make sure not to leave any inputs blank or negative.");
        }
    }
    //accessors
    public String getExamID(){
        return this.examID;
    }
    public String getOrganization(){
        return this.organization;
    }
    public String getExamName(){
        return this.examName;
    }
    public int getPassingScore(){
        return this.passingScore;
    }
    public int getCurrentScore(){
        return this.currentScore;
    }
    public int getExperienceNeeded(){
        return this.experienceNeeded;
    }
    //mutators
    public void setExamID(String examID){
        if(examID.equalsIgnoreCase("C1") || examID.equalsIgnoreCase("C2") || examID.equalsIgnoreCase("C3") || examID.equalsIgnoreCase("C4") 
        || examID.equalsIgnoreCase("I1") || examID.equalsIgnoreCase("I2") || examID.equalsIgnoreCase("I3") || examID.equalsIgnoreCase("I4")){
            this.examID = examID;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setOrganization(String organization){
        if(!organization.equals(null)){
            this.organization = organization;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setExamName(String examName){
        if(!examName.equals(null)){
            this.examName = examName;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setPassingScore(int passingScore){
        if(passingScore > 0){
            this.passingScore = passingScore;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setCurrentScore(int currentScore){
        if(currentScore > 0){
            this.currentScore = currentScore;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    public void setExperienceNeeded(int experienceNeeded){
        if(experienceNeeded >= 0){
            this.experienceNeeded = experienceNeeded;
        }
        else{
            throw new IllegalArgumentException("Invalid input provided.");
        }
    }
    //special purpose
    public String toString(){
        return "Exam Information: "
        +"\nID: " + this.getExamID()
        +"\nOrganization: " + this.getOrganization()
        +"\nName: " + this.getExamName()
        +"\nPassing Score: " + this.getPassingScore()
        +"\nScored Result: " + this.getCurrentScore()
        +"\nExperience Needed: " + this.getExperienceNeeded() + "years.";
    }
}