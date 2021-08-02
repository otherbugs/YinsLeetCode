package priv.yins.leetcode.datastructures;

/**
 * @ClassName: Day2
 * @Description: 1. 两数之和 88. 合并两个有序数组
 * @Author: yinshuang
 * @Date: 2021/7/19 10:23
 * @Version: 1.0
 */
public class Day2 {
    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * <p>
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * <p>
     * 提示：
     * <p>
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //我的思路
        //遍历nums2,从大到小遍历，定义两个变量，一个原nums1待比较的最大值位置,一个待放值的位置
        //遍历：如果nums2[i]大于 num1待比较的最大值，就将num2[i]放入待放位置，待放位置索引-1；
        //如果小于，将 num1待比较的最大值放到待放位置，两个索引位置-1，继续判断
        //如果num1待比较的值为空了，将剩余的nums2拷贝num1
        int nums1MaxIndex = m - 1;
        //num1空位置的最大索引
        int emptyIndex = nums1.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (true) {
                if (nums1MaxIndex<0){
                    System.arraycopy(nums2, 0, nums1, 0, i+1);
                    return;
                }
                if (nums2[i] >= nums1[nums1MaxIndex]) {
                    nums1[emptyIndex] = nums2[i];
                    emptyIndex -= 1;
                    break;
                } else {
                    nums1[emptyIndex] = nums1[nums1MaxIndex];
                    emptyIndex -= 1;
                    nums1MaxIndex -= 1;
                }
            }
        }
    }
}
