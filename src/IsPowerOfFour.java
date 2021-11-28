// import java.util.HashSet;
// import java.util.Set;

class IsPowerOfFour {
    // Set<Long> set;

    // public boolean isPowerOfFour(int n) {
    //     set = new HashSet<>();
    //     preAction();
    //     return set.contains((long) n);
    // }

    // private void preAction() {
    //     for (long i = 1; i <= Integer.MAX_VALUE; i *= 4) {
    //         set.add(i);
    //     }
    // }

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfFour().isPowerOfFour(16));
    }
}
