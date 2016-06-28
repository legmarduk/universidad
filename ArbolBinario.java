package Clases;

public class ArbolBinario {

	Nodo Raiz;
	
	public ArbolBinario(){
		Raiz=null;
	}
	
	public void Insertar_Nodo(int Key){
		
		Nodo NuevoNodo = new Nodo(Key);
		
		if(Raiz==null){
			Raiz=NuevoNodo;
		}
		else{
			Nodo Auxiliar=Raiz;
			Nodo Padre;
			while(true){
				Padre=Auxiliar;
				if(Key<Auxiliar.Dato){
					Auxiliar=Auxiliar.HijoIzquierdo;
					if(Auxiliar==null){
						Padre.HijoIzquierdo=NuevoNodo;
						return;
					}
				}
				else{
					Auxiliar=Auxiliar.HijoDerecho;
					if(Auxiliar==null){
						Padre.HijoDerecho=NuevoNodo;
						return;
					}
				}
			}
		}
	}
	
	public boolean EstaVacío(){
		return Raiz==null;
	}
	
	public void Recorrido_InOrden(Nodo R){
		if(R!=null){
			Recorrido_InOrden(R.HijoIzquierdo);
			System.out.print(R.Dato+"\n  ");
			System.out.println("\n");
			Recorrido_InOrden(R.HijoDerecho);
		}
	}
	
	public void Recorrido_PreOrden(Nodo R){
		if(R!=null){
			System.out.print(R.Dato+"\n  ");
			System.out.println("\n");
			Recorrido_PreOrden(R.HijoIzquierdo);
			Recorrido_PreOrden(R.HijoDerecho);
		}
	}
	
	public void Recorrido_PostOrden(Nodo R){
		if(R!=null){
			Recorrido_PostOrden(R.HijoIzquierdo);
			Recorrido_PostOrden(R.HijoDerecho);
			System.out.print(R.Dato+"\n  ");
			System.out.println("\n");
		}
	}
	
	public Nodo Buscar_Nodo(int Key){
		Nodo Auxiliar=Raiz;
		while(Auxiliar.Dato!=Key){
			if(Key<Auxiliar.Dato){
				Auxiliar=Auxiliar.HijoIzquierdo;
			}
			else{
				Auxiliar=Auxiliar.HijoDerecho;
			}
			if(Auxiliar==null){
				return null;
			}
		}
		return Auxiliar;
	}
	
	public boolean Eliminar_Nodo(int Key){
		Nodo Auxiliar=Raiz;
		Nodo Padre=Raiz;
		boolean Izq=true;
		while(Auxiliar.Dato!=Key){
			Padre=Auxiliar;
			if(Key<Auxiliar.Dato){
				Izq=true;
				Auxiliar=Auxiliar.HijoIzquierdo;
			}
			else{
				Izq=false;
				Auxiliar=Auxiliar.HijoDerecho;
			}
			if(Auxiliar==null){
				return false;
			}
		}
		if(Auxiliar.HijoIzquierdo==null && Auxiliar.HijoDerecho==null){
			if(Auxiliar==Raiz){
				Raiz=null;
			}
			else if(Izq){
				Padre.HijoIzquierdo=null;
			}
			else{
				Padre.HijoDerecho=null;
			}	
		}
		else if(Auxiliar.HijoDerecho==null){
			if(Auxiliar==Raiz){
				Raiz=Auxiliar.HijoIzquierdo;
			}
			else if(Izq){
				Padre.HijoIzquierdo=Auxiliar.HijoIzquierdo;
			}
			else{
				Padre.HijoDerecho=Auxiliar.HijoIzquierdo;
			}		
		}
		else if(Auxiliar.HijoIzquierdo==null){
			if(Auxiliar==Raiz){
				Raiz=Auxiliar.HijoDerecho;
			}
			else if(Izq){
				Padre.HijoIzquierdo=Auxiliar.HijoDerecho;
			}
			else{
				Padre.HijoDerecho=Auxiliar.HijoIzquierdo;
			}				
		}
		else{
			Nodo Reemplazo=Obtener_Reemplazante(Auxiliar);
			if(Auxiliar==Raiz){
				Raiz=Reemplazo;	
			}
			else if(Izq){
				Padre.HijoIzquierdo=Reemplazo;
			}
			else{
				Padre.HijoDerecho=Reemplazo;
			}
			Reemplazo.HijoIzquierdo=Auxiliar.HijoIzquierdo;
		}
		return true;
	}
	
	public Nodo Obtener_Reemplazante(Nodo Cambio){
		Nodo ReemplazarPadre=Cambio;
		Nodo Reemplazo=Cambio;
		Nodo Auxiliar=Cambio.HijoDerecho;
		while(Auxiliar!=null){
			ReemplazarPadre=Reemplazo;
			Reemplazo=Auxiliar;
			Auxiliar=Auxiliar.HijoIzquierdo;
		}
		if(Reemplazo!=Cambio.HijoDerecho){
			ReemplazarPadre.HijoIzquierdo=Reemplazo.HijoDerecho;
			Reemplazo.HijoDerecho=Cambio.HijoDerecho;
		}
		System.out.println("El Nodo Reemplazo es: "+Reemplazo);
		return Reemplazo;
	}

	
	
	public boolean ALleno(int val1){
		
		if(val1%2==0)return false;
		else return true;
	}
	
	
	public void ArbolSimetrico(int Key){
   
		Nodo NuevoSim = new Nodo(Key);
		
		if(Raiz==null){
			Raiz=NuevoSim;
		}
		else{
			Nodo Auxiliar=Raiz;
			Nodo Padre;
			while(true){
				Padre=Auxiliar;
				if(Key<Auxiliar.Dato){
					Auxiliar=Auxiliar.HijoDerecho;
					if(Auxiliar==null){
						Padre.HijoDerecho=NuevoSim;
						return;
					}
				}
				else{
					Auxiliar=Auxiliar.HijoIzquierdo;
					if(Auxiliar==null){
						Padre.HijoIzquierdo=NuevoSim;
						return;
					}
				}
			}
		}
	}
		
	
	
	
	
}























