package 기출.LINE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String answer_sheet = "4132315142";
        String[] sheets = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};

        String[] answers = answer_sheet.split("");
        int answer = 0;
        for (int i = 0; i < sheets.length - 1; i++) {
            for (int j = i + 1; j < sheets.length; j++) {
                boolean[] map = new boolean[answers.length];
                String[] strings1 = sheets[i].split("");
                String[] strings2 = sheets[j].split("");
                int errorNum = 0;
                for (int k = 0; k < answers.length; k++) {
                    if (strings1[k].equals(strings2[k]) && !strings1[k].equals(answers[k])) {
                        map[k] = true;
                        errorNum++;
                    }
                }

                int maxLength = 0;
                int tmpLength = 0;
                for (int k = 0; k < map.length; k++) {
                    if (!map[k]) {
                        if (tmpLength != 0) {
                            maxLength = tmpLength > maxLength ? tmpLength : maxLength;
                            tmpLength = 0;
                        }
                    } else {
                        tmpLength++;
                    }
                }
                maxLength = tmpLength > maxLength ? tmpLength : maxLength;
                int tmpAnswer = errorNum + maxLength * maxLength;
                answer = tmpAnswer > answer ? tmpAnswer : answer;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
