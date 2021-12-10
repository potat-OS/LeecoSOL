class MaxArea {
    public int maxArea(int[] height) {
        int ans = 0, lt = 0, rt = height.length - 1;
        while (lt < rt) {
            int x = rt - lt;
            // 取最小木板与x轴相乘取最大值并移动对应指针
            ans = Math.max(height[lt] <= height[rt] ? height[lt++] * x : height[rt--] * x, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}
