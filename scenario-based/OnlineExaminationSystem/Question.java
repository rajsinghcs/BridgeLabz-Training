class Question {
    private int id;
    private String questionText;
    private String correctAnswer;

    public Question(int id, String questionText, String correctAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public int getId() {
    return id;
}
}
