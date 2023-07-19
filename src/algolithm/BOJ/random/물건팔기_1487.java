package algolithm.BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 물건팔기_1487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            items[i] = new Item(a, b);
        }

        Arrays.sort(items);

        int result = 0;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                int profit = items[i].price - items[j].delivery;
                if (profit > 0)
                    sum += profit;
            }

            if(maxProfit < sum){
                maxProfit = sum;
                result = items[i].price;
            }
        }
        System.out.println(result);

    }

    public static class Item implements Comparable<Item>{
        int price;
        int delivery;

        public Item(int price, int delivery) {
            this.price = price;
            this.delivery = delivery;
        }

        @Override
        public int compareTo(Item o) {
            if(price==o.price)
                return delivery - o.delivery;
            return price - o.price;
        }
    }
}
