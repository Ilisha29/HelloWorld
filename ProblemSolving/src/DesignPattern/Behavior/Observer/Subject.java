package DesignPattern.Behavior.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> students = new ArrayList<>();

    void registerObserver(Observer observer) {
        students.add(observer);
    }

    void removeObserver(Observer observer) {
        students.add(observer);
    }

    void notifyObserver(String status) {
        for (Observer student : students) {
            student.update(status);
        }
    }
}

class StudentA extends Subject {

    public void search(String person) {
        if (person.equals("선생님") || person.equals("반장")) {
            super.notifyObserver(person);
        }
    }
}