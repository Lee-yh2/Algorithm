package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */
public class 표현가능한이진트리 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        int i = 0;
        for (long num : numbers) {
            String binaryNum = Long.toBinaryString(num);
            int h = 0;

            // 높이 구하기
            while ((int) Math.pow(2, h) - 1 < binaryNum.length())
                h++;
            // 포화이진트리로 만들기(더미 추가)
            while ((int) Math.pow(2, h) - 1 > binaryNum.length())
                binaryNum = "0" + binaryNum;

            answer[i] = checkTree(binaryNum) ? 1 : 0;
            i++;
        }

        return answer;
    }

    private boolean checkTree(String binaryNum) {
        if (binaryNum.length() <= 1)
            return true;

        int mid = (binaryNum.length() - 1) / 2;
        String left = binaryNum.substring(0, mid);
        String right = binaryNum.substring(mid + 1);

        char root = binaryNum.charAt(mid);
        char leftRoot = left.charAt((left.length() - 1) / 2);
        char rightRoot = right.charAt((right.length() - 1) / 2);

        // 더미는 자식을 가질 수 없다
        if (root == '0' && (leftRoot == '1' || rightRoot == '1'))
            return false;
        else
            return checkTree(left) && checkTree(right);
    }
}
