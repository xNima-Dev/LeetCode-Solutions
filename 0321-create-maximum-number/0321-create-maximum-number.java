class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] bestResult = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int i = start; i <= end; i++) {
            int[] sub1 = getMaxSubsequence(nums1, i);
            int[] sub2 = getMaxSubsequence(nums2, k - i);
            int[] merged = merge(sub1, sub2);

            if (compare(merged, 0, bestResult, 0) > 0) {
                bestResult = merged;
            }
        }

        return bestResult;
    }

    private int[] getMaxSubsequence(int[] nums, int length) {
        int[] stack = new int[length];
        int top = -1;
        int drop = nums.length - length;

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top + 1 < length) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }

        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, r = 0;

        while (i < nums1.length || j < nums2.length) {
            if (compare(nums1, i, nums2, j) > 0) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }

        return result;
    }

    private int compare(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] != nums2[j]) {
                return nums1[i] - nums2[j];
            }
            i++;
            j++;
        }
        return (nums1.length - i) - (nums2.length - j);
    }
}