import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class L2022211872_7_Test {

    /**
     * 测试用例设计的总体原则：
     * 1. **等价类划分**：
     *    - 有效等价类：
     *      1. `s` 包含多个字符，`pairs` 中存在多个不连通的交换对。
     *      2. `s` 包含多个字符，`pairs` 中的交换对可以形成一个连通分量。
     *      3. `s` 是一个已经按字典序排列的字符串，不需要任何交换。
     *      4. `s` 是单个字符，`pairs` 为空，不需要交换。
     *      5. `pairs` 中包含重复的交换对，检查程序是否能正确处理重复交换。
     *    - 无效等价类：
     *      - `pairs` 中包含的索引超出字符串 `s` 的范围（根据题目约束假设输入合法，不测试该类情况）。
     *
     * 2. **边界值分析**：
     *    - 测试字符串 `s` 的长度为1（最小长度）。
     *    - 测试字符串 `s` 和 `pairs` 的长度为最大值（如性能测试）。
     *
     * 3. **特例**：
     *    - 测试所有字符相同的字符串。
     *    - 测试已经按字典序排序的字符串。
     */

    // 测试用例1：基本功能测试，多个连通分量
    // 输入: s = "dcab", pairs = [[0, 3], [1, 2]]
    // 期望输出: "bacd"
    @Test
    public void testBasicCase() {
        Solution7 solution = new Solution7();
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2));
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("bacd", result);
    }

    // 测试用例2：所有字符可交换，形成一个连通分量
    // 输入: s = "dcab", pairs = [[0, 3], [1, 2], [0, 2]]
    // 期望输出: "abcd"
    @Test
    public void testAllConnected() {
        Solution7 solution = new Solution7();
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2));
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("abcd", result);
    }

    // 测试用例3：已经按字典序排序
    // 输入: s = "abc", pairs = [[0, 1], [1, 2]]
    // 期望输出: "abc"
    @Test
    public void testAlreadySorted() {
        Solution7 solution = new Solution7();
        String s = "abc";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2));
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("abc", result);
    }

    // 测试用例4：只有一个字符，无需交换
    // 输入: s = "a", pairs = []
    // 期望输出: "a"
    @Test
    public void testSingleCharacter() {
        Solution7 solution = new Solution7();
        String s = "a";
        List<List<Integer>> pairs = Arrays.asList();
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("a", result);
    }

    // 测试用例5：重复的交换对
    // 输入: s = "cba", pairs = [[0, 1], [1, 2], [0, 1], [1, 2]]
    // 期望输出: "abc"
    @Test
    public void testDuplicatePairs() {
        Solution7 solution = new Solution7();
        String s = "cba";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(0, 1), Arrays.asList(1, 2));
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("abc", result);
    }

    // 测试用例6：所有字符相同
    // 输入: s = "aaa", pairs = [[0, 1], [1, 2]]
    // 期望输出: "aaa"
    @Test
    public void testAllCharactersSame() {
        Solution7 solution = new Solution7();
        String s = "aaa";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2));
        String result = solution.smallestStringWithSwaps(s, pairs);
        Assert.assertEquals("aaa", result);
    }
}
