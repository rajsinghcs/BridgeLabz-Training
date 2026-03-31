public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {

        Student student = new Student("Amit", 20, 101);

        Course c1 = new Course("Java");
        Course c2 = new Course("Python");
        Course c3 = new Course("DBMS");
        Course c4 = new Course("Operating Systems");

        try {
            student.enrollCourse(c1);
            student.enrollCourse(c2);
            student.enrollCourse(c3);
            student.enrollCourse(c4); 
        } catch (CourseLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }

        student.assignGrade("Java", "A");
        student.assignGrade("Python", "B+");
        student.assignGrade("DBMS", "A");

        student.viewGrades();

        student.dropCourse(c2);
        student.viewGrades();
    }
}