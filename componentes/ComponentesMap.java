package componentes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ComponentesMap implements IComponentes{

	private Map<String,Componente> mapa; 
	
	public ComponentesMap(){
		 mapa= new HashMap<String,Componente>();
	}
	
	public int size() {
		return mapa.size();
	}

	public String[] getNombresComponentes() {
		String[] nombres=new String[mapa.size()];
		int i=0;
		
		Set<String> claves = mapa.keySet();
		Iterator<String> it= claves.iterator();
		
		 while(it.hasNext()){
			    String comp=it.next();
					nombres[i]=comp;
					i++;
			 }
		return nombres;
		/*
		 * Set<String> keys = mapa.keySet();
		String[] names_arr = keys.toArray(new String[keys.size()]);
		return names_arr;
		 * */
	}

	public Componente[] getComponentes() {
		Componente[] aux=null;
		Set<Componente> valor = (Set<Componente>)mapa.values();
		Iterator <Componente> it= valor.iterator();
		
		if(mapa.size()>0){
			aux= new Componente[mapa.size()];
			int i=0;
			while(it.hasNext()){
				
				Componente ref=it.next();
				aux[i]=ref;
				i++;
			}
		}
		return aux;
		/*Componente[] comps = new Componente[mapa.size()];
		
		int index = 0;
		Iterator<Componente> it = mapa.values().iterator();

		while (it.hasNext()) {
			comps[index] = it.next();
			index++;
		}

		//comps = this.mapa.values().toArray();
		return comps;
		 */
	}

	public Componente getComponente(String nombre) {
		Componente comp=null;
		if(nombre!=null && !nombre.equals("")){
		    comp=mapa.get(nombre);
		}
		return comp;
	}

	public Componente delComponente(String nombre) {
		//Componente comp=null;
		Componente comp=null;
		if(nombre!=null && !nombre.equals("")){
			Componente c=mapa.get(nombre);
		  //  comp=mapa.get(nombre);
			comp=c;
		    mapa.remove(nombre);
		}
		return comp;
	}

	
	public boolean addComponente(Componente c) {
		boolean res=false;
		
		if(c!=null){
			if(mapa.put(c.getNombre(),c)!=null){
			    res=true;
			}
		}
		return res;
	}
	
	

}
