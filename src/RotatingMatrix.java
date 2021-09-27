/**
 * @author Han.Linjue
 */
class RotatingMatrix {

    int[][] matrix;
    int count;

    public RotatingMatrix(int[][] matrix, int count) {
        this.matrix = matrix;
        this.count = count;
    }

    public int[][] rotating() {
        // y, count - 1 - x;

        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int count = 3;
        RotatingMatrix rotatingMatrix = new RotatingMatrix(matrix, count);
        int[][] results = rotatingMatrix.rotating();
        for (int[] res : results) {
            System.out.println();
            for (int is : res) {
                System.out.print(is);
            }
        }
    }
}