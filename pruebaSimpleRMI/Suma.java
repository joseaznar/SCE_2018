package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Suma extends Remote {
    String suma(int a, int b) throws RemoteException;
}