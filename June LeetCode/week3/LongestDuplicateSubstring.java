/*
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

Example 1:
Input: "banana"
Output: "ana"
*/

class Solution {
    int a;
    long modulus;
    
    public String longestDupSubstring(String S) {
        
        a = 26;
        modulus = (long)Math.pow(2, 32);
        int l = 1, r = S.length()-1;
        String result = "";
        while(l <= r) {
            int mid = l + (r-l) / 2;
            String temp = search(S, mid);
            if(temp != null) {
                result = temp;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }  
    
     public String search(String S, int L) {
        HashSet<Long> set = new HashSet<>();
        long hash = 0, aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;
        for(int i = 0; i < L; ++i) hash = (hash * a + (S.charAt(i)-'a')) % modulus;
        set.add(hash);
        for(int i = 1; i+L-1 < S.length(); i++) {
            int j = i+L-1;
            hash = (hash * a - (S.charAt(i-1)-'a') * aL % modulus + modulus) % modulus;
            hash = (hash + (S.charAt(j)-'a')) % modulus;
            if(set.contains(hash)) return S.substring(i, j+1);
            set.add(hash);
        }
        return null;
    }
    
}





