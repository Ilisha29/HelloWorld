package com.company;

import java.util.*;

public class N2019_01 {
    public static void main(String[] args) {
        String[] record = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};
        Deque<String> tmp_queue = new LinkedList<>();
        Deque<String> infinite_queue = new LinkedList<>();
        System.out.println("record 크기 : "+ record.length);
        for (int i = 0; i < record.length; i++) {
            String str = record[i];
            if (str.charAt(0) == ('R')) {
                String[] strings = str.split(" ");
                tmp_queue.push(strings[1]);
                System.out.println("Record 실행 입력데이터 : "+strings[1]+"  tmp큐 크기 : "+tmp_queue.size());
            } else if (str.charAt(0) == ('D')) {
                String string = tmp_queue.pollFirst();
                System.out.println("Delete 실행 tmp큐 크기 :  " +tmp_queue.size()+"삭제된거 : "+string);
            } else if (str.charAt(0) == ('S')) {
                for (int j = 0; j < tmp_queue.size(); j++) {
                    System.out.println(((LinkedList<String>) tmp_queue).get(j));
                }
                System.out.println("Save시 tmp 사이즈"+tmp_queue.size());
                for (int j = 0; j < tmp_queue.size(); j++) {
                    System.out.println("Save실행횟수");
                    infinite_queue.push(tmp_queue.pollFirst());
                    System.out.println("Save실행 imfinite큐 크기 : "+infinite_queue.size());
                }
            }
        }
        //return
        System.out.println("영구큐 크기" + infinite_queue.size());
        for (int i = 0; i < infinite_queue.size(); i++) {
            System.out.println(infinite_queue.poll());
        }
    }

    static String receiveMail(String string) {
        return string; //임시
    }

    static void deleteMail(Queue queue) {

    }

    static void saveMail(Queue tmpMailList, ArrayList<String> arrayList) {

    }

}
