import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap (PriorityQueue) initialize කිරීම
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // Size එක k ට වඩා වැඩි වූ විට කුඩාම අගය Pop කරයි
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Heap එකේ ඉතිරිව ඇති Top element එක kth largest වේ
        return minHeap.peek();
    }
}