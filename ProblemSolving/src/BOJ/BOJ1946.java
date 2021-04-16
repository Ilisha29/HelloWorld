package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        while (rep > 0) {
            int num = Integer.parseInt(bufferedReader.readLine());
            int answer = 0;
            int cut = 0;
            ArrayList<Score> scoreArrayList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                scoreArrayList.add(new Score(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }
            Collections.sort(scoreArrayList);
            for (int i = 0; i < scoreArrayList.size(); i++) {
                if (i == 0) {
                    answer++;
                    cut = scoreArrayList.get(i).y;
                } else {
                    if (scoreArrayList.get(i).y < cut) {
                        cut = scoreArrayList.get(i).y;
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            rep--;
        }
        bufferedReader.close();
    }
}

class Score implements Comparable<Score> {
    int x;
    int y;

    public Score(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Score o) {
        if (this.x > o.x) {
            return 1;
        } else if (this.x < o.x) {
            return -1;
        } else
            return 0;
    }
}