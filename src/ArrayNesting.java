
class Solution {
    public static int arrayNesting(int[] numbs) {
        int maxLength = 0;
        for (int i = 0; i < numbs.length; i++) {
            int count = 0;
            int k = numbs[i];
            do {
                k = numbs[k];
                count++;
            } while (k != numbs[i]);
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] numbs = { 0, 2, 1 };
        System.out.println(arrayNesting(numbs));
    }
}