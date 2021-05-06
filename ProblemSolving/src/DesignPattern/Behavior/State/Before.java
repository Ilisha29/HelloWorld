package DesignPattern.Behavior.State;

public class Before {
    public static void main(String[] args) {
        Seob seob = new Seob();
        seob.state = "NORMAL";
        seob.study();
        seob.state = "BUSY";
        seob.study();
        seob.state = "FREE";
        seob.study();
    }
}

class Seob {
    public String state;

    public void study() {
        switch (state) {
            case "NORMAL":
                System.out.println("평소대로 공부한다.");
                break;
            case "BUSY":
                System.out.println("열심히 공부한다.");
                break;
            case "FREE":
                System.out.println("여유있게 공부한다.");
                break;
            /*
            case "GIVEUP":
                System.out.println("떄려친다..");
             */
        }
    }
}
