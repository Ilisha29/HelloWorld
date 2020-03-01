import java.util.Scanner;

public class BOJ2753 {
    public static void main(String[] args) {
        /*
        연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.

        윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때 이다.

        예를들어, 2012년은 4의 배수라서 윤년이지만, 1900년은 4의 배수이지만, 100의 배수이기 때문에 윤년이 아니다.

        하지만, 2000년은 400의 배수이기 때문에 윤년이다.
         */
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        if ( ((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
