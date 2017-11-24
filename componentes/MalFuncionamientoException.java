package componentes;

public class MalFuncionamientoException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public MalFuncionamientoException(){}
	
	public MalFuncionamientoException(String msj){
		super(msj);
	}

}
