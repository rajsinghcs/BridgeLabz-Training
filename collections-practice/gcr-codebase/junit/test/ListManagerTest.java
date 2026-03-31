import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ListManagerTest {

    ListManager listManager = new ListManager();
    List<Integer> list = new ArrayList<>();

    @Test
    void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);
        listManager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    void testGetSize() {
        listManager.addElement(list, 5);
        listManager.addElement(list, 15);

        assertEquals(2, listManager.getSize(list));
    }
}
