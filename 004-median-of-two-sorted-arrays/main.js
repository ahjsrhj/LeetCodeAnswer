/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    const m = nums1.length
    const n = nums2.length
    const isUneven = (m + n) % 2 == 1
    const sum = Math.floor((m + n) / 2) + 1
    const newArr = []
    let idx1 = 0
    let idx2 = 0
    let i = 0;
    for (; i < sum; i++) {
        if (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] > nums2[idx2]) {
                newArr.push(nums2[idx2])
                idx2++
            } else {
                newArr.push(nums1[idx1])
                idx1++
            }
        } else if (idx1 >= nums1.length) {
            newArr.push(nums2[idx2])
            idx2++
        } else if (idx2 >= nums2.length) {
            newArr.push(nums1[idx1])
            idx1++
        }
    }
    if (isUneven) {
        // 奇数
        return newArr[i-1]
    } else {
        return (newArr[i-1] + newArr[i - 2]) / 2
    }
};

nums1 = [1, 2]
nums2 = [3, 4]
const result = findMedianSortedArrays(nums1, nums2)
console.log(result)



