import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hao on 10/21/17.
 */
public class leetcodeTest {
    public static int minimumDeleteSum(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put(s1, 0);
        map2.put(s2, 0);
        buildMap(map1, s1, 0);
        buildMap(map2, s2, 0);
        int res = Integer.MAX_VALUE;
        for (String k1 : map1.keySet()) {
            for (String k2 : map2.keySet()) {
                if (k1.equals(k2)) {
                    res = Math.min(res, map1.get(k1) + map2.get(k2));
                }
            }
        }
        return res;
    }

    private static void buildMap(Map<String, Integer> map, String s, int num) {
        if (s == null || s.length() == 0) return;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i));
            sb.append(s.substring(i + 1));
            String newStr = sb.toString();
            //System.out.println(newStr);
            if (!map.containsKey(newStr)) map.put(newStr, num + (int)s.charAt(i));
            buildMap(map, newStr, num + (int)s.charAt(i));
        }
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, k, 1, new ArrayList<Integer>(), 0);
        return ans.size();
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, int target, int curProd, ArrayList<Integer> temp, int index) {
        if (curProd >= target) return;
        if (curProd < target && temp.size() > 0) {
            System.out.println(temp);
            ans.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, ans, target, curProd * nums[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
