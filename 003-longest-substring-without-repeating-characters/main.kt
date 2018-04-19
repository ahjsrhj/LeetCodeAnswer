fun main(args: Array<String>) {
    val str = readLine() ?: ""
    val length = Solution().lengthOfLongestSubstring(str)
    println(length)
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val byteArray = s.toByteArray()
        return getMax(byteArray, 0)
    }

    fun getMax(arr: ByteArray, start: Int = 0): Int {
        var tmp = Array(255, { -1 })
        var max = 0
        var cur = 0
        var lastIndex = 0
        for (i in start until arr.size) {
            if (tmp[arr[i].toInt()] == -1) {
                tmp[arr[i].toInt()] = i
                cur++
            } else {
                max = Math.max(cur, max)
                cur = i - tmp[arr[i].toInt()]
                for (j in lastIndex until tmp[arr[i].toInt()]) {
                    tmp[arr[j].toInt()] = -1
                }
                lastIndex = tmp[arr[i].toInt()] + 1
                tmp[arr[i].toInt()] = i
            }
        }
        return Math.max(max, cur)
    }
}