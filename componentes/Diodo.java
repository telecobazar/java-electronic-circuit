package componentes;

public class Diodo extends Componente{

	public Diodo(String nombre) {
		super(nombre);
		if(nombre==null)
			throw  new IllegalArgumentException ("Componente sin nombre");
	}
	
	public double getSalida(double entrada) {
		double salida=0;
		if(entrada>=0){
			salida = entrada;
		}else if(entrada<0){
			salida=0;
		}
		return salida;
	}

}
