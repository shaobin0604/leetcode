package aimoffer

import java.util.*
import kotlin.collections.HashMap

class _48_LongestNonDuplicateSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = s.toCharArray()
        var max = 0
        var left = 0
        var right = 0
        val substringChars: MutableMap<Char, Int> = HashMap()
        while (right < chars.size) {
            val c = chars[right]
            val position = substringChars[c]
            if (position != null) {
                left = left.coerceAtLeast(position + 1)
            }
            max = max.coerceAtLeast(right - left + 1)
            substringChars[c] = right
            right++
        }
        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = _48_LongestNonDuplicateSubString()
            //        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
            println(solution.lengthOfLongestSubstring("tmmzuxt"))
        }
    }
}