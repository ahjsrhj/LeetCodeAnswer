fun main(args: Array<String>) {
    val list1 = ListNode(2)
    list1.next = ListNode(4)
    list1.next?.next = ListNode(3)
    val list2 = ListNode(5)
    list2.next = ListNode(6)
    list2.next?.next = ListNode(4)

    val solution = Solution()
    var result = solution.addTwoNumbers(list1, list2)
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var tmp: ListNode? = null
        var tmpL1 = l1
        var tmpL2 = l2
        var carry = 0
        while ((tmpL1 != null).or(tmpL2 != null)) {
            var num: Int
            when {
                (tmpL1 != null).and(tmpL2 != null) -> {
                    num = tmpL1!!.`val` + tmpL2!!.`val`
                    tmpL1 = tmpL1.next
                    tmpL2 = tmpL2.next
                }
                tmpL1 != null -> {
                    num = tmpL1.`val`
                    tmpL1 = tmpL1.next
                }
                else -> {
                    num = tmpL2!!.`val`
                    tmpL2 = tmpL2.next
                }
            }
            if (carry > 0) {
                num += carry
            }

            if (num >= 10) {
                carry = num / 10
                num %= 10
            } else {
                carry = 0
            }

            val sum = ListNode(num)
            if (tmp == null) {
                tmp = sum
                result = sum
            } else {
                tmp.next = sum
                tmp = tmp.next
            }
        }
        if (carry > 0) {
            tmp?.next = ListNode(carry)
        }
        return result
    }
}