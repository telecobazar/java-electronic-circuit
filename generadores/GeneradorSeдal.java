
/** 
 * clase que emula un generador de señal 
 * 
 * @author Eric Martín UPM
 * @version 1.1
 */
package generadores;

public class GeneradorSeñal {
	
	protected double f;
	protected double valor;
	protected String nombre;
	
	/**
	  Constructor de la clase alumno
	  @param nombre es el nombre completo del genrador. No puede estar vacío. 
	  @param f es la frecuencia que se utiliza para representar.
	 */	
	public GeneradorSeñal(String nombre, double f){
		if(f<0)
			throw  new IllegalArgumentException ("La frecuencia es menor o igual que cero");
		if(nombre==null)
			throw  new IllegalArgumentException ("Generador sin nombre sin nombre");
		this.nombre=nombre;
		this.f=f;
	}
	
	public String getNombre(){
		return nombre;
	}
	public double getSalida(){
		return valor;
	}
	public double getFrecuencia(){
		return f;
	}

}
