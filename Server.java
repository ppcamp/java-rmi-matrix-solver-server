import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server {
    Server()
    {
        String ip = "127.0.0.1";
        int port = 1099;
        String serviceName = "Matrix";
        String server = "rmi://" + ip + ":" + port + "/" + serviceName;

        try
        {
            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(port);
            System.out.println("Server listening in " + server);

            Matrix m = new MatrixImplements();
            Naming.bind(serviceName, (Remote) m);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Server();
    }
}