package priv.yins.leetcode.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Day3
 * @Description: 350. 两个数组的交集 II 121. 买卖股票的最佳时机
 * @Author: yinshuang
 * @Date: 2021/7/19 10:24
 * @Version: 1.0
 */
public class Day3 {

    /**
     * 350. 两个数组的交集 II
     * <p>
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * <p>
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //我的思路
        //对两组数组中，短的一方转map
        int[] shortArr;
        int[] longArr;
        if (nums1.length < nums2.length) {
            shortArr = nums1;
            longArr = nums2;
        } else {
            shortArr = nums2;
            longArr = nums1;
        }

        int[] result = new int[shortArr.length];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < shortArr.length; i++) {
            if (map.containsKey(shortArr[i])) {
                map.put(shortArr[i], map.get(shortArr[i]) + 1);
            } else {
                map.put(shortArr[i], 1);
            }
        }

        int flag = shortArr.length;
        for (int i = 0; flag > 0 && i < longArr.length; i++) {
            if (map.containsKey(longArr[i])) {
                if (map.get(longArr[i]) == 1) {
                    map.remove(longArr[i]);
                } else {
                    map.put(longArr[i], map.get(longArr[i]) - 1);
                }

                result[shortArr.length - flag] = longArr[i];
                flag--;
            }
        }
        return Arrays.copyOf(result, shortArr.length - flag);
    }

    /**
     * 121. 买卖股票的最佳时机
     * <p>
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit(int[] prices) {
        //我的思路
        int result = 0;
        int min = prices[0];
        int max = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                if ((prices[i] - min) > result) {
                    result = prices[i] - min;
                }
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        return result;
    }
}
