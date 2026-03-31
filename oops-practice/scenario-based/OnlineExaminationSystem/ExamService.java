class ExamService {
    private EvaluationStrategy evaluationStrategy;

    public ExamService(EvaluationStrategy evaluationStrategy) {
        this.evaluationStrategy = evaluationStrategy;
    }

    public int submitExam(Exam exam, Student student, boolean isTimeOver)
            throws ExamTimeExpiredException {

        if (isTimeOver) {
            throw new ExamTimeExpiredException("Exam time expired!");
        }
        return evaluationStrategy.evaluate(exam, student);
    }
}
