package KAKAO.KAKAO2018공채;

public class KAKAO2018공채_비밀지도 {
    public static void main(String[] args) {
        int n = 5;
        int n1 = 6;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28}; //["#####","# # #", "### #", "# ##", "#####"]
        int[] arr3 = {46, 33, 33, 22, 31, 50};
        int[] arr4 = {27, 56, 19, 14, 14, 10}; //["######", "### #", "## ##", " #### ", " #####", "### # "]
        String[] answer = solution(n, arr1, arr2);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer + " ");
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] arrMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            int num = arr1[i];
            int index = n - 1;
            while (num > 1) {
                arrMap[i][index--] = num % 2;
                num /= 2;
            }
            arrMap[i][index] = num;

            num = arr2[i];
            index = n - 1;
            while (num > 1) {
                arrMap[i][index--] += num % 2;
                num /= 2;
            }
            arrMap[i][index] += num;
        }


        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (arrMap[i][j] == 0) {
                    answer[i] += " ";
                } else {
                    answer[i] += "#";
                }
            }
        }
        return answer;
    }
}
// 25분걸림