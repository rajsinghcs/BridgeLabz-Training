import java.util.List;

class Exam {
    private int examId;
    private String title;
    private List<Question> questions;

    public Exam(int examId, String title, List<Question> questions) {
        this.examId = examId;
        this.title = title;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
