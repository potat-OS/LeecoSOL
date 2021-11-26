// import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReorderedPowerOf2 {
    // // 回溯暴力枚举
    // boolean[] vis;
    // public boolean reorderedPowerOf2(int n) {
    //     char[] arr = String.valueOf(n).toCharArray();
    //     vis = new boolean[arr.length];
    //     return backTrack(arr, 0, 0);
    // }

    // private boolean backTrack(char[] arr, int idx, int num) {
    //     if (arr.length == idx) {
    //         return isPowerOfTwo(num);
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         if ((num == 0 && arr[i] == '0') || vis[i] || (i > 0 && !vis[i - 1] && arr[i] == arr[i - 1])) {
    //             continue;
    //         }
    //         vis[i] = true;
    //         if (backTrack(arr, 1 + idx, 10 * num + arr[i] - '0')) {
    //             return true;
    //         }
    //         vis[i] = false;
    //     }
    //     return false;
    // }

    // 二的幂
    // private boolean isPowerOfTwo(int n) {
    //     return n <= 0 ? false : (n & (n - 1)) == 0;
    // }

    // // 简单排序判断
    // public boolean reorderedPowerOf2(int n) {
    //     char[] arr = String.valueOf(n).toCharArray(), tmp;
    //     Arrays.sort(arr);
    //     for (int i = 1; i < 1e9; i *= 2) {
    //         String iStr = String.valueOf(i);
    //         if (iStr.length() >= arr.length) {
    //             tmp = iStr.toCharArray();
    //             Arrays.sort(tmp);
    //             if (Arrays.equals(tmp, arr)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // 字频统计
    Set<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        preAction();
        return set.contains(frequency(n));
    }

    private void preAction() {
        for (int i = 1; i < 1e9; i *= 2) {
            set.add(frequency(i));
        }
    }

    private String frequency(int n) {
        char[] tmp = new char[10];
        while (n > 0) {
            tmp[n % 10]++;
            n /= 10;
        }
        return new String(tmp);
    }
}
