package Programmers.tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class t1 {
    public static void main(String[] args) {
        String company_code = "012345";
        String date = "20190620";
        String[] data = {
                "price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"
        };
        int[] result = solution(company_code, date, data);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(String code, String day, String[] data) {
        List<Stock> stockList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] splitData = data[i].split(" ");
            String[] splitCodeData = splitData[1].split("=");
            String[] splitTimeDate = splitData[2].split("=");
            if (splitCodeData[1].equals(code) && day.equals(splitTimeDate[1].substring(0, day.length()))) {
                String[] splitPriceDate = splitData[0].split("=");
                stockList.add(new Stock(splitCodeData[1], splitTimeDate[1], Integer.parseInt(splitPriceDate[1])));
            }
        }
        Collections.sort(stockList, new Comparator<Stock>() {
            @Override
            public int compare(Stock o1, Stock o2) {
                return o1.date.compareTo(o2.date);
            }
        });
        int[] answer = new int[stockList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stockList.get(i).price;
        }
        return answer;
    }
}

class Stock {
    String code;
    String date;
    int price;

    public Stock(String code, String date, int price) {
        this.code = code;
        this.date = date;
        this.price = price;
    }
}
