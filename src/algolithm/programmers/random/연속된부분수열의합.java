package algolithm.programmers.random;

public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int minLength = 1000001;

        int s = 0;
        int e = 0;
        int sum = sequence[0];
        while(s<=e){
            if(sum > k){
                sum -= sequence[s];
                s++;
            }
            else if(sum < k){
                e++;
                if(e >= sequence.length)
                    break;
                sum += sequence[e];
            }
            else{
                if(e-s+1 < minLength){
                    answer[0] = s;
                    answer[1] = e;
                    minLength = e-s+1;
                }
                e++;
                if(e >= sequence.length)
                    break;
                sum += sequence[e];
            }
        }
        return answer;
    }
}
