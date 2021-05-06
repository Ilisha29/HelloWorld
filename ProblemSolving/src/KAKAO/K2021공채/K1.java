package KAKAO.K2021공채;

public class K1 {
    public static void main(String[] args) {
        String[] new_ids = {
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"
        };
        for (int i = 0; i < new_ids.length; i++) {
            System.out.println(solution(new_ids[i]));
        }
    }

    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String[] split = new_id.split("");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < split.length; i++) {
            char c = split[i].charAt(0);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                stringBuilder.append(split[i]);
            }
        }
        new_id = stringBuilder.toString();
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.length() == 0) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.length() == 15 && new_id.charAt(14) == '.') {
            new_id = new_id.substring(0, 14);
        }
        if (new_id.length() == 1) {
            String tmp = new_id;
            for (int i = 0; i < 2; i++) {
                new_id += tmp;
            }
        } else if (new_id.length() == 2) {
            new_id += new_id.substring(1, 2);
        }
        return new_id;
    }
}
