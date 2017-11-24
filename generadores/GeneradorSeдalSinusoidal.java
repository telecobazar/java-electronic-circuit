
/** 
 * Clase que emula un generador sinusoidal   
 * 
 * @author Eric Martín León UPM
 * @version 1.1
 */
package generadores;

public class GeneradorSeñalSinusoidal extends GeneradorSeñal  {

	protected double fase0;
	public static final double PI = 3.14159265358979323846;
	private int t;
	/**
	  Constructor de la clase alumno
	  @param nombre es el nombre completo del genrador. No puede estar vacío. 
	  @param f es la frecuencia que se utiliza para representar.
	  @param fase0 es la fase inicial de coseno 
	 */	 
	public GeneradorSeñalSinusoidal(String nombre, double f,double fase0) {
		super(nombre,f);
		if(nombre==null)
			throw  new IllegalArgumentException ("Generador sin nombre sin nombre");
		this.nombre=nombre;
		if(fase0<0)
			throw  new IllegalArgumentException ("La fase inicial es menor o igual que cero");
		this.fase0=fase0;
		t=0;
	}
	/**
	 * Nos aporta el resultado de la grafica sinusoidal
	 * en un instante predeterminado
	 */
	public double getSalida(){
		double resultado;
		
		resultado=Math.sin((2*PI*f*t)+fase0);
		t++;
		
		return resultado;
	}
}
