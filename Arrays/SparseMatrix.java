public class SparseMatrix {

    int[][] originalMatrix;
    int[][] sparseMatrix;
    int rows, cols; // rows and columns of original matrix
    int nonZeroElements;

    public SparseMatrix(int[][] originalMatrix) {
        this.originalMatrix = originalMatrix;
        this.rows = originalMatrix.length;
        this.cols = originalMatrix[0].length;
        fillSparseMatrix();
    }

    void fillSparseMatrix() {

        this.nonZeroElements = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (originalMatrix[i][j] != 0) nonZeroElements++;

        sparseMatrix = new int[nonZeroElements + 1][3];

        sparseMatrix[0][0] = this.rows;
        sparseMatrix[0][1] = this.cols;
        sparseMatrix[0][2] = nonZeroElements;

        int c = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (originalMatrix[i][j] != 0) {
                    sparseMatrix[c][0] = i;
                    sparseMatrix[c][1] = j;
                    sparseMatrix[c][2] = originalMatrix[i][j];
                    c++;
                }

    }

    public int[][] transposeSparseMatrix() {

        int[][] transpose = new int[nonZeroElements + 1][3];

        for (int i = 0; i < nonZeroElements + 1; i++) {
            transpose[i][0] = sparseMatrix[i][1];
            transpose[i][1] = sparseMatrix[i][0];
            transpose[i][2] = sparseMatrix[i][2];
        }

        // sort
        for (int i = 1; i < nonZeroElements + 1; i++) {
            for (int j = i + 1; j < nonZeroElements + 1; j++) {

                if (transpose[i][0] > transpose[j][0])
                    swapRows(transpose, i, j);

                else if (transpose[i][0] == transpose[j][0])
                    if (transpose[i][1] > transpose[j][1])
                        swapRows(transpose, i, j);

            }
        }

        return transpose;
    }

    private void swapRows(int[][] arr, int i1, int i2) {

        int t = arr[i1][0];
        arr[i1][0] = arr[i2][0];
        arr[i2][0] = t;

        t = arr[i1][1];
        arr[i1][1] = arr[i2][1];
        arr[i2][1] = t;

        t = arr[i1][2];
        arr[i1][2] = arr[i2][2];
        arr[i2][2] = t;
    }

    public int[][] getOriginalMatrix() {
        return originalMatrix;
    }

    public int[][] getSparseMatrix() {
        return sparseMatrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
