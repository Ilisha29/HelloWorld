package BOJ;

import java.util.Scanner;

public class BOJ5555 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int tCase = scanner.nextInt();
        String[] strings = new String[tCase];
        for (int i = 0; i < tCase; i++) {
            strings[i] = scanner.next();
            strings[i] += strings[i];
        }

        int answer = 0;
        for (int i = 0; i < strings.length ; i++) {
            if(strings[i].contains(string)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
