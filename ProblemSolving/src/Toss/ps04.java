package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ps04 {
    //"우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축"
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            hashMap.put(strings[i], i);
            ArrayList<Card> arrayList = new ArrayList<>();
            for (String key : hashMap.keySet()) {
                arrayList.add(new Card(key, hashMap.get(key)));
            }
            Collections.sort(arrayList);
            int length = arrayList.size();
            if (length > 5) {
                length = 5;
            }
            for (int j = 0; j < length; j++) {
                if (j == length - 1) {
                    System.out.print(arrayList.get(j).name);
                } else {
                    System.out.print(arrayList.get(j).name + " ");
                }
            }
            if (i != strings.length - 1)
                System.out.println();
        }
        bufferedReader.close();
    }
}

class Card implements Comparable<Card> {
    int index;
    String name;

    Card(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(Card card) {
        if (this.index < card.index) {
            return 1;
        } else if (this.index > card.index) {
            return -1;
        } else {
            return 0;
        }
    }
}
