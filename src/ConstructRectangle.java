public class ConstructRectangle {
    public int[] constructRectangle(int area) {

        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[] { area / w, w };
    }

    public static void main(String[] args) {
        ConstructRectangle rectangle = new ConstructRectangle();
        int[] ans = rectangle.constructRectangle(20);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
