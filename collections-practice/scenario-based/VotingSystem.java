import java.util.*;

public class VotingSystem {

    private Map<String, Integer> voteCount = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    public void displayVoteOrder() {
        System.out.println("\nVotes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);

        System.out.println("\nSorted Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayFinalResults() {
        System.out.println("\nFinal Vote Count:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Raj");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Rohit");
        votingSystem.castVote("Nived");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        votingSystem.displayVoteOrder();
        votingSystem.displaySortedResults();
        votingSystem.displayFinalResults();
    }
}
