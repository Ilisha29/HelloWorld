package TEST.K;

import java.util.*;

public class PS07 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150"/*, "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"*/};
        String[] query = {/*"- and - and - and - 100","java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",*/
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

    public static int[] solution(String[] infos, String[] queries) {
        List<Integer> answer = new LinkedList<>();
        Tree tree = new Tree();
        for (int i = 0; i < infos.length; i++) {
            String[] splited = infos[i].split(" ");
            Person person = new Person(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4]));
            tree.insert(person);
        }

        for (int i = 0; i < queries.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(queries[i]);

            String code = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String field = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String career = stringTokenizer.nextToken();
            stringTokenizer.nextToken();
            String food = stringTokenizer.nextToken();
            int score = Integer.parseInt(stringTokenizer.nextToken());

            List<Language> languages = new LinkedList<>();
            if (code.equals("-")) {
                for (Map.Entry<String, Language> entry : tree.languageList.entrySet())
                    languages.add(entry.getValue());
            } else {
                if (tree.languageList.containsKey(code)) {
                    languages.add(tree.languageList.get(code));
                }
            }

            List<Field> fields = new LinkedList<>();
            for (Language l : languages) {
                if (field.equals("-")) {
                    for (Map.Entry<String, Field> entry : l.fieldList.entrySet())
                        fields.add(entry.getValue());
                } else {
                    if (l.fieldList.containsKey(field)) {
                        fields.add(l.fieldList.get(field));
                    }
                }
            }

            List<Career> Careers = new LinkedList<>();
            for (Field f : fields) {
                if (career.equals("-")) {
                    for (Map.Entry<String, Career> entry : f.careerList.entrySet())
                        Careers.add(entry.getValue());
                } else {
                    if (f.careerList.containsKey(career)) {
                        Careers.add(f.careerList.get(career));
                    }
                }
            }

            List<Food> Foods = new LinkedList<>();
            for (Career c : Careers) {
                if (food.equals("-")) {
                    for (Map.Entry<String, Food> entry : c.foodList.entrySet())
                        Foods.add(entry.getValue());
                } else {
                    if (c.foodList.containsKey(food)) {
                        Foods.add(c.foodList.get(food));
                    }
                }
            }


            Person p = new Person(null, null, null, null, score);
            int count = 0;
            for (Food f : Foods) {
                Collections.sort(f.personList);

                int index = Collections.binarySearch(f.personList, p);

                if(index>=0){
                    count = count + f.personList.size() - index;
                }else{
                    index = index * (-1);
                    if (f.personList.size() >= index) {

                        count = count + f.personList.size() - index + 1;
                    }
                }

            }

            answer.add(count);
        }

        int[] arr = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
}

class Tree {
    HashMap<String, Language> languageList = new HashMap();

    void insert(Person person) {
        if (languageList.containsKey(person.code)) {
            Language code = languageList.get(person.code);
            code.insert(person);
            languageList.put(person.code, code);
        } else {
            Language language = new Language();
            language.insert(person);
            languageList.put(person.code, language);
        }
    }

}

class Language {
    HashMap<String, Field> fieldList = new HashMap<>();

    void insert(Person person) {
        if (fieldList.containsKey(person.field)) {

            Field field = fieldList.get(person.field);
            field.insert(person);
            fieldList.put(person.field, field);
        } else {
            Field field = new Field();
            field.insert(person);
            fieldList.put(person.field, field);
        }
    }

}

class Field {
    HashMap<String, Career> careerList = new HashMap<>();

    void insert(Person person) {
        if (careerList.containsKey(person.career)) {
            Career career = careerList.get(person.career);
            career.insert(person);
            careerList.put(person.career, career);
        } else {
            Career career = new Career();
            career.insert(person);
            careerList.put(person.career, career);
        }
    }
}

class Career {
    HashMap<String, Food> foodList;

    Career() {
        foodList = new HashMap<>();
    }

    void insert(Person person) {
        if (foodList.containsKey(person.food)) {
            Food food = foodList.get(person.food);
            food.insert(person);
            foodList.put(person.food, food);
        } else {
            Food food = new Food();
            food.insert(person);
            foodList.put(person.food, food);
        }
    }

}

class Food {
    List<Person> personList = new LinkedList<>();

    void insert(Person person) {
        personList.add(person);
    }

}

class Person implements Comparable<Person> {
    String code;
    String field;
    String career;
    String food;
    int scores;

    Person(String code, String field, String career, String food, int scores) {
        this.code = code;
        this.field = field;
        this.career = career;
        this.food = food;
        this.scores = scores;
    }

    @Override
    public int compareTo(Person person) {
        return this.scores - person.scores;
    }
}