package BOJ;

import java.util.ArrayList;

public class ex {
    public static void main(String[] args) {
        String S = "tegsornamwaresomran";
        String pattern = "ransom";
        //
        int answer = 0;
        String[] strings = S.split("");
        String[] patterns = pattern.split("");
        for (int i = 0; i < S.length() - pattern.length() + 1; i++) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j = 0; j < pattern.length(); j++) {
                arrayList.add(strings[i + j]);
            }
            for (int j = 0; j < patterns.length; j++) {
                for (int k = 0; k < arrayList.size(); k++) {
                    if(arrayList.get(k).equals(patterns[j])){
                        arrayList.remove(k);
                        break;
                    }
                }
            }
            if(arrayList.size() == 0){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
