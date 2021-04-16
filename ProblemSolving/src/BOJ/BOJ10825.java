package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Person> arrayList = new ArrayList<Person>();
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            arrayList.add(new Person(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), Integer.parseInt(strings[3])));
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).name);
        }
        bufferedReader.close();
    }
}

class Person implements Comparable<Person> {
    String name;
    int korean;
    int english;
    int math;

    Person(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Person o) {
        if (this.korean > o.korean) {
            return -1;
        } else if (this.korean < o.korean) {
            return 1;
        } else {
            if (this.english > o.english) {
                return 1;
            } else if (this.english < o.english) {
                return -1;
            } else {
                if (this.math > o.math) {
                    return -1;
                } else if (this.math < o.math) {
                    return 1;
                } else {
                    return (this.name.compareTo(o.name));
                }
            }
        }
    }
}