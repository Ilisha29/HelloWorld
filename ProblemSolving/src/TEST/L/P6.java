package TEST.L;

import java.util.*;
import java.util.Map.Entry;

public class P6 {
    public static void main(String[] args) {

        String[] arr = solution(new String[]{"A fabdec 2", "B cebdfa 2", "C ecfadb 2"},
                new String[]{"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        arr = solution(new String[]{"A abc 2", "B abc 1"},
                new String[]{"a AB 1", "b AB 1", "c AB 1"});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String[] solution(String[] companies, String[] applicants) {
        String[] answer;
        HashMap<String, Company> cHashMap = new HashMap<>();
        HashMap<String, Applicant> aHashMap = new HashMap<>();
        StringTokenizer stringTokenizer;
        for (int i = 0; i < companies.length; i++) {
            stringTokenizer = new StringTokenizer(companies[i]);
            cHashMap.put(stringTokenizer.nextToken(), new Company(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
        }
        for (int i = 0; i < applicants.length; i++) {
            stringTokenizer = new StringTokenizer(applicants[i]);
            aHashMap.put(stringTokenizer.nextToken(), new Applicant(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
        }
        HashMap<String, List<String>> table = new HashMap<>();
        for (Entry<String, Applicant> e : aHashMap.entrySet()) {
            Applicant applicant = e.getValue();
            String tmp = Character.toString(applicant.prefer.charAt(applicant.index));
            if (table.containsKey(tmp)) {
                List<String> list = table.get(tmp);
                list.add(e.getKey());
                table.put(tmp, list);
            } else {
                List<String> list = new LinkedList<>();
                list.add(e.getKey());
                table.put(tmp, list);
            }
            applicant.index++;
        }
        while (!isOk(table, cHashMap)) {
            List<String> rejectedApplicant = new LinkedList<>();
            for (Entry<String, List<String>> entry : table.entrySet()) {
                Company com = cHashMap.get(entry.getKey());
                if (entry.getValue().size() != com.count) {
                    List<String> list = entry.getValue();
                    List<String> newList = new LinkedList<>();
                    for (int i = 0; i < com.prefer.length(); i++) {
                        String tmp = Character.toString(com.prefer.charAt(i));
                        if (list.contains(tmp))
                            newList.add(tmp);
                        if (com.count == newList.size())
                            break;
                    }
                    list.removeAll(newList);
                    rejectedApplicant.addAll(list);
                    table.put(entry.getKey(), newList);
                }
            }
            for (String applicantNum : rejectedApplicant) {
                Applicant applicant = aHashMap.get(applicantNum);
                if (applicant.count == applicant.index) {
                    continue;
                } else {
                    String preNum = Character.toString(applicant.prefer.charAt(applicant.index));
                    if (!table.containsKey(preNum)) {
                        table.put(preNum, new LinkedList<>());
                    }
                    List<String> list = table.get(preNum);
                    list.add(applicantNum);
                    table.put(preNum, list);
                    applicant.index++;
                }
            }
        }
        answer = new String[companies.length];
        for (int i = 0; i < companies.length; i++) {
            char tmp = (char) (65 + i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tmp);
            stringBuilder.append('_');
            List<String> list = table.get(Character.toString(tmp));
            if (list != null) {
                String[] strings = new String[list.size()];
                int index = 0;
                for (String str : list) {
                    strings[index++] = str;
                }
                Arrays.sort(strings);
                String applicantStr = "";
                for (int j = 0; j < strings.length; j++) {
                    applicantStr += strings[j];
                }
                stringBuilder.append(applicantStr);
            }
            answer[i] = stringBuilder.toString();
        }
        return answer;
    }

    public static boolean isOk(HashMap<String, List<String>> table, HashMap<String, Company> cHashMap) {
        for (Entry<String, List<String>> e : table.entrySet()) {
            Company company = cHashMap.get(e.getKey());
            if (e.getValue().size() > company.count) {
                return false;
            }
        }
        return true;
    }
}

class Applicant {
    String prefer;
    int count;
    int index = 0;

    public Applicant(String prefer, int count) {
        this.prefer = prefer;
        this.count = count;
    }
}

class Company {
    String prefer;
    int count;

    public Company(String prefer, int count) {
        this.prefer = prefer;
        this.count = count;
    }
}



            /*
            if (list != null) {
                for (String str : list) {
                    stringBuilder.append(str);
                }
            }
            */