package example.hello;
        
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements Hola {
    long cuantos = 0;    
    String strHostname = System.getenv("COMPUTERNAME");
    public Server() {}

    public String sayHello() 
    { 
        cuantos++;
		try 
		{
			Thread.sleep(100);
		} 
		catch(InterruptedException e)
		{
			 System.out.println("Error de interrupción. Detalle: " + e);
		}
        System.out.println("Proporcionando el servicio no. " + cuantos);
        return "Servicio no. " + cuantos + " proporcionado desde " + strHostname;
    }

    public String suma(int a, int b) 
    { 
        int c;
        cuantos++;
		try 
		{
			Thread.sleep(100);
            c = a + b;
		} 
		catch(InterruptedException e)
		{
            c = 0;
			System.out.println("Error de interrupción. Detalle: " + e);
		}
        System.out.println("Proporcionando el servicio no. " + cuantos);
        return "Servicio no. " + cuantos + " proporcionado desde " + strHostname + ". \n Con resultado: " + c;
    }
        
    public static void main(String args[]) {
        
        try {
            Server obj = new Server();
            Hola stub = (Suma) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            egistry.rebind("Suma", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}