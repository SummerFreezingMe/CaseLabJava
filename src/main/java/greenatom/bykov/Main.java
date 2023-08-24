package greenatom.bykov;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static int[] changeNumbersWithoutThirdVariable(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[] {a, b};
    }
    public static boolean checkIfPalindrome(String str){
        char[] chars = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            n--;
            if (chars[i] != chars[n]) {
                return false;
            }
        }
        return true;
    }
}