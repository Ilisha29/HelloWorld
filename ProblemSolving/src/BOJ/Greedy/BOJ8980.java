package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int C = Integer.parseInt(strings[1]);
        int rep = Integer.parseInt(bufferedReader.readLine());
        Fedex[] fedexes = new Fedex[rep];
        for (int i = 0; i < rep; i++) {
            String[] info = bufferedReader.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int num = Integer.parseInt(info[2]);
            fedexes[i] = new Fedex(from, to, num);
        }
        Arrays.sort(fedexes, new Comparator<Fedex>() {
            @Override
            public int compare(Fedex o1, Fedex o2) {
                if (o1.to == o2.to) return o2.num - o1.num;
                return o1.to - o2.to;
            }
        });
        int[] truck = new int[N];
        int count = 0;
        Arrays.fill(truck, C);
        for (Fedex fedex : fedexes) {
            int min = Integer.MAX_VALUE;
            for (int i = fedex.from; i < fedex.to; i++) {
                min = Math.min(min, truck[i]);
            }
            int upload = fedex.num;
            upload = Math.min(upload, min);

            count += upload;

            for (int i = fedex.from; i < fedex.to; i++) {
                truck[i] -= upload;
            }
        }
        System.out.println(count);
        bufferedReader.close();
    }
}

class Fedex {
    int from;
    int to;
    int num;

    Fedex(int from, int to, int num) {
        this.from = from;
        this.to = to;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Fedex{" +
                "from=" + from +
                ", to=" + to +
                ", num=" + num +
                '}';
    }
}