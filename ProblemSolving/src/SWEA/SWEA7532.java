package SWEA;

import java.util.Scanner;

public class SWEA7532 { //[Difficulty 3] 세영이의 SEM력 연도
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] array = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0 && array[i][j]==365){
                    array[i][j] = 0;
                }
                if(j==1 && array[i][j]==24){
                    array[i][j] = 0;
                }
                if(j==2 && array[i][j]==29){
                    array[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print("#"+(i+1)+" ");
            int answer = 1;
            while(!(answer%365 == array[i][0] && answer%24 == array[i][1] && answer%29 == array[i][2])){
                answer++;
            }
            System.out.println(answer);
        }
    }
}
