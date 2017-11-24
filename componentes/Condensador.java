package componentes;

public class Condensador extends Componente {
    private double salida;

	public Condensador(String nombre) {
		super(nombre);
		if(nombre==null)
			throw  new IllegalArgumentException ("Componente sin nombre");
		salida=0.0;
	}

	
	public double getSalida(double entrada)  {
		if(Math.abs(entrada)<0)
			throw  new IllegalArgumentException ("La entrada del condensador es menor que 0");
	    
		if(entrada>=0.999*salida){
			salida=entrada;
		}else if(entrada<0.999*salida){
			salida=0.999*salida;
		}
		
		return salida;
	}
}
