package com.deeparishi.javaapp.leetcode.arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSumV3(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumV3(new int[]{0, 0, 0}));
    }

    // Extreme Brute force O(N3)
    public static List<List<Integer>> threeSumV1(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplets);
                        res.add(triplets);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    // Reduced one loop O(N2)
    public static List<List<Integer>> threeSumV2(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> lookup = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);
                if (lookup.contains(target)) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(triplets);
                    res.add(triplets);
                } else
                    lookup.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumV3(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> res = new HashSet<>();

        int i = 0;
        int len = arr.length;

        while (i < len) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }

            int j = i+1;
            int k = len - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum < 0) j++;
                else k--;
            }

            i++;
        }

        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSumV4(int[] arr) {
        return nSum(arr, 3, 0);
    }

    public List<List<Integer>> nSum(int[] arr, int k, int target) {

        return new java.util.AbstractList<List<Integer>>() {

            final List<List<Integer>> result = new ArrayList<>();
            final List<Integer> current = new ArrayList<>();
            long minValue;

            public List<Integer> get(int index) {
                initialize();
                return result.get(index);
            }

            public int size() {
                initialize();
                return result.size();
            }

            public void initialize() {
                if (result.isEmpty()) {
                    int n = arr.length;
                    long[] arr = new long[n];
                    Arrays.sort(arr);
                    minValue = arr[0];
                    for (int i = 0; i < n; i++) arr[i] = arr[i] - minValue;
                    long adjustedTarget = (long) target - (long) k * minValue;
                    combine(false, arr, n, k, adjustedTarget);
                }
            }

            public void combine(boolean take, long[] arr, int n, int k, long target) {
                if (n == 0 || k == 0) {
                    if (target == 0 && k == 0) result.add(new ArrayList<>(current));
                    return;
                }
                if (k == 2) {
                    if (!take && n != arr.length && arr[n] == arr[n - 1]) return;
                    twoSum(arr, 0, n - 1, target);
                    return;
                }
                if (n == k) {
                    if (!take && n != arr.length && arr[n] == arr[n - 1]) return;
                    checkSum(arr, n, target);
                    return;
                }
                if (prune(arr, n, k, target)) return;

                combine(false, arr, n - 1, k, target);

                if (!take && n != arr.length && arr[n] == arr[n - 1]) return;

                if (target - arr[n - 1] >= 0) {
                    current.add((int) (arr[n - 1] + minValue));
                    combine(true, arr, n - 1, k - 1, target - arr[n - 1]);
                    current.remove(current.size() - 1);
                }
            }

            void twoSum(long[] arr, int left, int right, long target) {
                if (left >= right || arr[right - 1] + arr[right] < target || arr[left] + arr[left + 1] > target)
                    return;

                while (right > left) {
                    long sum = arr[left] + arr[right];
                    if (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        current.add((int) (arr[left] + minValue));
                        current.add((int) (arr[right] + minValue));
                        result.add(new ArrayList<>(current));
                        current.remove(current.size() - 1);
                        current.remove(current.size() - 1);

                        do { left++; } while (left < right && arr[left - 1] == arr[left]);
                        do { right--; } while (left < right && arr[right + 1] == arr[right]);
                    }
                }
            }

            void checkSum(long[] arr, int n, long target) {
                for (int i = n - 1; i >= 0; i--) {
                    target -= arr[i];
                    current.add((int) (arr[i] + minValue));
                }
                if (target == 0) result.add(new ArrayList<>(current));
                for (int i = n - 1; i >= 0; i--) {
                    target += arr[i];
                    current.remove(current.size() - 1);
                }
            }

            boolean prune(long[] arr, int n, int k, long target) {
                if (n - k < 0) return true;
                long minSum = 0, maxSum = 0;
                for (int i = 0; i < k; i++) {
                    minSum += arr[i];
                    maxSum += arr[n - i - 1];
                }
                return target < minSum || target > maxSum;
            }
        };
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curr = nums[i] + nums[j];
                if (map.containsKey(-1 * curr)) {
                    int k = map.get(-1 * curr);
                    if (!used.contains(STR."\{nums[i]}:\{nums[j]}:\{nums[k]}") && k > i && k > j) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        used.add(STR."\{nums[i]}:\{nums[j]}:\{nums[k]}");
                    }
                }
            }
        }

        return result;
    }
}