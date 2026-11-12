class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            double maxLeftX = (partitionX == 0) ? Double.NEGATIVE_INFINITY : nums1[partitionX - 1];
            double minRightX = (partitionX == m) ? Double.POSITIVE_INFINITY : nums1[partitionX];

            double maxLeftY = (partitionY == 0) ? Double.NEGATIVE_INFINITY : nums2[partitionY - 1];
            double minRightY = (partitionY == n) ? Double.POSITIVE_INFINITY : nums2[partitionY];

            // Check if we have found the correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total elements is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // If total elements is odd
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far right on nums1, move left
                high = partitionX - 1;
            } else {
                // We are too far left on nums1, move right
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}