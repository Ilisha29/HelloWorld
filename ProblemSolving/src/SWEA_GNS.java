import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_GNS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < tCase; i++) {
            String string = br.readLine();
            String[] strings = string.split(" ");
            String string1 = br.readLine();
            String[] strings1 = string1.split(" ");
            int[] strings2 = new int[Integer.parseInt(strings[1])];
            for (int j = 0; j < strings1.length; j++) {
                if (strings1[j].equals("ZRO")) {
                    strings2[j] = 0;
                }
                if (strings1[j].equals("ONE")) {
                    strings2[j] = 1;
                }
                if (strings1[j].equals("TWO")) {
                    strings2[j] = 2;
                }
                if (strings1[j].equals("THR")) {
                    strings2[j] = 3;
                }
                if (strings1[j].equals("FOR")) {
                    strings2[j] = 4;
                }
                if (strings1[j].equals("FIV")) {
                    strings2[j] = 5;
                }
                if (strings1[j].equals("SIX")) {
                    strings2[j] = 6;
                }
                if (strings1[j].equals("SVN")) {
                    strings2[j] = 7;
                }
                if (strings1[j].equals("EGT")) {
                    strings2[j] = 8;
                }
                if (strings1[j].equals("NIN")) {
                    strings2[j] = 9;
                }

            }
            Arrays.sort(strings2);
            String[] strings3 = new String[strings2.length];
            for (int j = 0; j < strings3.length; j++) {
                if (strings2[j] == 0) {
                    strings3[j] = "ZRO";
                }
                if (strings2[j] == 1) {
                    strings3[j] = "ONE";
                }
                if (strings2[j] == 2) {
                    strings3[j] = "TWO";
                }
                if (strings2[j] == 3) {
                    strings3[j] = "THR";
                }
                if (strings2[j] == 4) {
                    strings3[j] = "FOR";
                }
                if (strings2[j] == 5) {
                    strings3[j] = "FIV";
                }
                if (strings2[j] == 6) {
                    strings3[j] = "SIX";
                }
                if (strings2[j] == 7) {
                    strings3[j] = "SVN";
                }
                if (strings2[j] == 8) {
                    strings3[j] = "EGT";
                }
                if (strings2[j] == 9) {
                    strings3[j] = "NIN";
                }
            }
            //"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
            System.out.println(strings[0]);
            for (int j = 0; j < strings3.length ; j++) {
                System.out.print(strings3[j]+" ");
            }
            System.out.println();
        }
        //string 비교시 equals가 핵심;;;;
    }
}
