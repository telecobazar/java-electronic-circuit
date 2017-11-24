
/** 
 * Programa de prueba final 
 * 
 * @author Eric Martin UPM
 * @version 1.1
 */
import generadores.*;
import java.util.Scanner;
import componentes.*;

public class P6Final {
	static final int NUMEROMUESTRAS = 1000;
	public static void main(String[] args) throws MalFuncionamientoException {
		//constantes definidas para cumplir las restricciones pedidas:
		/*
			"Los siguientes valores ser�n fijos: la frecuencia de la se�al ser� 2/1000.  
			la fase inicial de las se�ales sinusoidales ser� 0 y para el umbral en el caso 
			del generador con saturaci�n se utilizar� por defecto el valor 0.8.
			Para el cso del amplificador se usar� una ganancia de 0.5"
		*/

		final double f = 2.0 / NUMEROMUESTRAS;
		final double faseInicialSinusoidal =0;
		final double umbralDefecto=0.8;
		final double gananciaDefecto=0.5;
		
		GeneradorSe�al generador = null;
		String tipoGenerador, tipoComponente;
		ITransferencia componente = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Teclee tipo (T o S o U):");
		tipoGenerador = sc.nextLine().toUpperCase();
		if (!tipoGenerador.equals("T") && !tipoGenerador.equals("S") && !tipoGenerador.equals("U")) {
			System.out.println("El tipo de generador especificado no es correcto.");
		} else {
			System.out.print("Teclee Componente (C,D,P,A,S):");
			tipoComponente = sc.nextLine().toUpperCase();
			if (!tipoComponente.equals("C") && !tipoComponente.equals("D") 
					                        && !tipoComponente.equals("P")&& !tipoComponente.equals("A")&& !tipoComponente.equals("S")) {
				System.out.println("El tipo de componente especificado no es correcto.");
			} else {
				switch (tipoGenerador) {
				
				case "T": generador= new GeneradorSe�alTriangular("triangular",f);
			          break;
				case "S": generador= new GeneradorSe�alSinusoidal("sinusoidal",f,faseInicialSinusoidal); 
			          break;
				case "U": generador= new GeneradorSe�alSinusoidalConSaturaci�n(
			            "sinusoidal con saturaci�n",f,faseInicialSinusoidal,umbralDefecto);
				      break;
				}
				
				
				switch (tipoComponente) {
				  case "C":
					componente = new Condensador("Condensador 1");
					break;
				  case "D":
					componente = new Diodo("Diodo 1");
					break;
				  case "P":
					componente = new PuenteDiodos("Puente 1");
					break;
				  case "A":
					componente = new Amplificador("Amplificador",gananciaDefecto);
					break;
				  case "S": 
					  try{
					  componente=new CircuitoSerie(2);
					  System.out.println("El circuito serie tiene los siguientes componentes");
					  PuenteDiodos comp = new PuenteDiodos("Puente 1"); 
					  Condensador cond=new Condensador ("cond");
				      ((CircuitoSerie)componente).addComponente(comp);
				      ((CircuitoSerie)componente).addComponente(cond);
					  System.out.println("\t Puente diodos final");
					  System.out.println("\t Condensador final");
					  }catch(Exception e){
						  System.out.println(e.getMessage());
					  }
					 break;
				}
				// Mostrar la sonda con la se�al de salida del componente
				mostrarSonda(generador, componente, NUMEROMUESTRAS);

			}
		}
		sc.close();
	}

	/**
	 * Muestra en la sonda gr�fica el resultado de aplicar la se�al del
	 * generador sobre el componente, con el n�mero de muestras indicado. En el titulo
	 * de la ventana gr�fica se a�adir� el nombre del componente si el par�metro 
	 * componente es de clase Componente � el texto fijo "ITransferencia" en
	 * cualquier otro caso.
	 * 
	 * @param generador
	 *            es el generador de se�al a utilizar
	 * @param componente
	 *            es el componente al que aplicar la se�al del generador
	 * @param muestras
	 *            es el n�mero de muestras a mostrar en la ventana gr�fica
	 */
	private static void mostrarSonda(GeneradorSe�al generador,ITransferencia componente, int muestras) throws MalFuncionamientoException {
			// codificar por el alumno
		SondaGr�fica grafica2;
		try{
			if(componente instanceof CircuitoSerie ){
			     grafica2 = new SondaGr�fica("Circuito Serie");
				    
			}else{
				 grafica2 = new SondaGr�fica(((Componente)componente).getNombre());
					 
			}
			
			SondaGr�fica grafica = new SondaGr�fica(generador.getNombre());
			 //double aux =generador.getSalida();
			 for(int i=0;i<muestras;i++){
				 grafica.addMuestra(generador.getSalida());
				 grafica2.addMuestra(componente.getSalida(generador.getSalida()));
			 }
	     }catch(Exception e){
		    throw new MalFuncionamientoException("Error: El componente "+((Componente)componente).getNombre()+" ha reportado "+e.getMessage());
	     }	
	}

}
