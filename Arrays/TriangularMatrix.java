public class TriangularMatrix {

    int[][] matrix;
    int[] arr;

    public TriangularMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}

class LowerTriangularMatrix extends TriangularMatrix {

    public LowerTriangularMatrix(int[][] matrix) {
        super(matrix);

        this.arr = new int[matrix.length * (matrix.length + 1) / 2];

        int c = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < i + 1; j++)
                arr[c++] = matrix[i][j];
    }

    public int getIndexInArray(int i, int j) {
        if (i < j) return -1;
        return (int) ((Math.pow(i, 2) + i) / 2 + j);
    }
}

class UpperTriangularMatrix extends TriangularMatrix {

    public UpperTriangularMatrix(int[][] matrix) {
        super(matrix);

        this.arr = new int[matrix.length * (matrix.length + 1) / 2];

        int c = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = i; j < matrix.length; j++)
                arr[c++] = matrix[i][j];
    }

    public int getIndexInArray(int i, int j) {
        if (i > j) return -1;
        return (int) (matrix.length * i - (Math.pow(i, 2) + i) / 2 + j);
    }
}
