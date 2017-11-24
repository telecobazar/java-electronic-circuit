
/** 
 * Clase que emula un generador de señal sinusoidal con saturación
 * 
 * @author Eric Martin Leon UPM
 * @version 1.1
 */

package generadores;

public class GeneradorSeñalSinusoidalConSaturación extends GeneradorSeñalSinusoidal {

	private double umbral;
	private int t;
	public static final double PI = 3.14159265358979323846;
	/**
	  Constructor de la clase alumno
	  @param nombre es el nombre completo del genrador. No puede estar vacío. 
	  @param f es la frecuencia que se utiliza para representar.
	  @param fase0 es la fase inicial de coseno
	  @param umbral es la valor maximo que puede alzanzar la señal sinusoidal 
	 */	
	public GeneradorSeñalSinusoidalConSaturación(String nombre, double f, double fase0, double umbral) {
		super(nombre, f, fase0);
		if(nombre==null)
			throw  new IllegalArgumentException ("Generador sin nombre sin nombre");
		this.nombre=nombre;
		if(umbral>1 || umbral<0)
			throw  new IllegalArgumentException ("El umbral es mayor que uno o menor que 0");
		this.umbral=umbral;
		t=0;
	}
	/**
	 * Nos aporta el resultado de la grafica sinudoidal con 
	 * saturacion en un instante predeterminado
	 */
    public double getSalida(){
		
		double resultado;
		double salida=0;
		
		resultado=Math.sin((2*PI*f*t)+fase0);
		t++;
		
		if(umbral<resultado)
			salida=umbral;
		
		if(Math.abs(resultado)<=umbral) 
			salida=resultado;
		
		if(resultado<-umbral)	
		    salida=-umbral;
		
		return salida;
	}


}
