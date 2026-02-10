import java.util.*;
public class ResumeShortlistingSystem {
    public static void main(String[] args) {
        try {
            Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "SQL", "Spring"));

            List<Resume> resumes = new ArrayList<>();

            resumes.add(new Resume("Raj", Set.of("Java", "SQL", "Spring")));
            resumes.add(new Resume("Nived", Set.of("Java", "HTML")));
            resumes.add(new Resume("Rohit", Set.of("Python", "SQL")));

            for (Resume r : resumes) {
                r.calculateMatchCount(requiredSkills);
            }

            Collections.sort(resumes, new ResumeComparator());

            System.out.println("Shortlisted Resumes:");
            for (Resume r : resumes) {
                System.out.println(r.candidateName +
                        " - Matching Skills: " + r.matchCount);
            }

        } catch (InvalidResumeException e) {
            System.out.println(e.getMessage());
        }
    }
}