package componentes;

public class PuenteDiodos extends Componente implements ITransferencia {

	
	public PuenteDiodos(String nombre) {
		super(nombre);
		if(nombre==null)
			throw  new IllegalArgumentException ("Componente sin nombre");
		
	}

	public double getSalida(double entrada) {
		return Math.abs(entrada);
	}

}
