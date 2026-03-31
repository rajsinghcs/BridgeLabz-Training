abstract class RegistrationService {
    abstract void enrollCourse(Course course) throws CourseLimitExceededException;
    abstract void dropCourse(Course course);
    abstract void viewGrades();
}