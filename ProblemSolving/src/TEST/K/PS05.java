/*
package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PS05 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {*/
/*"- and - and - and - 100","java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",*//*

                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int[] result = solution(info, query);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Info> infos = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            String[] strings = info[i].split(" ");
            infos.add(new Info(strings[0], strings[1], strings[2], strings[3], Integer.parseInt(strings[4])));
        }
        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" ");
            String[] condition = new String[5];
            condition[0] = splitQuery[0];
            condition[1] = splitQuery[2];
            condition[2] = splitQuery[4];
            condition[3] = splitQuery[6];
            condition[4] = splitQuery[7];
            ArrayList<Info> arrayList = new ArrayList<>();
            for (int j = 0; j < infos.size(); j++) {
                arrayList.add(infos.get(j));
            }
            if (!condition[0].equals("-")) {
                if (arrayList.size() > 0)
                    arrayList = calculateCondition(arrayList, 0, condition);
            }
            if (!condition[1].equals("-")) {
                if (arrayList.size() > 0)
                    arrayList = calculateCondition(arrayList, 1, condition);
            }
            if (!condition[2].equals("-")) {
                if (arrayList.size() > 0)
                    arrayList = calculateCondition(arrayList, 2, condition);
            }
            if (!condition[3].equals("-")) {
                if (arrayList.size() > 0)
                    arrayList = calculateCondition(arrayList, 3, condition);
            }
            int target = Integer.parseInt(condition[4]);
            int count = 0;
            if (arrayList.size() > 0) {
                Collections.sort(arrayList, Info.Comparators.SCORE);
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).score >= target) {
                        count++;
                    }
                }
                answer[i] = count;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private static ArrayList<Info> calculateCondition(ArrayList<Info> arrayList, int condition, String[] conditions) {
        ArrayList<Info> newArrayList = new ArrayList<>();
        String target = conditions[condition];
        if (condition == 0) { //first
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).lang.equals(target)) {
                    newArrayList.add(arrayList.get(i));
                }
            }
        } else if (condition == 1) { //first
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).type.equals(target)) {
                    newArrayList.add(arrayList.get(i));
                }
            }
        } else if (condition == 2) { //first
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).career.equals(target)) {
                    newArrayList.add(arrayList.get(i));
                }
            }
        } else if (condition == 3) { //first
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).food.equals(target)) {
                    newArrayList.add(arrayList.get(i));
                }
            }
        }
        return newArrayList;
    }
}

class Info implements Comparable<Info> {
    String lang;
    String type;
    String career;
    String food;
    int score;

    Info(String lang, String type, String career, String food, int score) {
        this.lang = lang;
        this.type = type;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}

/*
class Info implements Comparable<Info> {
    String lang;
    String type;
    String career;
    String food;
    int score;

    Info(String lang, String type, String career, String food, int score) {
        this.lang = lang;
        this.type = type;
        this.career = career;
        this.food = food;
        this.score = score;
    }

    @Override
    public int compareTo(Info o) {
        return Comparators.LANG.compare(this, o);
    }

    public static class Comparators {
        public static Comparator<Info> LANG = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.lang.compareTo(o2.lang);
            }
        };
        public static Comparator<Info> TYPE = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.type.compareTo(o2.type);
            }
        };
        public static Comparator<Info> CAREER = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.career.compareTo(o2.career);
            }
        };
        public static Comparator<Info> FOOD = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.food.compareTo(o2.food);
            }
        };
        public static Comparator<Info> SCORE = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.score - o2.score;
            }
        };
    }
}
*/
