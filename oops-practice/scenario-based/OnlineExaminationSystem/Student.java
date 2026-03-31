import java.util.*;

class Student {
    private int studentId;
    private String name;
    private Map<Integer, String> answers = new HashMap<>();

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }
}
