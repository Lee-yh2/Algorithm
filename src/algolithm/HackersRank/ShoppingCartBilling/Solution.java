package algolithm.HackersRank.ShoppingCartBilling;


import java.util.HashMap;
import java.util.List;

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
    public static void main(String[] args) {

    }
}
