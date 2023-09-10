package algolithm.HackersRank.ProductSales;

import algolithm.BOJ.binarysearch.백준2512.예산pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Result{
    public static long maxProfit(List<Integer> inventory, long order){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(inventory);

        long sum = 0;
        for (int i = 0; i < order; i++) {
            int num = pq.poll();
            sum += num;
            if(num > 2)
                pq.add(num-1);
        }

        return sum;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> inventory = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inventory.add(Integer.parseInt(br.readLine()));
        }
        long order = Integer.parseInt(br.readLine());

        System.out.println(Result.maxProfit(inventory, order));
    }
}
