package priv.yins.leetcode.datastructures;

import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: Day5
 * @Description: 36. 有效的数独 73. 矩阵置零
 * @Author: yinshuang
 * @Date: 2021/7/19 10:27
 * @Version: 1.0
 */
public class Day5 {
    /**
     * 36. 有效的数独
     * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 注意：
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     */
    public boolean isValidSudoku(char[][] board) {


//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]


        return false;
    }

    /**
     * 73. 矩阵置零
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * 进阶：
     * <p>
     * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> line = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(j);
                    line.add(i);
                }
            }
        }

        if (row.size() > 0) {
            Iterator<Integer> iterator = row.iterator();
            while (iterator.hasNext()) {
                Integer r = iterator.next();
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][r] = 0;
                }
            }
        }

        if (line.size() > 0) {
            Iterator<Integer> iterator = line.iterator();
            while (iterator.hasNext()) {
                Integer l = iterator.next();
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[l][j] = 0;
                }
            }
        }
    }
}
