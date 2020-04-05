package 기출.LINE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[][] snapshots = {
                {"BCCOUNT2", "1520"},
                {"aCCOUNT2", "1250"},
                {"ACCOUNT5", "50"},
                {"ACCOUNT2", "150"},
                {"ACCOUNT1", "100"}
        };
        String[][] transactions = {
                {"1", "SAVE", "ACCOUNT2", "100"},
                {"2", "WITHDRAW", "ACCOUNT1", "50"},
                {"1", "SAVE", "ACCOUNT2", "100"},
                {"4", "SAVE", "ACCOUNT3", "500"},
                {"3", "WITHDRAW", "ACCOUNT2", "30"},
                {"6", "SAVE", "ACCOUNT22", "330"}

        };


        ArrayList<String> account = new ArrayList<>();
        ArrayList<String> amount = new ArrayList<>();
        for (int i = 0; i < snapshots.length; i++) {
            account.add(snapshots[i][0]);
            amount.add(snapshots[i][1]);
        }
        boolean[] check = new boolean[100001];
        for (int i = 0; i < transactions.length; i++) {
            int id = Integer.parseInt(transactions[i][0]);
            String type = transactions[i][1];
            String tmpAccount = transactions[i][2];
            int tmpAmount = Integer.parseInt(transactions[i][3]);
            if (!check[id]) {
                check[id] = true;
                if (!account.contains(tmpAccount)) {
                    account.add(tmpAccount);
                    amount.add("0");
                }
                for (int j = 0; j < account.size(); j++) {
                    if (account.get(j).equals(tmpAccount)) {
                        int originAmount = Integer.parseInt(amount.get(j));
                        if (type.equals("SAVE")) {
                            originAmount += tmpAmount;
                            amount.remove(j);
                            amount.add(j, Integer.toString(originAmount));
                        }
                        if (type.equals("WITHDRAW")) {
                            originAmount -= tmpAmount;
                            amount.remove(j);
                            amount.add(j, Integer.toString(originAmount));
                        }
                    }
                }
            }
        }
        String[][] answer = new String[account.size()][2];

        String[] answerAccount = new String[account.size()];
        for (int i = 0; i < account.size(); i++) {
            answerAccount[i] = account.get(i);
        }
        Arrays.sort(answerAccount);
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = answerAccount[i];
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < account.size(); j++) {
                if (account.get(j).equals(answer[i][0])) {
                    answer[i][1] = amount.get(j);
                }
            }
        }


        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }

        bufferedReader.close();

    }


}
