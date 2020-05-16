package Programmers.해시_빈출_상;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 14 : 00
public class 전화번호목록 {
    public static void main(String[] args) {
        String[][] strings = {{"119", "97674223", "1195524421"}, {"123", "456", "789"}, {"12", "123", "1235", "567", "88"}};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        ArrayList<PhoneBook> phoneBooks = new ArrayList<>();
        for (String phone : phone_book) {
            phoneBooks.add(new PhoneBook(phone));
        }
        Collections.sort(phoneBooks);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(phoneBooks.get(0).numbers, 0);
        for (int i = 1; i < phoneBooks.size(); i++) {
            PhoneBook pb = phoneBooks.get(i);
            for (String key : hashMap.keySet()) {
                if (key.equals(pb.numbers.substring(0, key.length()))) {
                    answer = false;
                    break;
                }
            }
            hashMap.put(pb.numbers, 0);
        }
        return answer;
    }
}

class PhoneBook implements Comparable<PhoneBook> {
    // static ㅜㅜ
    public String numbers;
    public int length;

    public PhoneBook(String string) {
        numbers = string;
        length = string.length();
    }

    @Override
    public int compareTo(PhoneBook o) {
        if (this.length > o.length) {
            return 1;
        } else if (this.length < o.length) {
            return -1;
        } else {
            return 0;
        }
    }
}