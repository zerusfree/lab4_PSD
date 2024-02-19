import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {

    @org.junit.jupiter.api.Test
    void testPermute() {
        // Створюємо новий потік виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        int[] array = {1, 2, 3};
        Main.permute(array, 0, array.length - 1);

        // Перевіряємо вивід
        String expectedOutput  = "[1, 2, 3]\n[1, 3, 2]\n[2, 1, 3]\n[2, 3, 1]\n[3, 2, 1]\n[3, 1, 2]\n";
        // міняємо формат символів нового рядка
        expectedOutput = expectedOutput.replace("\n", System.lineSeparator());

        assertEquals(expectedOutput, outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void TestCombinations() {
        int n = 5;
        int r = 3;
        int[] array = new int[r];
        Main.nextCombination(array, n, 0);
    }
}