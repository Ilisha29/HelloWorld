package Programmers.tmp;

import java.util.*;

public class t4 {
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
        //List<Person> personList = new ArrayList<>();
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
        for (int i = 0; i < t.length; i++) {
            priorityQueue.add(new Person(i, r[i], t[i]));
        }

        List<Person> answerList = new ArrayList<>();
        int index = 0;
        int time = 0;
        while (!priorityQueue.isEmpty()) {
            Person person = priorityQueue.poll();
            System.out.println(person.toString() +" "+ index);
            index++;
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
