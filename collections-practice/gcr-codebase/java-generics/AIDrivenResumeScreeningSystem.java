import java.util.*;

abstract class JobRole{
    abstract String getRoleName();
    abstract boolean evaluate();
}

class SoftwareEngineer extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }

    public boolean evaluate() {
        return true; 
    }
}

class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }

    public boolean evaluate() {
        return true;
    }
}

class ProductManager extends JobRole {
    public String getRoleName() {
        return "Product Manager";
    }

    public boolean evaluate() {
        return false;
    }
}


class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role){
        this.candidateName = candidateName;
        this.role = role;
    }

    public T getRole(){
        return role;
    }

    public String getCandidateName(){
        return candidateName;
    }

    public void display() {
        System.out.println("Candidate: " + candidateName +"  Role: " + role.getRoleName());
    }
}

class ResumeScreening{
    public static <T extends JobRole> void screenResume( Resume<T> resume){
        if(resume.getRole().evaluate()){
            System.out.println("Selected for- "+ resume.getRole().getRoleName());
        }else{
            System.out.println("Rejected for- "+ resume.getRole().getRoleName());
        }
    }
}

class ScreeningPipeline {

    public static void processAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Processing role: " + role.getRoleName());
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        
        Resume<SoftwareEngineer> r1 = new Resume<>("Raj", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Rohit", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Nived", new ProductManager());

        r1.display();
        ResumeScreening.screenResume(r1);

        r2.display();
        ResumeScreening.screenResume(r2);

        r3.display();
        ResumeScreening.screenResume(r3);

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        System.out.println("\nScreening Pipeline:");
        ScreeningPipeline.processAll(roles);
    }
}