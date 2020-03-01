import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roomSize = Integer.parseInt(bufferedReader.readLine());
        long[] rooms = new long[roomSize];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < roomSize; i++) {
            rooms[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        long major = Long.parseLong(stringTokenizer1.nextToken());
        long sub = Long.parseLong(stringTokenizer1.nextToken());
        long answer = roomSize;
        for (int i = 0; i < roomSize; i++) {
            rooms[i] -= major;
            if (rooms[i] < 0) {
                rooms[i] = 0;
            }
        }
        for (int i = 0; i < roomSize; i++) {
            answer+= rooms[i] / sub;
            if(rooms[i] % sub != 0){
                answer++;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}
