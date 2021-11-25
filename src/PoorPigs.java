class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(1 + minutesToTest / minutesToDie));
    }

    public static void main(String[] args) {
        System.out.println(new PoorPigs().poorPigs(350, 15, 15));
    }
}
