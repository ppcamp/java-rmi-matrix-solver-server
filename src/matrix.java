package src;
/**
 * This package implements a class for matrix with common functions.
 * Note: Only for int type.
 */

public class matrix {
    public static int[][] eye(int N)
    {
        /**
         * Identity matrix
         *
         * @param int N:    Number of rows and cols.
         */

        int[][] C = new int [N][N];
        for (int i=0; i<N; i++)
        {
            for (int j=0; j<N; j++)
            {
                C[i][j] = 0;
                if (i==j)
                    C[i][j] = 1;
            }
        }

        return C;
    }

    public static int[][] scalar(int[][] A, int N)
    {
        /**
         * Multplies a matrix by a scalar N.
         *
         * @param int[][] A:    Matrix A
         * @param int N:        Scalar
         */

        int[][] C = new int[A.length][A[0].length];
        for (int i=0; i<A.length; i++)
            for (int j=0; j<A[0].length; j++)
                C[i][j] = A[i][j] * N;
        return C;
    }

    public static int[][] zeros(int N)
    {
        /**
         * Zero matrix
         *
         * @param int N:    Number of rows and cols
         * @return int[][] Matrix filled with zeros
         */

        int[][] C = new int [N][N];
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                C[i][j] = 0;
        return C;
    }

    public static int[][] ones(int N)
    {
        /**
         * One's matrix
         *
         * @param int N:    Number of rows and cols
         * @return int[][] Matrix NxN filled with ones.
         */

        int[][] C = new int [N][N];
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                C[i][j] = 1;
        return C;
    }

    public static int[][] minus(int[][] A, int[][] B)
    {
        /**
         * Operation A - B
         *
         * @param int[][] A:    Matrix A (LxM)
         * @param int[][] B:    Matrix B (PxO)
         * @note A and B matrix must be the same dimension.
         * @return int[][] Matrix A-B
         */
        int L = A.length;
        int M = A[0].length;

        if (B.length != L || B[0].length != M)
            throw new ArithmeticException("Dimensions different");

        int[][] C = new int [L][M];
        for (int i=0; i<L; i++)
            for (int j=0; j<M; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    public static int[][] sum(int[][] A, int[][] B)
    {
        /**
         * Operation A + B
         *
         * @param int[][] A:    Matrix A (LxM)
         * @param int[][] B:    Matrix B (PxO)
         * @note A and B matrix must be the same dimension.
         * @return int[][] Matrix A+B
         */
        int L = A.length;
        int M = A[0].length;

        if (B.length != L || B[0].length != M)
            throw new ArithmeticException("Dimensions different");

        int[][] C = new int [L][M];
        for (int i=0; i<L; i++)
            for (int j=0; j<M; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    public static int[][] multiply(int[][] A, int[][] B)
    {
        /**
         * Multiply matrixes
         *
         * @param int[][] A:    Matrix Aij (LxM)
         * @param int[][] B:    Matrix Bjk (MxN)
         * @return int[][] C:   Matrix Cik (LxN)
         */

        //  a[0.. (L-1)][0.. (m-1)]     // A matrix
        //  b[0.. (m-1)][0.. (n-1)]     // B
        //  c[0.. (L-1)][0.. (n-1)]     // A[L, m] * B[m,n] = C[L,n]
        //
        //  t                           produto
        //  i,j,k                       indices
        //
        // Begin
        //      for i=0:L do
        //          for j=0:n do
        //              t=0
        //              for k=0:m do
        //                  t = t+a[i][k] * b[k][j]
        //              done
        //              c[i][j] = t
        //          done
        //      done
        // done

        int L = A.length;
        int M = A[0].length;
        int N = B[0].length;

        if (M != B.length)
        {
            String message = "The number of Columns in A must be equal to the number of rows in B.";
            throw new ArithmeticException(message);
        }

        int sum = 0; // sum of row*col
        int[][] C = new int[L][N];

        for (int i=0; i<L; i++)
        {
            for (int j=0; j<N; j++)
            {
                sum = 0;
                for (int k=0; k<M; k++)
                    sum += A[i][k] * B[k][j];
                C[i][j] = sum;
            }
        }

        return C;
    }

    public static void print(int[][] M)
    {
        /**
         * Print the output formatted of an Matrix of LxN
         *
         * @param int[][] M:    Matrix to print
         */
        int l = M.length;
        int n = M[0].length;

        String line = "-";
        line = line.repeat(100);

        System.out.println(line + "\n" + "\t\t\t\t\t\tMatrix:");
        for (int i=0; i<l; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.print('\n');
        }
        System.out.println(line);
    }
}