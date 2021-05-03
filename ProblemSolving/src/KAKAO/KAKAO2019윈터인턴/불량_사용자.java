package KAKAO.KAKAO2019윈터인턴;

// 17 : 35 start
public class 불량_사용자 {
    /*user_id 배열의 크기는 1 이상 8 이하입니다.
    user_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.
    응모한 사용자 아이디들은 서로 중복되지 않습니다.
    응모한 사용자 아이디는 알파벳 소문자와 숫자로만으로 구성되어 있습니다.
    banned_id 배열의 크기는 1 이상 user_id 배열의 크기 이하입니다.
    banned_id 배열 각 원소들의 값은 길이가 1 이상 8 이하인 문자열입니다.
    불량 사용자 아이디는 알파벳 소문자와 숫자, 가리기 위한 문자 '*' 로만 이루어져 있습니다.
    불량 사용자 아이디는 '*' 문자를 하나 이상 포함하고 있습니다.
    불량 사용자 아이디 하나는 응모자 아이디 중 하나에 해당하고 같은 응모자 아이디가 중복해서 제재 아이디 목록에 들어가는 경우는 없습니다.
    제재 아이디 목록들을 구했을 때 아이디들이 나열된 순서와 관계없이 아이디 목록의 내용이 동일하다면 같은 것으로 처리하여 하나로 세면 됩니다.*/
    //["frodo", "fradi", "crodo", "abc123", "frodoc"]  /	["fr*d*", "abc1**"]   /	2
    //["frodo", "fradi", "crodo", "abc123", "frodoc"]  /	["*rodo", "*rodo", "******"]  /	2
    //["frodo", "fradi", "crodo", "abc123", "frodoc"]  /	["fr*d*", "*rodo", "******", "******"]	/  3
    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; // 2
        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; // 2
        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}; // 3
        String[] banned_id1 = {"fr*d*", "abc1**"};
        String[] banned_id2 = {"*rodo", "*rodo", "******"};
        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id3, banned_id3));
    }

    static String[][] answerString;
    static int INDEX;

    public static int solution(String[] user_id, String[] banned_id) {
        int userNum = user_id.length;
        int banNum = banned_id.length;
        int answer = 0;
        for (int i = 0; i < Math.pow(2, userNum); i++) {
            int num = i;
            int[] array = new int[userNum];
            int index = 0;
            while (num > 1) {
                array[index++] = num % 2;
                num /= 2;
            }
            array[index] = num;
            int oneNum = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    oneNum++;
                }
            }

            if (oneNum == banNum) {
                String[] strings = new String[banNum];
                int index2 = 0;
                for (int j = 0; j < user_id.length; j++) {
                    if (array[j] == 1) {
                        strings[index2++] = user_id[j];
                    }
                }

                int size = 1;
                int n = banNum;
                while (n != 1) {
                    size *= n--;
                }
                answerString = new String[size][banNum];
                INDEX = 0;
                perm(strings, 0, banNum, banNum);
                for (int j = 0; j < size; j++) {
                    boolean[] visit = new boolean[banNum];
                    int matchedNum = 0;
                    for (int k = 0; k < banNum; k++) {
                        String string = banned_id[k];
                        for (int l = 0; l < strings.length; l++) {
                            if (isMatch(answerString[j][l], string) && !visit[l]) {
                                visit[l] = true;
                                matchedNum++;
                                break;
                            }
                        }
                    }
                    if (matchedNum == banNum) {
                        answer++;
                        break;
                    }
                }

            }
        }
        return answer;
    }

    private static boolean isMatch(String user_id, String ban_id) {
        if (ban_id.length() == user_id.length()) {
            String[] ban = ban_id.split("");
            String[] userid = user_id.split("");
            for (int i = 0; i < ban.length; i++) {
                if (!ban[i].equals("*")) {
                    if (!ban[i].equals(userid[i])) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /////
    public static void perm(String[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.

            for (int i = 0; i < arr.length; i++) {
                answerString[INDEX][i] = arr[i];
            }
            INDEX++;
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    } // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
