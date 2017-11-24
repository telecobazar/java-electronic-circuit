package componentes;

public interface  IComponentes {

	public int size();
	
	public String[] getNombresComponentes();
	
	public Componente[] getComponentes();
	
	public Componente getComponente(String nombre);
	
	public Componente delComponente(String nombre);
	
	public boolean addComponente(Componente c);
	
}
