import java.util.*;

class Resume {
    String candidateName;
    Set<String> skills;
    int matchCount;

    public Resume(String candidateName, Set<String> skills) throws InvalidResumeException {
        if (skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume must contain at least one skill");
        }
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public void calculateMatchCount(Set<String> requiredSkills) {
        matchCount = 0;
        for (String skill : skills) {
            if (requiredSkills.contains(skill)) {
                matchCount++;
            }
        }
    }
}