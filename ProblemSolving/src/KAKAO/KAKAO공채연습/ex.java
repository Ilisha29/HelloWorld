package KAKAO.KAKAO공채연습;

import java.util.ArrayList;
import java.util.Collections;

public class ex {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java frontend senior chicken 200",
                "java frontend senior pizza 100",
                "java frontend junior chicken 10",
                "java frontend senior pizza 3",
                "java frontend senior chicken 7",
                "java backend junior pizza 1",
                "java backend senior chicken 17178",
                "java backend senior pizza 123",
                "python backend senior chicken 50"
        };

        ArrayList<Info> infos = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            String[] strings = info[i].split(" ");
            infos.add(new Info(strings[0], strings[1], strings[2], strings[3], Integer.parseInt(strings[4])));
        }
        Collections.sort(infos);
        for (int i = 0; i < infos.size(); i++) {
            Info info1 = infos.get(i);
            System.out.println(info1.lang + " " + info1.type + " " + info1.career + " " + info1.food + " " + info1.score);
        }
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

    @Override
    public int compareTo(Info o) {
        if (this.lang.equals(o.lang)) {
            if (this.type.equals(o.type)) {
                if (this.career.equals(o.career)) {
                    if (this.food.equals(o.food)) {
                        return this.score - o.score;
                    } else
                        return this.food.compareTo(o.food);
                } else
                    return this.career.compareTo(o.career);
            } else
                return this.type.compareTo(o.type);
        } else {
            return this.lang.compareTo(o.lang);
        }
    }
}