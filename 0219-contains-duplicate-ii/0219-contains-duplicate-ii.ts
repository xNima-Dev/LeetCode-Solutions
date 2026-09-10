function containsNearbyDuplicate(nums: number[], k: number): boolean {
    const window = new Set<number>();

    for (let i = 0; i < nums.length; i++) {
        // Window එකේ ප්‍රමාණය k වලට වඩා වැඩි වුවහොත් පැරණිම අගය ඉවත් කරන්න
        if (i > k) {
            window.delete(nums[i - k - 1]);
        }

        // වත්මන් අගය දැනටමත් Window එක තුළ තිබේ නම්
        if (window.has(nums[i])) {
            return true;
        }

        window.add(nums[i]);
    }

    return false;
}