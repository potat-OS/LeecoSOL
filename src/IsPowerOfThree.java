class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 0x4546B3DB % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().isPowerOfThree(81));
    }
}
