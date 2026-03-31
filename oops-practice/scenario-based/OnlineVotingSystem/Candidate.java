class Candidate {
    private int candidateId;
    private String name;
    private int voteCount;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.voteCount = 0;
    }

    public void addVote() {
        voteCount++;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getName() {
        return name;
    }
}
