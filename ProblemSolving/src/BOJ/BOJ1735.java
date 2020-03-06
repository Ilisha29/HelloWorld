package BOJ;

import java.util.Scanner;

public class BOJ1735 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstUp = scanner.nextInt();
        int firstDown = scanner.nextInt();
        int secondUP = scanner.nextInt();
        int secondDown = scanner.nextInt();
        if (secondDown > firstDown) {
            int tmp = secondDown;
            secondDown = firstDown;
            firstDown = tmp;
            tmp = secondUP;
            secondUP = firstUp;
            firstUp = tmp;
        }
        //최소공배수 만들어주기
        int bcd = BCD(firstDown, secondDown);
        int Down = firstDown * secondDown / bcd;
        int Up = firstUp * secondDown / bcd + secondUP * firstDown / bcd;
        //기약분수로 만들어주기
        int bcd2 = BCD(Down, Up);
        System.out.println(Up / bcd2 + " " + Down / bcd2);
    }

    private static int BCD(int a, int b) {
        return (a % b == 0) ? b : BCD(b, a % b);
    }
}
