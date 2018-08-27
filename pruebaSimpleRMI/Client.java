package example.hello;

    import java.rmi.registry.LocateRegistry;
    import java.rmi.registry.Registry;

    public class Client {
		

        private Client() {}

        public static void main(String[] args) {
            int i;
            String response;
            String host = (args.length < 1) ? null : args[0];
			double dt = 0.0;
			double sdt_2 = 0.0;
			double sdt = 0.0;
			int N = 1000;
			double prom_dt = 0.0;
			double std_dt = 0.0;
			long t0, t1;
		
            try 
            {
                Registry registry = LocateRegistry.getRegistry(host);
                Suma stub = (Suma) registry.lookup("Suma");
                for(i=0;i<N;i++)
                {
					t0 = System.nanoTime();
   				    response = stub.suma(i,N);
					t1 = System.nanoTime();
					dt = (double) (t1 - t0);
					sdt += dt;
					sdt_2 += dt*dt;
					System.out.println("response: " + response);
                } 
				
				prom_dt = sdt/N;
				std_dt = Math.sqrt((sdt_2-N*prom_dt*prom_dt)/(N-1));
				System.out.println("================================================================");
				System.out.println("Para " + N + " solicitudes de ejecucion:\n Promedio: " + prom_dt + ". Desviación estandar: " + std_dt + ".");
				System.out.println("================================================================");
            } 
            catch (Exception e) 
            {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }

