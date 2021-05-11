package Programmers.tmp;

import java.util.*;

public class t2 {
    public static void main(String[] args) {
        int[][] t = {{0, 1, 3, 0}, {7, 6, 8, 1}};
        int[][] r = {{0, 1, 2, 3}, {0, 1, 2, 3}};
        for (int i = 0; i < t.length; i++) {
            int[] result = solution(t[i], r[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[] t, int[] r) {
        int[] answer = new int[t.length];
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            personList.add(new Person(i, r[i], t[i]));
        }
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.time - o2.time;
            }
        });
        Queue<Person> people = new LinkedList<>();
        for (int i = 0; i < personList.size(); i++) {
            people.add(personList.get(i));
        }
        List<Person> answerList = new ArrayList<>();
        PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.rank == o2.rank) {
                    if (o1.time == o2.time) {
                        return o1.index - o2.index;
                    }
                    return o1.time - o2.time;
                }
                return o1.rank - o2.rank;
            }
        });
        int index = 0;
        int time = 0;
        while (!people.isEmpty() || !priorityQueue.isEmpty()) {
            while (!people.isEmpty() && people.peek().time == time) {
                priorityQueue.add(people.poll());
            }
            if (!priorityQueue.isEmpty()) {
                Person person = priorityQueue.poll();
                person.order = index;
                answerList.add(person);
                index++;
            }
            time++;
        }
        Collections.sort(answerList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.order - o2.order;
            }
        });
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i).index;
        }
        return answer;
    }
}

class Person {
    int index;
    int rank;
    int time;
    int order;

    public Person(int index, int rank, int time) {
        this.index = index;
        this.rank = rank;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "index=" + index +
                ", rank=" + rank +
                ", time=" + time +
                ", order=" + order +
                '}';
    }
}
