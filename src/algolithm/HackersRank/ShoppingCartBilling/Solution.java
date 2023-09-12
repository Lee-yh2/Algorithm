package algolithm.HackersRank.ShoppingCartBilling;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Result{
    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts){
        int sum = 0;

        HashMap<String, int[]> discountMap = new HashMap<>();
        for(List<String> dis : discounts){
            int type = Integer.parseInt(dis.get(1));
            int persent = Integer.parseInt(dis.get(2));
            discountMap.put(dis.get(0), new int[]{type, persent});
        }

        for (List<String> product : products){
            int minPrice = Integer.MAX_VALUE;

            int price = Integer.parseInt(product.get(0));
            for (int i = 1; i < product.size(); i++) {
                int[] typeAndPersent = discountMap.get(product.get(i));
                if(product.get(i).equals("EMPTY")){
                    minPrice = Math.min(minPrice, Integer.parseInt(product.get(0)));
                }else
                    minPrice = Math.min(minPrice, calculationDiscount(typeAndPersent, price));
            }

            sum += minPrice;
        }

        return sum;
    }

    public static int calculationDiscount(int[] typeAndPersent, int price){
        int discountPrice = 0;

        int type = typeAndPersent[0];
        int persent = typeAndPersent[1];
        if(type == 0){
            discountPrice = persent;
        }else if(type == 1){
            discountPrice = (int)Math.round((double)price - (price * ((double)persent/100)));
        }else if(type == 2){
            discountPrice = price - persent;
            if(discountPrice < 0)
                discountPrice = 0;
        }

        return discountPrice;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<List<String>> products = new ArrayList<>();
        List<List<String>> discounts = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> product = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                product.add(st.nextToken());
            }
            products.add(product);
        }

        int d = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            List<String> discount = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                discount.add(st.nextToken());
            }
            discounts.add(discount);
        }

        System.out.println(Result.findLowestPrice(products, discounts));
    }
}
