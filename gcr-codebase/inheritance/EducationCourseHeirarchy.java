class Course{
    String courseName;
    int duration;
    Course(String courseName, int duration){
        this.courseName = courseName;
        this.duration = duration;
    }
}
class OnlineCourse extends Course{
    String platform;
    boolean inRecorded;
    OnlineCourse(String courseName, int duration, String platform, boolean inRecorded){
        super(courseName, duration);
        this.platform = platform;
        this.inRecorded = inRecorded;
    }

}
class PaidOnlineCourse extends OnlineCourse{
    int fee;
    int discount;
    PaidOnlineCourse(String courseName,int duration,String platform,boolean isRecorded,int fee,int discount){
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
}
public class EducationCourseHeirarchy {
    public static void main(String[] args) {
        PaidOnlineCourse p = new PaidOnlineCourse("Java", 12, "Udemy", true, 1000, 10);
        System.out.println("Course Name: " + p.courseName + ", Duration: " + p.duration + ", Platform: " + p.platform + ", Is Recorded: " + p.inRecorded + ", Fee: " + p.fee + ", Discount: " + p.discount);
    }
}
