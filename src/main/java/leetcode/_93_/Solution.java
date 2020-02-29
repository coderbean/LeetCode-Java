package leetcode._93_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        doRestore(result, "", s, 0);
        return result;
    }

    /**
     * DFS 反解析 IP 地址
     *
     * @param result 解析结果
     * @param path   已经走完的路径：譬如：192.169
     * @param s      剩下的需要解析的字符串
     * @param level  DFS 的第几层
     */
    private void doRestore(List<String> result, String path, String s, int level) {
        if ((4 - level) * 3 < s.length()) {
            return;
        }
        // 如果大于三层，说明已经完成了
        if (s.isEmpty()) {
            if (level == 4) {
                // 因为 path 最前面有一个 "." 需要去除
                result.add(path.substring(1));
            }
            return;
        }
        // 开始的那个字母
        String startNum = s.substring(0, 1);
        for (int i = 0; i < (startNum.equals("0") ? 1 : (Math.min(s.length(), 3))); i++) {
            if (Integer.parseInt(s.substring(0, i + 1)) <= 255) {
                doRestore(result, path + "." + s.substring(0, i + 1), s.substring(i + 1), level + 1);
            }
        }
    }
}