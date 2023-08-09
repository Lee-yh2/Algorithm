package algolithm.programmers.random;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String changeK = "";

        // k진수로 변환
        while (n != 0){
            changeK = n%k + changeK;
            n /= k;
        }

        String[] nums = changeK.split("0");
        for (String num : nums){
            if(num.equals("")) continue;

            if (isPrime(Long.parseLong(num)))
                answer++;
        }

        return answer;
    }

    public boolean isPrime(long n){
        if(n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0)
                return false;
        }

        return true;
    }

}
