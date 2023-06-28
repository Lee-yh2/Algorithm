package algolithm.programmers.lv2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42583
 */
public class Solution {
    class BridgeTruck{
        int weight;
        int truckInTime;

        public BridgeTruck(int weight, int truckInTime) {
            this.weight = weight;
            this.truckInTime = truckInTime;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<BridgeTruck> q = new LinkedList<>();

        int totalWeight = 0;
        int time = 0;
        int index = 0;
        while (index < truck_weights.length){
            time++;

            if(!q.isEmpty()){
                if(time - q.peek().truckInTime == bridge_length){
                    totalWeight -= q.poll().weight;
                }
            }

            if(totalWeight + truck_weights[index] <= weight
                    && q.size() < bridge_length){
                q.add(new BridgeTruck(truck_weights[index], time));
                totalWeight += truck_weights[index];
                index++;
            }

        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 6};
        new Solution().solution(2, 10, arr);
    }
}
