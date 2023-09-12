package algolithm.HackersRank.EfficientShipping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Result{
    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize){
        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < boxes.size(); i++) {
            long unit = unitsPerBox.get(i);
            long boxNum = boxes.get(i);
            map.put(unit, map.getOrDefault(unit, 0L) + boxNum);
        }

        List<Long> boxUnits = new ArrayList<>(map.keySet());
        Collections.sort(boxUnits, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < boxUnits.size(); i++) {
            long bU = boxUnits.get(i);

            long boxNum = map.get(bU);
            if(truckSize > boxNum){
                sum += boxNum * bU;
                truckSize -= boxNum;
            }else{
                sum += truckSize * bU;
                break;
            }
        }

        return sum;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Long> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(Long.parseLong(br.readLine()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Long> unitsPerBox = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            unitsPerBox.add(Long.parseLong(br.readLine()));
        }

        long truckSize = Long.parseLong(br.readLine());

        System.out.println(Result.getMaxUnits(boxes, unitsPerBox, truckSize));
    }
}
