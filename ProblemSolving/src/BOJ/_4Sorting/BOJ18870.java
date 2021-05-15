package BOJ._4Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] originNum = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = originNum.clone();
        Arrays.sort(nums);
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : set) {
            map.put(num, index++);
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(map.get(originNum[i]) + " ");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
