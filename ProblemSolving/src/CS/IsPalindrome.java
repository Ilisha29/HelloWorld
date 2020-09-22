package CS;

public class IsPalindrome {
    public static void main(String[] args) {
        int num = 123454321;
        System.out.println(num == isPalindrome(num));
    }

    private static int isPalindrome(int num) {
        int reversedNum = 0;

        while (num > 0) {
            reversedNum = (reversedNum * 10) + (num % 10);
            num /= 10;
            System.out.println("reversedNum : " + reversedNum + "  num : " + num);
        }
        return reversedNum;
    }
}
