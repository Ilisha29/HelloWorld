package KAKAO.KAKAO2018공채;

import java.util.Arrays;
import java.util.Comparator;

// 10 : 02 start
public class KAKAO2018공채_파일명정렬 {

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files1 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] answer = solution(files1);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    //소스 파일 저장소에 저장된 파일명은 100 글자 이내로,
    // 영문 대소문자, 숫자, 공백(" ), 마침표(.), 빼기 부호(-")만으로 이루어져 있다.
    //파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
    //파일명은 크게 HEAD, NUMBER, TAIL의 세 부분으로 구성된다.

    //012와 12는 정렬 시에 같은 같은 값으로 처리된다.

    //files는 1000 개 이하의 파일명을 포함하는 문자열 배열이다.
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                o1 = o1.replace(head1, "");
                head1 = head1.toUpperCase();
                String tempNum = "";
                for (char c : o1.toCharArray()) {
                    if (Character.isDigit(c) && tempNum.length() < 5) {
                        tempNum += c;
                    } else {
                        break;
                    }
                }
                int num1 = Integer.parseInt(tempNum);

                String head2 = o2.split("[0-9]")[0];
                o2 = o2.replace(head2, "");
                head2 = head2.toUpperCase();
                String tempNum2 = "";
                for (char c : o2.toCharArray()) {
                    if (Character.isDigit(c) && tempNum2.length() < 5) {
                        tempNum2 += c;
                    } else {
                        break;
                    }
                }
                int num2 = Integer.parseInt(tempNum2);

                return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2);
            }
        });
/*

        String[] answer = new String[files.length];
        ArrayList<FileByHead> fileByHeads = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String string = files[i];
            int headIndex = 0;
            for (int j = 0; j < string.length(); j++) {
                if (48 <= string.charAt(j) && string.charAt(j) <= 57) {
                    headIndex = j;
                    break;
                }
            }
            String Head = string.substring(0, headIndex);
            String others = string.substring(headIndex);

            int numberIndex = 0;
            for (int j = 0; j < others.length(); j++) {
                if (!(48 <= others.charAt(j) && others.charAt(j) <= 57)) {
                    numberIndex = j;
                    break;
                }
            }
            String number = others.substring(0, numberIndex);
            String tail = others.substring(numberIndex);
            fileByHeads.add(new FileByHead(Head, number, tail));
        }
        Collections.sort(fileByHeads);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fileByHeads.get(i).head + fileByHeads.get(i).number + fileByHeads.get(i).tail;
        }*/
        return files;
    }

}
/*
class FileByHead implements Comparable<FileByHead> {
    public String head;
    public String upperCaseHead;
    public String number;
    public int newNum;
    public String tail;

    public FileByHead(String head, String number, String tail) {
        this.head = head;
        this.upperCaseHead = head.toUpperCase();
        this.number = number;
        this.newNum = Integer.parseInt(number);
        this.tail = tail;
    }

    @Override
    public int compareTo(FileByHead o) {
        if (this.upperCaseHead.equals(o.upperCaseHead)) {
            if (this.newNum > o.newNum) {
                return 1;
            } else if (this.newNum < o.newNum) {
                return -1;
            } else {
                return 0;
            }
        } else {
            int thisLength = this.upperCaseHead.length();
            int olength = o.upperCaseHead.length();
            int compareMAx = olength < thisLength ? olength : thisLength;
            for (int i = 0; i < compareMAx; i++) {
                if (this.upperCaseHead.charAt(i) > o.upperCaseHead.charAt(i)) {
                    return 1;
                } else if (this.upperCaseHead.charAt(i) < o.upperCaseHead.charAt(i)) {
                    return -1;
                } else {
                    continue;
                }
            }
            if (thisLength > olength) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}*/
