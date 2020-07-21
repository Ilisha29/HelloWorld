package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Body> bodies = new ArrayList<>();
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int KG = Integer.parseInt(stringTokenizer.nextToken());
            int CM = Integer.parseInt(stringTokenizer.nextToken());
            bodies.add(new Body(KG, CM));
        }
        int Num;
        for (int i = 0; i < bodies.size(); i++) {
            Num = 0;
            for (int j = 0; j < bodies.size(); j++) {
                if (bodies.get(i).kg < bodies.get(j).kg && bodies.get(i).cm < bodies.get(j).cm)
                    Num++;
            }
            System.out.print((Num + 1) + " ");
        }
        bufferedReader.close();
    }
}

class Body {
    public int kg;
    public int cm;
    public int rank;

    Body(int KG, int CM) {
        this.kg = KG;
        this.cm = CM;
    }
}