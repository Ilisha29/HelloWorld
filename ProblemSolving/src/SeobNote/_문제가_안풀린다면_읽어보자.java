package SeobNote;

public class _문제가_안풀린다면_읽어보자 {
    /*
    1. 로직이 정말 제대로 맞는거 같은데 왜 틀린지 몰를때는 입력값의 크기를 보고 변수형을 확인하자 int만 쓰지말것!
    2. 배열을 복사할때 주의 하자 복사한 배열인덱스가 맞는지 확인
        ex)
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 3; l++) {
                tmpMap[k][l] = map[i][j];  <------- map[k][l] 이어야 한다.!!
            }
        }
    3. 문제를 제대로 읽자. 테케가 몇개가 틀린다면 문제의 조건을 다시 확인!!
    4. 테케를 다 통과하는데 제출하면 자꾸 틀린다면 많은 경우의 수중 조건을 잘못 설정한게 있는거다.
    5. DFS로만 하지 말자 만약 시간초과가 난다면 BFS로 해결해야 하는 문제이다.
    6. 그냥 메소드 건 반복문이건 복사하지말자 인덱스랑 변수명을 자꾸틀린다.
    7. Stack이나 Queue를 사용한 반복문은 poll()할때마다 사이즈가 초기화됨.
    */
    public static void main(String[] args) {

    }
}
