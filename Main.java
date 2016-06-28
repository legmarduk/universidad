
package Clases;

import java.util.Scanner;

import java.util.Random;

public class Main {

	private static Random NumeroRandom = new Random();
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		
		ArbolBinario ABin= new ArbolBinario();
		ArbolBinario ABsim= new ArbolBinario();
		int Numeronodos,Op,bus,recor,nodens;
		
		System.out.print("ingresa el numero de nodos");
		Numeronodos=s.nextInt();
		
		int Vector[] = new int [Numeronodos];
				
		for(int i=0;i<Numeronodos;i++){
			nodens=NumeroRandom.nextInt(150);
		   Vector[i]=nodens;
			ABin.Insertar_Nodo(nodens);
		    System.out.println(" "+nodens);
		}
		
		
		
		do{
			
				System.out.println("1 Buscar nodo");
                System.out.println("2 Eliminar nodo");
                System.out.println("3 arbol lleno");
				System.out.println("4 recorridos");
				System.out.println("5 anchura");
				System.out.println("6 arbol simetrico");
				Op=s.nextInt();
				
				switch(Op){
				
				case 1: //buscar
				
				if(!ABin.EstaVacío()){
				   System.out.print("Ingresa El Valor A Buscar: ");
				   bus=s.nextInt();
					ABin.Buscar_Nodo(bus);
					if(ABin.Buscar_Nodo(bus)==null){
						System.out.println("No Existe El Nodo En El Árbol");
					}
					else{
						System.out.println("Se Ha Encontrado El Nodo");			
					}
				}
				
					 	break;
				case 2://eliminar
                     
					if(!ABin.EstaVacío()){
						System.out.println("Ingresa El Valor A Eliminar: ");
						bus=s.nextInt();
						if(!ABin.Eliminar_Nodo(bus)){
							System.out.println("No Existe nodo");			
						}
						else{
							System.out.println("Se Ha Eliminado El Nodo");		
						}
					}
					else{
						System.out.println("no se puede eliminar mas,arbol vacio\n");
					}
					break;
					
					
				case 3://arbol lleno
					boolean l;
					
					l=ABin.ALleno(Numeronodos);
					if(l==true){
						System.out.println("el arbol esta LLENO");
					}else{
						System.out.println("el arbol NO esta lleno");
					}
					
					
					break;
					
					
				case 4://VER RECORRIDOS
					
					
					
					do{
								System.out.println("1 InOrden");
								System.out.println("2 PreOrden");
								System.out.println("3 PostOrden");
								System.out.println("4 o mayor para salir");
								recor=s.nextInt();
								switch(recor){		
					             case 1: //inorden
						          ABin.Recorrido_InOrden(ABin.Raiz);
						           break;
				                	case 2://preorden
							   ABin.Recorrido_PreOrden(ABin.Raiz);
						           break;
					             case 3://posorden
							    ABin.Recorrido_PostOrden(ABin.Raiz);
						         break;
								}
						     
					       }while(recor>0 && recor<3);
					   						
				case 5://anchura
					break;
					
				case 6://simetrico
					for(int i=0;i<Numeronodos;i++){
						ABsim.ArbolSimetrico(Vector[i]);
					}
					ABsim.Recorrido_InOrden(ABsim.Raiz);
					break;
					
				}	
		}while(Op>0 && Op<6);
			
	
	}
}
