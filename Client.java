import java.rmi.Naming;

import src.matrix;
// import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Matrix A (LxM)\tMatrix B (MxN)");
        // System.out.print("L: ");
        // int L = input.nextInt();
        // System.out.print("M: ");
        // int M = input.nextInt();
        // System.out.print("N: ");
        // int N = input.nextInt();

        // int[][] A = new int[L][M];
        // int[][] B = new int[M][N];

        // String fillMsg;
        // String line = "-";
        // line = line.repeat(100);

        // System.out.println(line + "\n" + "\t\t\t\t\t\tMatrix A input:");
        // for (int i=0; i<L; i++)
        // {
        //     System.out.println(line + "\n\t\t\t\t\t\tRow: " + i);
        //     fillMsg = "Value for A[" + i + "][";
        //     for (int j=0; j<M; j++)
        //     {
        //         System.out.print(fillMsg + j + "]: ");
        //         A[i][j] = input.nextInt();
        //     }
        // }

        // System.out.println(line + "\n" + "\t\t\t\t\t\tMatrix B input:");
        // for (int i=0; i<M; i++)
        // {
        //     System.out.println(line + "\n\t\t\t\t\t\tRow: " + i);
        //     fillMsg = "Value for B[" + i + "][";
        //     for (int j=0; j<N; j++)
        //     {
        //         System.out.print(fillMsg + j + "]: ");
        //         B[i][j] = input.nextInt();
        //     }
        // }



        // Example of inputs
        int[][] A = {
            {3,     5,      6},
            {7,     9,      6},
            {65,    45,     6},
            {88,    13,     6}
        };
        int[][] B = {
            {21,     89},
            {21,     41},
            {16,     6}
        };

        matrix.print(A);
        matrix.print(B);
        
        // input.close(); // Close buffer of Input
        
        String ip = "127.0.0.1";
        int port = 1099;
        String serviceName = "Matrix";
        String server = "rmi://" + ip + ":" + port + "/" + serviceName;
        try
        {
            Matrix m = (Matrix) Naming.lookup(server);
            System.out.println("Conected with server: " + server);

            int[][] C = m.multiply(A, B);
            matrix.print(C);
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
