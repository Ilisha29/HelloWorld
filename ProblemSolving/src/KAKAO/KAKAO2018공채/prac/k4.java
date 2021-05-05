package KAKAO.KAKAO2018공채.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class k4 {
    public static void main(String[] args) {
        String[][] inputs = {
                {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
                {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
        };
        for (int i = 0; i < inputs.length; i++) {
            String[] answer = solution(inputs[i]);
            for (int j = 0; j < answer.length; j++) {
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String tmpFile = files[i];
            int index;
            for (index = 0; index < tmpFile.length(); index++) {
                if (tmpFile.charAt(index) >= '0' && tmpFile.charAt(index) <= '9') {
                    break;
                }
            }
            String head = tmpFile.substring(0, index);
            tmpFile = tmpFile.replace(head, "");
            for (index = 0; index < tmpFile.length(); index++) {
                if (!(tmpFile.charAt(index) >= '0' && tmpFile.charAt(index) <= '9')) {
                    break;
                }
            }
            String number = tmpFile.substring(0, index);
            String tail = tmpFile.replace(number, "");
            fileList.add(new File(head, number, tail, files[i]));
        }
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String first = o1.head.toLowerCase();
                String second = o2.head.toLowerCase();
                if (first.equals(second)) {
                    int num1 = Integer.parseInt(o1.number);
                    int num2 = Integer.parseInt(o2.number);
                    if (num1 == num2) {
                        return 0;
                    }
                    return num1 - num2;
                }
                return first.compareTo(second);
            }
        });
        String[] answer = new String[fileList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fileList.get(i).originString;
        }
        return answer;
    }
}

class File {
    String head;
    String number;
    String tail;
    String originString;

    public File(String head, String number, String tail, String originString) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.originString = originString;
    }
}
