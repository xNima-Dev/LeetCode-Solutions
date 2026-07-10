class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        if (hLen < nLen) {
            return -1;
        }
        
        for (int i = 0; i <= hLen - nLen; i++) {
            
            String sub = haystack.substring(i, i + nLen);
            
            if (sub.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}