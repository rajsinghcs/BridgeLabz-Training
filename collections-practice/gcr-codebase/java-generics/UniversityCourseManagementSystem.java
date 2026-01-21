import java.util.*;

abstract class CourseType{
    abstract String evaluationMethod();
}

class ExamCourse extends CourseType{
    public String evaluationMethod(){
        return "Exam Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public String evaluationMethod() {
        return "Assignment Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public String evaluationMethod() {
        return "Research Based Evaluation";
    }
}

class Course <T extends CourseType> {
    private String courseName;
    private int credits;
    private T type;

    public Course(String courseName, int credits, T type){
        this.courseName = courseName;
        this.credits = credits;
        this.type = type;
    }

    public void display(){
        System.out.println("Course: " + courseName +"  Credits: " + credits +"  Evaluation: " + type.evaluationMethod());
    }
}

class CourseManager{
    public static void displayAllCourses(List<? extends CourseType> courses){
        for(CourseType course : courses){
            System.out.println(course.evaluationMethod());
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String [] args){
        Course<ExamCourse> math = new Course<>("Maths", 4, new ExamCourse());
        Course<AssignmentCourse> cs = new Course<>("Computer Science", 3, new AssignmentCourse());
        Course<ResearchCourse> phd = new Course<>("AI Research", 5, new ResearchCourse());

        math.display();
        cs.display();
        phd.display();

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        System.out.println("\nEvaluation Methods:");
        CourseManager.displayAllCourses(courseTypes);
    }
}
