package 기출;

import java.util.Scanner;

public class BoostCampPS01 {
    public static void main(String[] args) {
        int[] param = {1,2,3,3,4,4,3};
        int[] index = new int[100];
        int duplicateNum = 0 ;
        for (int i = 0; i < param.length; i++) {
            index[param[i]-1]++;
        }
        for (int i = 0; i < index.length; i++) {
            if(index[i]>1){
                duplicateNum++;
            }
        }
        if(duplicateNum == 0){
            System.out.println(-1);
        }
        else {
            int[] answer = new int[duplicateNum];
            int indexCount = 0;
            for (int i = 0; i < param.length ; i++) {
                if(index[param[i]-1]>1){
                    answer[indexCount++] = index[param[i]-1];
                    index[param[i]-1] = 0;
                }
            }
            for (int i = 0; i < answer.length; i++) {
                System.out.println(answer[i]);
            }
        }


    }
}
