package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String condition1 = "aeiou";
        while (true) {
            String string = bufferedReader.readLine();
            if (string.equals("end")) {
                break;
            }
            //condition 1
            String[] letters = string.split("");
            boolean condition1check = false;
            for (int i = 0; i < letters.length; i++) {
                if (condition1.contains(letters[i])) {
                    condition1check = true;
                    break;
                }
            }
            //condition 2
            boolean condition2check = true;
            if (string.length() >= 2) {
                for (int i = 0; i < string.length() - 1; i++) {
                    String substring = string.substring(i, i + 2);
                    if (substring.equals("ee") || substring.equals("oo")) {
                        continue;
                    }
                    String[] strings = substring.split("");
                    if (strings[0].equals(strings[1])) {
                        condition2check = false;
                        break;
                    }
                }
            }
            //condition3
            boolean condition3check = true;
            int momNum = 0;
            int sunNum = 0;
            for (int i = 0; i < letters.length; i++) {
                if (momNum == 3 || sunNum == 3) {
                    condition3check = false;
                    break;
                }
                if (condition1.contains(letters[i])) {
                    momNum++;
                    sunNum = 0;
                } else {
                    sunNum++;
                    momNum = 0;
                }
            }
            if (momNum == 3 || sunNum == 3) {
                condition3check = false;
            }
            if (condition1check && condition2check && condition3check) {
                System.out.println("<" + string + "> is acceptable.");
            } else {
                System.out.println("<" + string + "> is not acceptable.");
            }
        }
        bufferedReader.close();
    }
}
