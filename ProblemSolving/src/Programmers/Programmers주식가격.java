package Programmers;

public class Programmers주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length ; i++) {
            int notLow = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] <= prices[j]){
                    notLow++;
                }
                if(prices[i] > prices[j] || j == prices.length-1){
                    answer[i] = notLow;
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length ; i++) {
            System.out.println(answer[i]);
        }

        //answer 	[4, 3, 1, 1, 0] ;

    }
}
