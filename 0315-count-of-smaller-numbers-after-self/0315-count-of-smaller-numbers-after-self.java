import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(indices, 0, n - 1, nums, counts);

        List<Integer> result = new ArrayList<>(n);
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }

    private void mergeSort(int[] indices, int left, int right, int[] nums, int[] counts) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(indices, left, mid, nums, counts);
        mergeSort(indices, mid + 1, right, nums, counts);
        merge(indices, left, mid, right, nums, counts);
    }

    private void merge(int[] indices, int left, int mid, int right, int[] nums, int[] counts) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int rightCount = 0;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                counts[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            } else {
                rightCount++;
                temp[k++] = indices[j++];
            }
        }

        while (i <= mid) {
            counts[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}