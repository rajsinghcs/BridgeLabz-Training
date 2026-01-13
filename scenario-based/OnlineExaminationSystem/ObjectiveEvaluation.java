class ObjectiveEvaluation implements EvaluationStrategy {
    @Override
    public int evaluate(Exam exam, Student student) {
        int score = 0;

        for (Question q : exam.getQuestions()) {
            String ans = student.getAnswers().get(q.getId());

            if (ans != null && q.getCorrectAnswer().equalsIgnoreCase(ans)) {
                score++;
            }
        }
        return score;
    }
}
