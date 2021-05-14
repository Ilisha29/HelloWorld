package LeetCode.BinarySearch;

public class LC1351 {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] tmpGrid = grid[i];
            int index = binarySearch(tmpGrid);
            if (index != tmpGrid.length) {
                answer += tmpGrid.length - index;
            }
        }
        return answer;
    }

    private static int binarySearch(int[] tmpGrid) {
        int index = tmpGrid.length;
        int start = 0;
        int end = tmpGrid.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (tmpGrid[mid] < 0) {
                index = Math.min(index, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    /*public static int countNegatives(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] tmpGrid = grid[i];
            for (int j = 0; j < tmpGrid.length; j++) {
                if (tmpGrid[j] < 0) {
                    answer += tmpGrid.length - j;
                    break;
                }
            }
        }
        return answer;
    }*/
}
