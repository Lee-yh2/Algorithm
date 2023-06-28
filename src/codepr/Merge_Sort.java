package codepr;

import java.util.Random;

public class Merge_Sort {
    private static int[] sorted;

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        long beforeTime = System.currentTimeMillis();
        merge_sort(arr);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = afterTime - beforeTime;
        System.out.println("소요 시간(ms): " + secDiffTime);
        //nlogn 10만개일경우 = 1660000
    }

    public static void merge_sort(int[] a) {

        sorted = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        sorted = null;
    }

    private static void merge_sort(int[] a, int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;

        merge_sort(a, left, mid);
        merge_sort(a, mid + 1, right);

        merge(a, left, mid, right);

    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}