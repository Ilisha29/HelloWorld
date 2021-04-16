package KAKAO.KAKAO2018공채;

import java.util.HashMap;

// 19 : 35 start
public class KAKAO2018공채_캐시 {
    public static void main(String[] args) {
        int[] cacheSize = {3, 3, 2, 5, 2, 0};
        String[][] cities = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, {}, {}, {}, {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
        for (int i = 0; i < 6; i++) {
            System.out.println(solution(cacheSize[i], cities[i]));
        }
    }

    //최대 도시 수는 100,000개이다.
    public static int solution(int cacheSize, String[] cities) {
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        int answer = 0;
        if (cacheSize == 0) {
            answer += 5 * cities.length;
        } else {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < cities.length; i++) {
                if (hashMap.containsKey(cities[i])) {
                    hashMap.put(cities[i], 0);
                    allCacheTimeUp(hashMap);
                    answer++;
                } else {
                    if (hashMap.size() == cacheSize) {
                        int older = 0;
                        String tmpKey = "";
                        for (String key : hashMap.keySet()) {
                            if (hashMap.get(key) > older) {
                                older = hashMap.get(key);
                                tmpKey = key;
                            }
                        }
                        hashMap.remove(tmpKey);
                        hashMap.put(cities[i], 0);
                        allCacheTimeUp(hashMap);
                        answer += 5;
                    } else {
                        hashMap.put(cities[i], 0);
                        allCacheTimeUp(hashMap);
                        answer += 5;
                    }
                }
            }
        }
        return answer;
    }

    private static void allCacheTimeUp(HashMap<String, Integer> hashMap) {
        for (String key : hashMap.keySet()) {
            hashMap.put(key, hashMap.get(key) + 1);
        }
    }
}
// 20 : 10 // 35분걸림