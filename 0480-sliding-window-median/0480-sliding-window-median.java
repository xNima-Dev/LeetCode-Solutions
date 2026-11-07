import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> revCmp = (a, b) -> Integer.compare(b, a);
        // Max-heap for the smaller half
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(revCmp);
        // Min-heap for the larger half
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        // Map to keep track of delayed deletions (Lazy Deletion)
        Map<Integer, Integer> delayed = new HashMap<>();

        int n = nums.length;
        double[] result = new double[n - k + 1];
        int resIdx = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            leftHeap.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            rightHeap.offer(leftHeap.poll());
        }

        for (int i = k; ; i++) {
            // Get median of current window
            result[resIdx++] = getMedian(leftHeap, rightHeap, k);

            if (i >= n) break;

            int outgoing = nums[i - k];
            int incoming = nums[i];

            // Track balance changes
            int balance = 0; // +1 if outgoing is in left, -1 if in right
            if (outgoing <= leftHeap.peek()) {
                balance--;
            } else {
                balance++;
            }

            delayed.put(outgoing, delayed.getOrDefault(outgoing, 0) + 1);

            // Insert incoming element
            if (!leftHeap.isEmpty() && incoming <= leftHeap.peek()) {
                leftHeap.offer(incoming);
                balance++;
            } else {
                rightHeap.offer(incoming);
                balance--;
            }

            // Re-balance heaps
            if (balance < 0) {
                leftHeap.offer(rightHeap.poll());
                balance++;
            } else if (balance > 0) {
                rightHeap.offer(leftHeap.poll());
                balance--;
            }

            // Clean up delayed deletions from heap tops
            prune(leftHeap, delayed);
            prune(rightHeap, delayed);
        }

        return result;
    }

    private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int k) {
        if (k % 2 == 1) {
            return left.peek().doubleValue();
        } else {
            return ((double) left.peek() + (double) right.peek()) / 2.0;
        }
    }

    private void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> delayed) {
        while (!heap.isEmpty()) {
            int top = heap.peek();
            if (delayed.containsKey(top)) {
                delayed.put(top, delayed.get(top) - 1);
                if (delayed.get(top) == 0) {
                    delayed.remove(top);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }
}