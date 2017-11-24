
/** 
 * Clase que emula un generador de señal triangular 
 * 
 * @author Eric Martin León UPM
 * @version 1.1
 */

package generadores;

public class GeneradorSeñalTriangular extends GeneradorSeñal {

	private int t;
	/**
	  Constructor de la clase alumno
	  @param nombre es el nombre completo del genrador. No puede estar vacío. 
	  @param f es la frecuencia que se utiliza para representar.
	 */	
	public GeneradorSeñalTriangular(String nombre, double f) {
		super(nombre,f);
		t=0;
	}
	/**
	 * Nos aporta el resultado de la grafica triangular 
	 * en un instante predeterminado
	 */
	public double getSalida(){
		double resultado=0;
		
		if((0<t) && (t<((1/f)/4))){
			
			resultado=4*t/(1/f);
		}
		if(t>((1/f)/4) && (t<(3*(1/f)/4))){
			
			resultado=2-4*t/(1/f);
		}
		if((t>(3*(1/f)/4)) && (t<(1/f))){
			resultado=-4+(4*t/(1/f));
		}
		t++;
		if(t>(1/f)){
			t=0;
		}
		return resultado;
	}

}
