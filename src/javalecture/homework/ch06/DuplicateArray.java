package javalecture.homework.ch06;

public class DuplicateArray {
    public static void main(String[] args) {

        int [] arr = new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};
        System.out.println("중복 elements : ");

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println(arr[i]);
                }
            }
        }

        // 구현해보기 : 이중 for문 사용
        /*
        출력결과)
        중복 elements :
        2
        3
        8
         */
    }
}
