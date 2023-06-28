package javalecture.homework.ch06;

import java.util.Arrays;

public class Chapter6Homwork이윤형 {
    public static void main(String[] args) {
        // 배열 초기화
        int [] arr = new int [] {1, 2, 3, 4, 5};
        int [] arrCopy = new int [arr.length];

        // 왼쪽으로 회전할 횟수
        int n = 73;

        n %= arr.length; // 배열의 길이만큼 회전하면 결국 원점이기 때문에 배열 길이로 나눈 나머지 만큼 돌려주면 된다.
        System.arraycopy(arr,n, arrCopy,0,arr.length - n);
        System.arraycopy(arr,0, arrCopy,arr.length - n,n);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrCopy));
    }
}
