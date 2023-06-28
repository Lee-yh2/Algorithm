package algolithm.programmers.lv2.주식가격;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3};
        new Solution().solution(arr);
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int priceLength = prices.length-1;

        int min = prices[priceLength];
        int minIndex = priceLength;
        answer[priceLength] = 0;
        for (int i = priceLength - 1; i >= 0; i--) {
            if(prices[i] > min){
                answer[i] = minIndex - i;
            }else{
                answer[i] = priceLength - i;
                min = prices[i];
                minIndex = i;
            }
        }

        return answer;
    }
}
