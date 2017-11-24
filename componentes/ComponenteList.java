package componentes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponenteList implements  IComponentes{

	private List<Componente> lista; 
	
	public ComponenteList (){
		lista= new ArrayList<Componente>(); 
	}
	
	public int size(){
		return lista.size();
	}
	
	public String[] getNombresComponentes(){
		
		String [] nombres = new String[lista.size()];
		Iterator<Componente> it=lista.iterator();
	
	    int i=0;
		 while(it.hasNext()){
			    Componente comp=it.next();
					nombres[i]=comp.getNombre();
					i++;
			 }
		return nombres;
	}
	
	public Componente[] getComponentes(){
		Componente[] aux= null;
		Iterator<Componente> it=lista.iterator();
		int i=0;
		
		if(lista.size()>0){
		  aux=new Componente[lista.size()];
			  while(it.hasNext()){
					Componente comp=it.next();
						aux[i]=comp;
						i++;
				}
		}
		return aux;
		
	}
	
	public Componente getComponente(String nombre){
        Iterator<Componente> it=lista.iterator();
        Componente aux= null;
        
		while(it.hasNext()){
			Componente comp=it.next();
				if(nombre.equals(comp.getNombre())){
					aux=comp;
				}
		}
	    return aux;
	}
	
	public Componente delComponente(String nombre){
		 Iterator<Componente> it=lista.iterator();
	        Componente aux= null;
	        
			while(it.hasNext()){
				Componente comp=it.next();
					if(nombre.equals(comp.getNombre())){
						aux=comp;
						it.remove();
					}
			}
		    return aux;
	}
	
	public boolean addComponente(Componente c){	
		boolean res=false;
		
			if(c!=null && equals(c)==false){
				lista.add(c);
				res=true;
			}
		 return res;
	}
	public boolean equals(Componente c){
		boolean res=false;
		 Iterator<Componente> it=lista.iterator();
		 
		 while(it.hasNext()){
				Componente comp=it.next();
					if(c.getNombre().equals(comp.getNombre())){
						res=true;
					}
			}
		return res;
	}
	
}
