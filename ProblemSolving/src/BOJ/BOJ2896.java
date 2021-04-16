package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2896 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        float A = Float.parseFloat(stringTokenizer.nextToken());
        float B = Float.parseFloat(stringTokenizer.nextToken());
        float C = Float.parseFloat(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        float a = Float.parseFloat(stringTokenizer.nextToken());
        float b = Float.parseFloat(stringTokenizer.nextToken());
        float c = Float.parseFloat(stringTokenizer.nextToken());
        float aa = A / a;
        float bb = B / b;
        float cc = C / c;
        float min = (aa < bb) ? aa : bb;
        min = (min < cc) ? min : cc;
        float AA = A - a * min;
        float BB = B - b * min;
        float CC = C - c * min;
        System.out.format("%.6f ", AA);
        System.out.format("%.6f ", BB);
        System.out.format("%.6f\n", CC);
        bufferedReader.close();
    }
}
