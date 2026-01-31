import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.Test;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String filename = "testfile.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit";

        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);

        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(filename, "Test Content");

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    void testReadNonExistingFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("non_existing_file.txt");
        });
    }
}
