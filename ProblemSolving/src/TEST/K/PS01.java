package TEST.K;

public class PS01 {
    public static void main(String[] args) {
        String[] strings = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    //문자열 처리
    //아이디의 길이는 3자 이상 15자 이하여야 합니다.
    //아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
    //단, 마침표(.)는 처음과 끝에 사용할 없으며 또한 연속으로 사용할 수 없습니다.
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')) {
                new_id = new_id.replace(Character.toString(c), " ");
            }
        }
        new_id = new_id.replace(" ", "");
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        String[] strings = new_id.split("");
        for (int i = 0; i < strings.length; i++) {
            if (i == 0 && strings[i].equals(".")) {
                strings[i] = "";
            } else if (i == strings.length - 1 && strings[strings.length - 1].equals(".")) {
                strings[strings.length - 1] = "";
            }
        }
        new_id = "";
        for (int i = 0; i < strings.length; i++) {
            new_id += strings[i];
        }
        if (new_id.equals("")) {
            new_id = "a";
        }
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }
        if (new_id.length() == 1) {
            String tmp = new_id;
            for (int i = 0; i < 2; i++) {
                new_id += tmp;
            }
        } else if (new_id.length() == 2) {
            new_id += Character.toString(new_id.charAt(1));
        }
        return new_id;
    }
}