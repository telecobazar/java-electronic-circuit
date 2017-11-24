
/** 
 * Programa de prueba de la Practica 7 Fase 2 
 * 
 * @author Eric Martin UPM
 * @version 1.1
 */
import java.util.Scanner;
import generadores.*;
import componentes.*;
public class P7F2Colecciones {
	static final int NUMEROMUESTRAS = 1000;
	public static void main(String[] args) throws MalFuncionamientoException {
		//constantes definidas para cumplir las restricciones pedidas:
		/*
			"Los siguientes valores serán fijos: la frecuencia de la señal será 2/1000.  
			la fase inicial de las señales sinusoidales será 0 y para el umbral en el caso 
			del generador con saturación se utilizará por defecto el valor 0.8.
			Para el cso del amplificador se usará una ganancia de 0.5"
		*/

		final double f = 2.0 / NUMEROMUESTRAS;
		final double faseInicialSinusoidal =0;
		final double umbralDefecto=0.8;
		final double gananciaDefecto=0.5;
		
		GeneradorSeñal generador = null;
		String tipoGenerador, tipoComponente;
		ITransferencia componente = null;
		
		String salir ;
		Scanner sc = new Scanner(System.in);
		int eleccion;
		IComponentes coleccion=null;
		do{
		System.out.println("Seleccione el modod de almacenamiento de datos");
		System.out.println("Opción 1 ArrayList");
		System.out.println("Opción 2 HashMap");
		eleccion= sc.nextInt();
		sc.nextLine();
		
		if(eleccion==1){
			coleccion =new ComponenteList();
			System.out.print("Se ha creado una lista vacia \n");
		}else if(eleccion==2){
		    coleccion =new ComponentesMap();
		    System.out.print("Se ha creado un mapa vacio \n");
		}
		}while(eleccion!=1 && eleccion!=2);
		
		
		Componente aux;
		aux = new Condensador("Condensador1");
		coleccion.addComponente(aux);
		aux = new Condensador("Condensador2");
		coleccion.addComponente(aux);
		aux = new Diodo("Diodo1");
		coleccion.addComponente(aux);
		aux = new Diodo("Diodo2");
		coleccion.addComponente(aux);
		aux = new PuenteDiodos("Puente1");
		coleccion.addComponente(aux);
		aux = new PuenteDiodos("Puente2");
		coleccion.addComponente(aux);
		aux = new Amplificador("Amplificador1",gananciaDefecto);
		coleccion.addComponente(aux);
		aux = new Amplificador("Amplificador2",gananciaDefecto);
		coleccion.addComponente(aux);
		
		System.out.println("El numero de componentes es: "+coleccion.size());

		do{
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
					
					case "T": generador= new GeneradorSeñalTriangular("triangular",f);
				          break;
					case "S": generador= new GeneradorSeñalSinusoidal("sinusoidal",f,faseInicialSinusoidal); 
				          break;
					case "U": generador= new GeneradorSeñalSinusoidalConSaturación(
				            "sinusoidal con saturación",f,faseInicialSinusoidal,umbralDefecto);
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
						  /*try{
							  
						  crearCircuito(2,coleccion);
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
						 break;*/
						  try{
							  
							  componente=crearCircuito(2,coleccion,sc);
						  }catch(Exception e){
							  System.out.println(e.getMessage());
						  }
						 break;
					}
					// Mostrar la sonda con la señal de salida del componente
					mostrarSonda(generador, componente, NUMEROMUESTRAS);
				}
			}
			System.out.println("Si desea salir del programa escriba s o S, y despues pulse intro");
			System.out.println("Si salimos borramos los componentes");
			salir= sc.nextLine().toUpperCase();
		}while(salir=="s" || salir=="S");
		
		String[] hola=coleccion.getNombresComponentes();
		for(int i=0;i<coleccion.size();i++){
			System.out.println(hola[i]); 
		 }
		System.out.println("El numero de componentes es: "+coleccion.size());
		System.out.println("Borramos los componentes");
		String[] nombres=coleccion.getNombresComponentes();
		for(int i=0;i<nombres.length;i++){
			coleccion.delComponente(nombres[i]);
		 }
		System.out.println("El numero de componentes es: "+coleccion.size());
		String[] hola1=coleccion.getNombresComponentes();
		for(int i=0;i<coleccion.size();i++){
			System.out.println(hola1[i]); 
		 }
		sc.close();
	}

	/**
	 * Muestra en la sonda gráfica el resultado de aplicar la señal del
	 * generador sobre el componente, con el número de muestras indicado. En el titulo
	 * de la ventana gráfica se añadirá el nombre del componente si el parámetro 
	 * componente es de clase Componente ó el texto fijo "ITransferencia" en
	 * cualquier otro caso.
	 * 
	 * @param generador
	 *            es el generador de señal a utilizar
	 * @param componente
	 *            es el componente al que aplicar la señal del generador
	 * @param muestras
	 *            es el número de muestras a mostrar en la ventana gráfica
	 */
	private static void mostrarSonda(GeneradorSeñal generador,ITransferencia componente, int muestras) throws MalFuncionamientoException {
			// codificar por el alumno
		/*try{
			if(componente instanceof CircuitoSerie ){
			    SondaGráfica grafica2 = new SondaGráfica("Circuito Serie");
				    for(int i=0;i<muestras;i++){
					   grafica2.addMuestra(componente.getSalida(generador.getSalida()));
				    }
			}else{
				     SondaGráfica grafica2 = new SondaGráfica(((Componente)componente).getNombre());
					 for(int i=0;i<muestras;i++){
						 grafica2.addMuestra(componente.getSalida(generador.getSalida()));
					 }
			}
			SondaGráfica grafica = new SondaGráfica(generador.getNombre());
			 for(int i=0;i<muestras;i++){
				 grafica.addMuestra(generador.getSalida());
			 }
	     }catch(Exception e){
		    throw new MalFuncionamientoException("Error: El componente "+componente.toString()+" ha reportado "+e.getMessage());
	     }	*/
		double aux;
		SondaGráfica grafica2;
		try{
			if(componente instanceof CircuitoSerie ){
			     grafica2 = new SondaGráfica("Circuito Serie");
				    
			}else{
				 grafica2 = new SondaGráfica(((Componente)componente).getNombre());
					 
			}
			
			SondaGráfica grafica = new SondaGráfica(generador.getNombre());
			
			 for(int i=0;i<muestras;i++){
				 aux=generador.getSalida();
				 grafica.addMuestra(aux);
				 grafica2.addMuestra(componente.getSalida(aux));
			 }
	     }catch(Exception e){
		    throw new MalFuncionamientoException("Error: El componente "+((Componente)componente).getNombre()+" ha reportado "+e.getMessage());
	     }
	}
	public static CircuitoSerie crearCircuito(int numComponentes,IComponentes coleccion,Scanner sc){
		CircuitoSerie cirt=new CircuitoSerie(numComponentes); 
		
		System.out.println("Los componentes son");
		String[] hola=coleccion.getNombresComponentes();
		for(int i=0;i<coleccion.size();i++){
			System.out.println(hola[i]); 
		 }
		System.out.println("Elige los componntes de CircuitoSerie, hasta un maximo de "+numComponentes);
		int i=0;
		
		do{
			System.out.println("Escriba el nombre de componente");
			String nombre= sc.nextLine();
			cirt.addComponente(coleccion.getComponente(nombre));
				if(cirt.size()>i){
					i++;
				}
		}while(numComponentes>i);
		System.out.println("Los componentes elgidos son: \n"+cirt.toString());
		return cirt;
	}

}
