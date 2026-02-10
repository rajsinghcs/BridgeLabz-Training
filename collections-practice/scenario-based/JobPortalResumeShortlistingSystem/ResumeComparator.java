import java.util.*;
class ResumeComparator implements Comparator<Resume> {
    @Override
    public int compare(Resume r1, Resume r2) {
        return Integer.compare(r2.matchCount, r1.matchCount);
    }
}