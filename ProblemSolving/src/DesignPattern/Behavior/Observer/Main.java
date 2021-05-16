package DesignPattern.Behavior.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //감시하기로한 학생A는 딴짓할 친구들의 명단을 받음
        Subject studentA = new StudentA();
        for (int i = 0; i < 10; i++) {
            String number = Integer.toString(i);
            if (i % 2 == 0) {
                studentA.registerObserver(new GameStudent(number));
            } else {
                studentA.registerObserver(new MusicStudent(number));
            }
        }
        //선생님 출현!
        System.out.println("선생님 출현!!!");
        System.out.println();
        studentA.notifyObserver("선생님");

        System.out.println();
        System.out.println("====================");
        System.out.println();

        //잘못봐서 다시 알림
        System.out.println("잘못 봤다.. 알고보니 반장");
        System.out.println();
        studentA.notifyObserver("반장");
    }
}
