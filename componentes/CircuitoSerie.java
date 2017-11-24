
package componentes;
public class CircuitoSerie implements ITransferencia {
    
	private int numComponentes;
	private Componente[] componentes;
	private int maxComponentes;
	
	public CircuitoSerie(int max){
		if(0>max)
			throw  new IllegalArgumentException ("Error:crear un Circuito seria con un numero negativo de componentes");
		componentes=new Componente[max];
		numComponentes=0;
		maxComponentes=max;
	}

	public boolean isLleno(){
		boolean resultado=false;
		if(numComponentes>maxComponentes){
			resultado=true;
		}
		return resultado;
	}
	public String toString(){
		String val="";
		for(int i=0;i<componentes.length;i++){
			val=val+componentes[i].getNombre()+"\n";
		}
		return val;
	}
	
    public double getSalida(double entrada) {
		double salida=0;
		ITransferencia componente=null;
		for(int i=0;i<numComponentes;i++){
			componente=componentes[i];
			if(componente!=null){
				salida=componente.getSalida(entrada);
				entrada=salida;
			}
		}
		return salida;
	}
    
	public int size(){
		return numComponentes;
	}
	public void addComponente(Componente componente){
		int x=0;
		if(componente==null)
			throw  new IllegalArgumentException ("Componente sin nombre");
		if(numComponentes>=maxComponentes)
			throw  new IllegalArgumentException ("No se pueden añadir mas componentes");

		for(int i=0;i<componentes.length;i++){
			if(componentes[i]==null && x==0){
				componentes[i]=componente;
				numComponentes++;
				x=2;
			}
		}
	}


}
