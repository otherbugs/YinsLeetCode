package priv.yins.leetcode.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Day4
 * @Description: 566. 重塑矩阵 118. 杨辉三角
 * @Author: yinshuang
 * @Date: 2021/7/19 10:26
 * @Version: 1.0
 */
public class Day4 {
    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * <p>
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * <p>
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * <p>
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * <p>
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * <p>
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     * [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * <p>
     * 注意：
     * <p>
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ((mat.length * mat[0].length != r * c) || (mat.length == r && mat[0].length == c)) {
            return mat;
        }
        int[][] result = new int[r][c];
        int index;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                index = i * c + (j + 1);
                result[i][j] = mat[index % mat[0].length == 0 ? index / mat[0].length - 1 : index / mat[0].length][index % mat[0].length == 0 ? mat[0].length - 1 : index % mat[0].length - 1];
            }
        }
        return result;
    }

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * <p>
     * <p>
     * <p>
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList(numRows);
        result.add(Arrays.asList(1));
        if (numRows <= 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        for (int i = 2; i < numRows; i++) {
            List row = new ArrayList(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                if (2 * j <= i) {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                } else {
                    row.add(row.get(i - j));
                }
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
