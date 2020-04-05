package 기출.LINE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split("");
        ArrayList<String> arrayList = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(") || strings[i].equals("{") || strings[i].equals("[") || strings[i].equals("<")) {
                arrayList.add(strings[i]);
            }
            if (strings[i].equals(")") || strings[i].equals("}") || strings[i].equals("]") || strings[i].equals(">")) {
                if (strings[i].equals(")")) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(")");
                    } else {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j).equals("(")) {
                                arrayList.remove(j);
                                answer++;
                                break;
                            }
                            if (j == arrayList.size() - 1) arrayList.add(")");
                        }
                    }
                } else if (strings[i].equals("}")) {
                    if (arrayList.isEmpty()) {
                        arrayList.add("}");
                    } else {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j).equals("{")) {
                                arrayList.remove(j);
                                answer++;
                                break;
                            }
                            if (j == arrayList.size() - 1) arrayList.add("}");
                        }
                    }
                } else if (strings[i].equals("]")) {
                    if (arrayList.isEmpty()) {
                        arrayList.add("]");
                    } else {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j).equals("[")) {
                                arrayList.remove(j);
                                answer++;
                                break;
                            }
                            if (j == arrayList.size() - 1) arrayList.add("]");
                        }
                    }
                } else if (strings[i].equals(">")) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(">");
                    } else {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j).equals("<")) {
                                arrayList.remove(j);
                                answer++;
                                break;
                            }
                            if (j == arrayList.size() - 1) arrayList.add(">");
                        }
                    }
                }
            }
        }
        if (arrayList.size() != 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
        bufferedReader.close();
    }
}
//  if (Count of eggs is 4.) {Buy milk.}