import java.util.List;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Question q1 = new Question(1, "2 + 2", "4");
        Question q2 = new Question(2, "Capital of India", "Delhi");

        Exam exam = new Exam(101, "Java Basics", List.of(q1, q2));
        Student student = new Student(1, "Raj");

        student.submitAnswer(1, "4");
        student.submitAnswer(2, "Delhi");

        EvaluationStrategy strategy = new ObjectiveEvaluation();
        ExamService service = new ExamService(strategy);

        try {
            int score = service.submitExam(exam, student, false);
            System.out.println("Score: " + score);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
