package algolithm.programmers.random;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 */
public class 타겟넘버 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] nums, int depth, int sum, int target){
        if(nums.length == depth){
            if(sum == target)
                answer++;
            return;
        }

        dfs(nums, depth+1, sum+nums[depth], target);
        dfs(nums, depth+1, sum-nums[depth], target);
    }
}
