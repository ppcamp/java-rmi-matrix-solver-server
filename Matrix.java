import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Matrix extends Remote
{
    public int[][] multiply(int[][] A, int[][] B) throws RemoteException;
}