class NumArray {
    private int[] nums;
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.tree = new int[n + 1];

        for (int i = 0; i < n; i++) {
            this.nums[i] = nums[i];
            initAdd(i + 1, nums[i]);
        }
    }

    private void initAdd(int index, int val) {
        while (index <= n) {
            tree[index] += val;
            index += index & -index; // Move to next responsible node
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        initAdd(index + 1, delta);
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index; // Move to parent node
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
