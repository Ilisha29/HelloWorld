package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        Pond[] ponds = new Pond[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ponds[i] = new Pond(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        Arrays.sort(ponds, new Comparator<Pond>() {
            @Override
            public int compare(Pond o1, Pond o2) {
                return o1.x - o2.x;
            }
        });
        int beforeIndex = 0;
        int answer = 0;
        for (int i = 0; i < ponds.length; i++) {
            if (ponds[i].y - 1 <= beforeIndex) {
                continue;
            }
            int start = ponds[i].x;
            int end = ponds[i].y;
            if (start <= beforeIndex) {
                start = beforeIndex + 1;
            }
            int gap = end - start;
            int count = gap / L;
            if (gap % L != 0) {
                count++;
            }
            answer += count;
            beforeIndex = start + L * count - 1;
        }
        System.out.println(answer);
    }
}

class Pond {
    int x;
    int y;

    public Pond(int x, int y) {
        this.x = x;
        this.y = y;
    }
}