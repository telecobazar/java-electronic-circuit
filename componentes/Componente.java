package componentes;

 abstract public class Componente implements ITransferencia {
	protected String nombre;
	
	public Componente(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public String toString(){
		return "Componente[nombre="+nombre+"]";
	}
	 public abstract double getSalida(double entrada);
	 public int HashCode(){
		 return nombre.hashCode();
	 }
	 public boolean equals (Object o){
		 boolean res = false;
		 if(o instanceof Componente){
			 Componente aux=(Componente) o;
			 if(aux.getNombre().equals(nombre)){
				 res=true;
			 }
		 }
		 return res;
	 }
}
