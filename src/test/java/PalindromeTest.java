import greenatom.bykov.Main;
import org.testng.annotations.Test;

public class PalindromeTest {
    @Test
    public void testCorrectness() {
        assert Main.checkIfPalindrome("aboba");
    }

    @Test
    public void testWrongOne() {
        assert !Main.checkIfPalindrome("Java");
    }

    @Test
    public void testNumbers() {
        assert Main.checkIfPalindrome("1206021");
    }

    @Test
    public void testCaseSensitivity() {
        assert Main.checkIfPalindrome("SATOR AREPO TENET OPERA ROTAS");
        assert !Main.checkIfPalindrome("SATOR AREPO TENeT OPERA ROTAS");
    }

    @Test
    public void testCyrillic() {
        assert Main.checkIfPalindrome("искатьтакси");
    }

    @Test
    public void testTwoNumbers() {
        int[] numbers = Main.changeNumbersWithoutThirdVariable(2, 7);
        assert numbers[0] == 7 && numbers[1] == 2;
    }

}
