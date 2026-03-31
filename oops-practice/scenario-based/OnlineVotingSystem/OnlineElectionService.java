import java.util.*;

class OnlineElectionService extends ElectionService {

    private Map<Integer, Voter> voters = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private List<Vote> votes = new ArrayList<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.put(voter.getVoterId(), voter);
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.hashCode(), candidate);
    }

    @Override
    public void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException {

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Voter has already voted!");
        }

        candidate.addVote();
        voter.markVoted();
        votes.add(new Vote(voter.getVoterId(), candidate.hashCode()));
    }

    @Override
    public void declareResults() {
        System.out.println("Election Results:");
        for (Candidate c : candidates.values()) {
            System.out.println(
                c.getName() + " : " + c.getVoteCount() + " votes"
            );
        }
    }
}
