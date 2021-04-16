package LeetCode.Greedy;

public class LC1689_minPartitions {
    public static void main(String[] args) {
        String[] strings = {"32", "82734", "27346209830709182346"};
        for (String string : strings) {
            System.out.println(minPartitions(string));
        }
    }

    public static int minPartitions(String n) {
        int maxNum = 0;
        String[] split = n.split("");
        for (String num : split) {
            maxNum = Math.max(Integer.parseInt(num), maxNum);
            if (maxNum == 9)
                return  9;
        }
        return maxNum;
    }
}
