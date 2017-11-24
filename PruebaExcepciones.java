

/** 
 * Programa de prueba de las excepciones 
 * @author Eric Martin UPM
 * @version 1.1
 */
import componentes.*;
import generadores.*;

public class PruebaExcepciones {
	static final int NUMEROMUESTRAS = 1000;
	
	public static void main(String[] args) {
		int pruebasPasadas=0;
		boolean pruebaPasada=false;
		GeneradorSeñal generador;
		ITransferencia componente;
		final double f = 2.0 / NUMEROMUESTRAS;
		final double faseInicialSinusoidal =0;

		
		// Prueba 1: crear un componente sin nombre
		try {
			componente = new Amplificador(null,10);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 1: crear un componente sin nombre. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción, por ejemplo NullPointerException, no es correcto
		}
		if (!pruebaPasada) System.err.println("Prueba 1: crear un componente sin nombre. No pasada");
		pruebaPasada=false;		
		
		//Prueba 2: crear generador sin nombre
		try {
			generador = new GeneradorSeñalSinusoidal(null,f,faseInicialSinusoidal);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 2: crear generador sin nombre. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción, por ejemplo NullPointerException, no es correcto
		}
		if (!pruebaPasada) System.err.println("Prueba 2: crear generador sin nombre. No pasada");
		pruebaPasada=false;

		// Prueba 3: crear un Generador con frecuencia menor o igual que 0
		try {
			generador = new GeneradorSeñalSinusoidal("Generador",-1,faseInicialSinusoidal);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 3: crear un Generador con frecuencia menor o igual que 0. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción, por ejemplo NullPointerException, no es correcto
		}
		if (!pruebaPasada) System.err.println("Prueba 3: Generador con frecuencia menor o igual que 0. No pasada");
		pruebaPasada=false;
		
		// Prueba 4: crear un Generador sinusoidal con fase negativa
		try {
			generador = new GeneradorSeñalSinusoidal("Generador",1,-1);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 4: crear un Generador sinusoidal con fase negativa. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción, por ejemplo NullPointerException, no es correcto
		}
		if (!pruebaPasada) System.err.println("Prueba 4: Generador sinusoidal con fase negativa. No pasada");
		pruebaPasada=false;		
		
		// Prueba 5: introducir valores negativos a un condensador
		try {
			componente = new Condensador("Condensador");
			componente.getSalida(-1);
		} catch (IllegalArgumentException e) {
			System.out.println("Prueba 5: introducir valores negativos a un condensador. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción, por ejemplo CircuitoException, no es correcto. El condensador debe arrojar IllegalArgumentException àra una entrada negativa
		}
		if (!pruebaPasada) System.err.println("Prueba 5: introducir valores negativos a un condensador. No pasada.");
		pruebaPasada=false;

		// Prueba 6: crear un circuito serie con número negativo de componentes
		CircuitoSerie circuito;
		try {
			circuito = new CircuitoSerie (-1);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 6: crear un circuito serie con número negativo de componentes. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción es porque arroja una excepción no válida
		}
		if (!pruebaPasada) System.err.println("Prueba 6: crear un circuito serie con número negativo de componentes. No pasada.");
		pruebaPasada=false;

		// Prueba 7: introducir un nulo en el circuito
		try {
			circuito = new CircuitoSerie (5);
			circuito.addComponente(null);
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 7: introducir un nulo en el circuito. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción es porque arroja una excepción no válida
		}
		if (!pruebaPasada) System.err.println("Prueba 7: introducir un nulo en el circuito. No pasada.");
		pruebaPasada=false;

		// Prueba 8: crear un circuito serie con mas componentes de los que admite
		try {
			circuito = new CircuitoSerie (2);
			circuito.addComponente(new Condensador("Condensador"));
			circuito.addComponente(new Diodo("Diodo"));
			circuito.addComponente(new Diodo("Diodo"));			
		} catch  (IllegalArgumentException e){
			System.out.println("Prueba 8: crear un circuito serie con mas componentes de los que admite. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		} catch ( Exception e) {
			//Si ocurre otra excepción es porque arroja una excepción no válida
		}
		if (!pruebaPasada) System.err.println("Prueba 8: crear un circuito serie con mas componentes de los que admite. No pasada.");
		pruebaPasada=false;

		// Prueba 9: metodo getSalida de un circuito serie con un condensador al que se le mete una entrada negativa
		try {
			circuito = new CircuitoSerie (2);
			circuito.addComponente(new Condensador("Condensador"));
			circuito.getSalida (-1);
		} catch ( IllegalArgumentException e) {
			System.out.println("Prueba 9: metodo getSalida de un circuito serie con un condensador al que se le mete una entrada negativa. Pasada. Mensaje devuelto por la excepción: " + e.getMessage());
			pruebasPasadas++;pruebaPasada=true;
		}  catch ( Exception e) {
			//Si ocurre otra excepción es porque getSalida arroja una excepción no válida, por ejemplo IllegalArgumentException
		}
		if (!pruebaPasada) System.err.println("Prueba 9: metodo getSalida de un circuito serie con un condensador al que se le mete una entrada negativa. No pasada.");



		// Resultados de las pruebas
		try {
			Thread.sleep(1000);                 //Esperar un segundo.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.flush();System.err.flush();
		if (pruebasPasadas==9)
			System.out.println("\nHas pasado todas las pruebas");
		else
			System.err.println("\nNo has pasado todas las pruebas: has pasado "+ pruebasPasadas + " y deberías pasar 9");
	}
}



