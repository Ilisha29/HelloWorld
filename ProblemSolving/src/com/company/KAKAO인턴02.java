package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class KAKAO인턴02 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String newString = s.substring(2, s.length() - 2);
        String[] strings = newString.split("},");

        for (int i = 1; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }

        ArrayList<ArrayList> maps = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String[] intStrings = strings[i].split(",");
            int[] array = new int[intStrings.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(intStrings[j]);
            }
            ArrayList<Integer> map = new ArrayList<>();
            for (int j = 0; j < array.length; j++) {
                map.add(array[j]);
            }
            maps.add(map);
        }

        for (int i = 0; i < maps.size(); i++) {
            Collections.sort(maps.get(i));
        }
        int size = 1;
        ArrayList<Integer> answerList = new ArrayList<>();
        while (size <= maps.size()) {
            for (int i = 0; i < maps.size(); i++) {
                if (maps.get(i).size() == size) {
                    for (int j = 0; j < maps.get(i).size(); j++) { //
                        if (!(answerList.contains(maps.get(i).get(j)))) {
                            answerList.add((int) maps.get(i).get(j));
                        }
                    }
                }
            }
            size++;

        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
    }

}
