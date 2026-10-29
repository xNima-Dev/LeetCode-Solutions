import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greed factors and cookie sizes in ascending order
        Arrays.sort(g);
        Arrays.sort(s);

        int childPtr = 0;
        int cookiePtr = 0;

        // Iterate through both arrays using two pointers
        while (childPtr < g.length && cookiePtr < s.length) {
            // If the cookie is big enough for the child's greed factor
            if (s[cookiePtr] >= g[childPtr]) {
                childPtr++; // Move to the next child
            }
            cookiePtr++; // Always move to the next cookie
        }

        // childPtr represents the total number of content children
        return childPtr;
    }
}