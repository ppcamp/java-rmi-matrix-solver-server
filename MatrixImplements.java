import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import src.matrix;

public class MatrixImplements extends UnicastRemoteObject implements Matrix
{
    private static final long serialVersionUID = 1L;
    protected MatrixImplements() throws RemoteException
    {
        super();
    }

    public int[][] multiply(int[][] A, int[][] B) throws RemoteException
    {
        return matrix.multiply(A, B);
    }
}