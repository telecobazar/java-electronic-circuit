
/**
	 Programa principal que permite probar los distintos generadores
	 creados
*/
/** 
 *Programa que muestra una funcion previamente codificada
 *@author Eric Martín León
 *@version 1.0 
 */

import generadores.*;

import java.util.Scanner;

import componentes.SondaGráfica;

public class P5GeneradorSeñalPaquetes {
	static final int NUMEROMUESTRAS = 1000;
	public static void main(String[] args) {
		//constantes definidas para cumplir las restricciones pedidas:
		/*
			"Los siguientes valores serán fijos: la frecuencia de la señal será 2/1000.  
			la fase inicial de las señales sinusoidales será 0 y para el umbral en el caso 
			del generador con saturación se utilizará por defecto el valor 0.8."
		*/

		final double f = 2.0 / NUMEROMUESTRAS;
		final double faseInicialSinusoidal =0;
		final double UmbralDefecto=0.8;
		
		GeneradorSeñal generador = null;
		String tipo;	

			
		Scanner sc=new Scanner(System.in);
		System.out.print ("Teclee tipo (T o S o U):");
		tipo=sc.nextLine().toUpperCase();
		if (!tipo.equals("T") && !tipo.equals("S")&& !tipo.equals("U")){
			System.out.println("El tipo especificado no es correcto.");
		}else{
			switch (tipo){
			case "T": generador= new GeneradorSeñalTriangular("triangular 1",f);
			          break;
			case "S": generador= new GeneradorSeñalSinusoidal("sinusoidal 1",f,faseInicialSinusoidal); 
			          break;
			case "U": generador= new GeneradorSeñalSinusoidalConSaturación("sinusoidal con saturacion",f,faseInicialSinusoidal,UmbralDefecto);
				      break;
			}
			mostrarSonda(generador,NUMEROMUESTRAS);		
		}
		sc.close();
	}
	/**
	 * Muestra en la sonda gráfica la señal del generador,
	 * con el número de muestras indicado. En el titulo
	 * de la ventana se añadirá el nombre del generador y su frecuencia.
	 
	 * @param generador
	 *            es el generador de señal a utilizar
	 * @param muestras
	 *            es el número de muestras a mostrar
	 */
	private static void mostrarSonda(GeneradorSeñal generador, int muestras) {
		// codificar por el alumno
		
		 SondaGráfica grafica = new SondaGráfica(generador.getNombre());
		 for(int i=0;i<muestras;i++){
			 grafica.addMuestra(generador.getSalida());
		 }
		
	}

}
