class FindComplement {
    public int findComplement(int num) {
        int n = num;
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= n >>> 16;
        return num ^ n;
    }
}
