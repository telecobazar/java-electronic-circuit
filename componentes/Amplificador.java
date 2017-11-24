package componentes;

public class Amplificador extends Componente {
	private double ganancia;
	
	public Amplificador(String nombre, double ganancia){
		super(nombre);
		if(nombre==null)
			throw  new IllegalArgumentException ("Componente sin nombre");
		this.ganancia=ganancia;
	}
	
	public double getSalida(double entrada) {
		return ganancia*entrada;
	}

}
