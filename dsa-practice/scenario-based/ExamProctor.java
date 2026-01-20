import java.util.*;

class ExamProctor {

    private Stack<Integer> navigationStack = new Stack<>();
    private HashMap<Integer, String> answers = new HashMap<>();

    // Visit question
    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
    }

    // Answer question
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    // Calculate score
    public int calculateScore(HashMap<Integer, String> correctAnswers) {
        int score = 0;

        for (int qId : answers.keySet()) {
            if (answers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        ExamProctor exam = new ExamProctor();

        exam.visitQuestion(1);
        exam.visitQuestion(2);
        exam.visitQuestion(3);

        exam.submitAnswer(1, "A");
        exam.submitAnswer(2, "B");
        exam.submitAnswer(3, "C");

        HashMap<Integer, String> correct = new HashMap<>();
        correct.put(1, "A");
        correct.put(2, "C");
        correct.put(3, "C");

        System.out.println("Score: " + exam.calculateScore(correct));
    }
}
