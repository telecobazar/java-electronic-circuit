
/** 
 * Clase que emula un generador de se�al sinusoidal con saturaci�n
 * 
 * @author Eric Martin Leon UPM
 * @version 1.1
 */

package generadores;

public class GeneradorSe�alSinusoidalConSaturaci�n extends GeneradorSe�alSinusoidal {

	private double umbral;
	private int t;
	public static final double PI = 3.14159265358979323846;
	/**
	  Constructor de la clase alumno
	  @param nombre es el nombre completo del genrador. No puede estar vac�o. 
	  @param f es la frecuencia que se utiliza para representar.
	  @param fase0 es la fase inicial de coseno
	  @param umbral es la valor maximo que puede alzanzar la se�al sinusoidal 
	 */	
	public GeneradorSe�alSinusoidalConSaturaci�n(String nombre, double f, double fase0, double umbral) {
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
