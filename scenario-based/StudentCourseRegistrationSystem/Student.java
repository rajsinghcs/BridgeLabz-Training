class Student extends RegistrationService {

    private int studentId;
    private Course[] courses = new Course[3];
    private int courseCount = 0;
    private String name;
    private int age;

    Student(String name, int age, int studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    @Override
    void enrollCourse(Course course) throws CourseLimitExceededException {
        if (courseCount >= courses.length) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }
        courses[courseCount++] = course;
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    @Override
    void dropCourse(Course course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(course.getCourseName())) {
                courses[i] = courses[courseCount - 1];
                courses[courseCount - 1] = null;
                courseCount--;
                System.out.println(name + " dropped " + course.getCourseName());
                return;
            }
        }
    }

    @Override
    void viewGrades() {
        System.out.println("\nGrades of " + name);
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].getCourseName() + " - " + courses[i].getGrade());
        }
    }

    void assignGrade(String courseName, String grade) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equals(courseName)) {
                courses[i].setGrade(grade);
            }
        }
    }
}
