import javax.swing.JOptionPane;
public class Test{
    public static void main(String[] args){
        //large number of candidates since the assignment doesn't specify
        final int MAX_CANDIDATES = 500;
        boolean testing = true;
        Candidate[] candidateList = new Candidate[MAX_CANDIDATES];
        int numCandidates = 0;
        while(testing){
            //asking and confirming that the testing process will go on until everyone is finished
            String newUser = JOptionPane.showInputDialog("Would you like to continue the testing process? (Answer 'yes' or 'no'");
            if(newUser.equalsIgnoreCase("yes") && numCandidates < candidateList.length){
                candidateList[numCandidates] = createCandidate();
                createExam(candidateList[numCandidates]);
                printTicket(candidateList[numCandidates]);
                numCandidates++;
            }
            else{
                testing = false;
            }
            //once all users have finished testing they may look up their results
        }
        boolean searching = true;
        while(searching){
            //asking and confirming the searching process will keep going until the users are done looking at results
            String newUser = JOptionPane.showInputDialog("Would you like to continue the searching process? (Answer 'yes' or 'no'");
            if(newUser.equalsIgnoreCase("yes")){
                String userEmail = JOptionPane.showInputDialog("Please enter the email of the user whose results you would like to see.");
                for(int x=0; x<candidateList.length; x++){
                    //check all candidates available then compare emails. If emails match print result string.
                    if(candidateList[x] != null){
                        if(candidateList[x].getEmail().equalsIgnoreCase(userEmail)){
                            JOptionPane.showMessageDialog(null, candidateList[x].printResults());
                        }
                    }
                }
            }
            else{
                searching = false;
            }
        }
        //once all users are finished reports are printed
        printExamSummary(candidateList);
        printCandidateRoster(candidateList);
    }
    
    public static Candidate createCandidate(){
        String fullName = JOptionPane.showInputDialog("What is your full name?");
        String email = JOptionPane.showInputDialog("What is your email?");
        String address = JOptionPane.showInputDialog("What is your address?");
        String city = JOptionPane.showInputDialog("What is your city?");
        String state = JOptionPane.showInputDialog("What is your state?");
        String zip = JOptionPane.showInputDialog("What is your zip code? (must be 5 digits)");
        String phone = JOptionPane.showInputDialog("What is your phone number? (must be 10 digits: xxxxxxxxxx format)");
        String employed = JOptionPane.showInputDialog("Are you employed? (answer 'yes' or 'no')");
        if(employed.equalsIgnoreCase("yes")){
            String employerName = JOptionPane.showInputDialog("What is your employer's name?");
            String employerPhone = JOptionPane.showInputDialog("What is your employer's phone number?");
            int yearsEmployed = Integer.parseInt(JOptionPane.showInputDialog("How many years have you been employed? (Must be greater than 0)"));
            Candidate newCandidate;
            try{
                newCandidate = new Employer(fullName, email, address, city, state, zip, phone, employerName, employerPhone, yearsEmployed);
            }catch(IllegalArgumentException e){
                throw e;
            }
            return newCandidate;
        }
        else{
            Candidate newCandidate;
            try{
                newCandidate = new Candidate(fullName, email, address, city, state, zip, phone);
            }catch(IllegalArgumentException e){
                throw e;
            }
            return newCandidate;
        }
    }

    public static void createExam(Candidate newCandidate){
        String examID = JOptionPane.showInputDialog("Please enter your exam ID. (Reminder the only exams available are 'C1' 'C2' 'C3' 'C4' 'I1' I2' 'I3' and 'I4').");
        String organization = JOptionPane.showInputDialog("Please enter the organization hosting the exam.");
        String examName = JOptionPane.showInputDialog("Please enter the exam name.");
        int passingScore = Integer.parseInt(JOptionPane.showInputDialog("Please enter the score needed to pass this exam."));
        int experienceNeeded = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of years of experience needed to pass this exam."));
        try{
            newCandidate.setExam(examID, organization, examName, passingScore, experienceNeeded);
        }catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void printTicket(Candidate newCandidate){
        JOptionPane.showMessageDialog(null, newCandidate.toString() +"\n Exam Name: " + newCandidate.getExam().getExamName());
    }
    
    public static int calculatePassingExams(Candidate[] candidateList){
        int passingExams = 0;
        for(int x=0; x<candidateList.length; x++){
            if(candidateList[x] != null){
                if(candidateList[x].passFail()){
                    passingExams++;
                }
            }
        }
        return passingExams;
    }

    public static void printExamSummary(Candidate[] candidateList){
        int totalExams = 0;
        for(int x=0; x<candidateList.length; x++){
            if(candidateList[x] != null){
                totalExams++;
            }
        }
        int passingExams = calculatePassingExams(candidateList);
        int failingExams = totalExams - passingExams;
        JOptionPane.showMessageDialog(null, "Exams: \nTotal Exams: " + totalExams + "\nPassing Exams: " + passingExams + "\nFailing Exams: " + failingExams);
    }

    public static void printCandidateRoster(Candidate[] candidateList){
        for(int x=0; x<candidateList.length; x++){
            if(candidateList[x] != null){
                JOptionPane.showMessageDialog(null, candidateList[x].printResults());
            }
        }
    }
}