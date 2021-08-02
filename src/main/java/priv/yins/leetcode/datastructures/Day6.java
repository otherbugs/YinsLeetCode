package priv.yins.leetcode.datastructures;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Day6
 * @Description: 387. 字符串中的第一个唯一字符 383. 赎金信 242. 有效的字母异位词
 * @Author: yinshuang
 * @Date: 2021/7/20 9:59
 * @Version: 1.0
 */
public class Day6 {
    /**
     * 387. 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * s = "leetcode"
     * 返回 0
     * <p>
     * 提示：你可以假定该字符串只包含小写字母。
     */
    public int firstUniqChar(String s) {
        int result = -1;
        int[] character = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        Set<Integer> set = new HashSet<>();
        int a;

        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i) - 97;
            if (-1 == character[a]) {
                character[a] = i;
            } else {
                character[a] = -2;
                set.add(a);
            }
            if (set.size() == 26) {
                return -1;
            }
        }
        for (int i = 0; i < character.length; i++) {
            if (character[i] != -2 && character[i] != -1) {
                if (result == -1) {
                    result = character[i];
                } else if (result > character[i]) {
                    result = character[i];
                }
            }
        }
        return result;
    }

    /**
     * 383. 赎金信
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * <p>
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * <p>
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * <p>
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 97]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 97] > 0) {
                arr[ransomNote.charAt(i) - 97] -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
