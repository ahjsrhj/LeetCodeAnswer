
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        let dst = target - nums[i];
        for (let j = 0; j < nums.length; j++) {
            if (i != j && nums[j] == dst) {
                return [i, j];
            }
        }
    }
    return [0, 0];
};

function main() {
    let result = twoSum([3,2,4],6)
}

main()