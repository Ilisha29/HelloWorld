package com.company;

import java.util.Scanner;

public class KAKAO2020BLIND_가사검색 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            //queries 특징 조사
            int matchNum = 0;
            int QmarkNum = 0;
            int NotQmarkNum = 0;
            boolean QmarkPositionIsLeft = false;
            if (queries[i].indexOf("?") == 0) {
                QmarkPositionIsLeft = true;
            }

            char[] query = queries[i].toCharArray();
            for (int j = 0; j < query.length; j++) {
                if (query[j] == '?') {
                    QmarkNum++;
                } else {
                    NotQmarkNum++;
                }
            }

            //words에서 검색
            for (int j = 0; j < words.length; j++) {
                //단계 query보다 작은거 제거
                if (words[j].length() == queries[i].length()) {
                    //query가 ??일때
                    if (NotQmarkNum == 0) {
                        matchNum++;
                    } else {
                        if (QmarkPositionIsLeft) {
                            if (words[j].indexOf(queries[i].substring(QmarkNum, QmarkNum + NotQmarkNum), QmarkNum) > -1) {
                                matchNum++;
                            }
                        } else {
                            if (words[j].indexOf(queries[i].substring(0, NotQmarkNum)) == 0) {
                                matchNum++;
                            }
                        }
                    }

                }
            }
            answer[i] = matchNum;
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
    }
    // 실수 했던점 : 문제를 제대로 안읽었다... 같은 길이의 찾는 단어와 words를 비교했어야 했는데 다른 답까지 나오도록 했고,
    // String관련 indexOf contains matches 등 메소드 활용에 미숙했다.
    // 그래서 시간이 오래 걸렸고,
    // 다른사람들이 한걸 보니까 메소드와 기능 분리를 해서 깔끔했는데 나는 그런게 없이 main에 전부 때려 넣었다....
        /* 정리! 0. 우선 작게 봐서 테스트 케이스 하나만 통과시키자!!!
                 1. 문제 제대로 파악!!!!!!
                 2. Debug or print잘 쓰기
                 3. 다양한 기본메소드에 익숙
                 4. 메소드 분리

                 그래도 주석으로 기능 설명 제대로 남긴건 앞으로도 계속 지켜야할일
        */
        /*
        결과
        정확성: 25.0   (TEST 모두 통과)
        효율성: 30.0   (TEST 3/5 통과)
        합계: 55.0 / 100.0
        */
}
