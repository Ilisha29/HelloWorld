package DesignPattern.Behavior.Observer;

public interface Observer {
    void update(String message);
}

abstract class Student {
    private String name;

    Student(String name) {
        this.name = name + "번째 학생";
    }

    void action() {
        System.out.print(this.name + "은 재빨리 ");
    }
}

class GameStudent extends Student implements Observer {

    public GameStudent(String name) {
        super(name);
    }

    @Override
    public void update(String message) {
        super.action();
        if (message.equals("선생님")) {
            System.out.println("게임기를 책상에 숨긴다.");
        } else if (message.equals("반장")) {
            System.out.println("게임기를 다시 꺼내 몰래 게임한다.");
        }
    }
}

class MusicStudent extends Student implements Observer {

    public MusicStudent(String name) {
        super(name);
    }

    @Override
    public void update(String message) {
        super.action();
        if (message.equals("선생님")) {
            System.out.println("이어폰을 빨리 뺀다.");
        } else if (message.equals("반장")) {
            System.out.println("다시 이어폰을 끼고 노래를 듣는다.");
        }
    }
}

