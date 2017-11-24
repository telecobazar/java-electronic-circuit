
/**
	 Programa principal que permite probar los distintos generadores
	 creados
*/
/** 
 *Programa que muestra una funcion previamente codificada
 *@author Eric Mart�n Le�n
 *@version 1.0 
 */

import generadores.*;

import java.util.Scanner;

import componentes.SondaGr�fica;

public class P5GeneradorSe�alPaquetes {
	static final int NUMEROMUESTRAS = 1000;
	public static void main(String[] args) {
		//constantes definidas para cumplir las restricciones pedidas:
		/*
			"Los siguientes valores ser�n fijos: la frecuencia de la se�al ser� 2/1000.  
			la fase inicial de las se�ales sinusoidales ser� 0 y para el umbral en el caso 
			del generador con saturaci�n se utilizar� por defecto el valor 0.8."
		*/

		final double f = 2.0 / NUMEROMUESTRAS;
		final double faseInicialSinusoidal =0;
		final double UmbralDefecto=0.8;
		
		GeneradorSe�al generador = null;
		String tipo;	

			
		Scanner sc=new Scanner(System.in);
		System.out.print ("Teclee tipo (T o S o U):");
		tipo=sc.nextLine().toUpperCase();
		if (!tipo.equals("T") && !tipo.equals("S")&& !tipo.equals("U")){
			System.out.println("El tipo especificado no es correcto.");
		}else{
			switch (tipo){
			case "T": generador= new GeneradorSe�alTriangular("triangular 1",f);
			          break;
			case "S": generador= new GeneradorSe�alSinusoidal("sinusoidal 1",f,faseInicialSinusoidal); 
			          break;
			case "U": generador= new GeneradorSe�alSinusoidalConSaturaci�n("sinusoidal con saturacion",f,faseInicialSinusoidal,UmbralDefecto);
				      break;
			}
			mostrarSonda(generador,NUMEROMUESTRAS);		
		}
		sc.close();
	}
	/**
	 * Muestra en la sonda gr�fica la se�al del generador,
	 * con el n�mero de muestras indicado. En el titulo
	 * de la ventana se a�adir� el nombre del generador y su frecuencia.
	 
	 * @param generador
	 *            es el generador de se�al a utilizar
	 * @param muestras
	 *            es el n�mero de muestras a mostrar
	 */
	private static void mostrarSonda(GeneradorSe�al generador, int muestras) {
		// codificar por el alumno
		
		 SondaGr�fica grafica = new SondaGr�fica(generador.getNombre());
		 for(int i=0;i<muestras;i++){
			 grafica.addMuestra(generador.getSalida());
		 }
		
	}

}
