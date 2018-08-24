public class GenDeltaT {
	public static void main(String[] args) {
		double Lambda = 5.0;
		System.out.println("Iniciando main de GenDeltaT...");
		
		double dt = 0.0;
		double sdt = 0.0;
		long N = 1000;
		double prom_dt = 0.0;
		
		for (long k = 0; k < N; k++) {
			dt = -1.0/Lambda*(Math.log(Math.random()));
			sdt += dt;
			System.out.println(k + " deltaT: " + dt);
		}
		
		prom_dt = sdt/N;
		System.out.println("Promedio de deltaT: " + prom_dt);
	}
}