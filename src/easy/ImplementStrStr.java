package easy;

/**
 * @Description 28. Implement strStr()
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * @Author lzj
 * @Date 2019/5/24 19:34
 */
public class ImplementStrStr {
    class Solution {
        /**
         * ?????
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
//            return haystack.indexOf(needle);
            if (needle.equals(""))
                return 0;
            if (haystack.length() < needle.length())
                return -1;
            char[] hay = haystack.toCharArray();
            char[] need = needle.toCharArray();
            int res = -1;
            for (int i = 0; i < hay.length - need.length + 1; i++){
                if (hay[i] == need[0]){
                    boolean ok = true;
                    res = i;
                    for (int j = 1;j < need.length && ok;j++)
                        if (hay[++res] != need[j])
                            ok = false;
                    if (ok){
                        res = i;
                        break;
                    }else
                        res = -1;
                }
            }
            return res;
        }
    }
}
