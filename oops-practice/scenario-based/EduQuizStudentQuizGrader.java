public class EduQuizStudentQuizGrader {

    // calculate score
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        // Correct answers
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "C", "B", "D", "A", "C"
        };

        // Student answers
        String[] studentAnswers = {
            "a", "b", "d", "d", "A",
            "c", "b", "a", "A", "c"
        };

        // feedback
        System.out.println("Quiz Feedback:");
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        // Score calculation
        int score = calculateScore(correctAnswers, studentAnswers);
        int totalQuestions = correctAnswers.length;

        // Percentage
        double percentage = (score * 100.0) / totalQuestions;

        System.out.println("\nTotal Score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        // Pass / Fail
        if (percentage >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}
