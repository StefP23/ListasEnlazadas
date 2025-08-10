package med_pro;
import java.util.Scanner;

public class Pro_Nod {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	    try {
	        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
	    } catch (Exception e) {
	    }

	    while (true) {
	        System.out.println("\n");
	        System.out.println("          Trabajando con Nodos  ");
	        System.out.println("============================================");
	        System.out.println("                  Menu");
	        System.out.println("============================================");
	        System.out.printf("%-5s %s%n", "1.", "Agregar un nodo al inicio de la lista");
	        System.out.printf("%-5s %s%n", "2.", "Suprimir un nodo de la lista");
	        System.out.printf("%-5s %s%n", "3.", "Ordenar los elementos de la lista");
	        System.out.printf("%-5s %s%n", "4.", "Agregar un nodo al final de la lista");
	        System.out.printf("%-5s %s%n", "5.", "Listar todos los elementos de la lista");
	        System.out.printf("%-5s %s%n", "6.", "Vaciar la lista completa");
	        System.out.printf("%-5s %s%n", "7.", "Salir");
	        System.out.println("============================================");

	        int opcion = -1;
	        boolean entradaValida = false;

	        while (!entradaValida) {
	            System.out.print("Seleccione una opcion: ");
	            if (scanner.hasNextInt()) {
	                opcion = scanner.nextInt();
	                scanner.nextLine(); // Limpiar el buffer
	                entradaValida = true;
	            } else {
	                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
	                scanner.nextLine(); // Limpiar el buffer para evitar bloqueo
	            }
	        }
	        switch (opcion) {
	            case 1:
	                agregar_nodo();
	                break;
	            case 2:
	                eliminar_nodo();
	                break;
	            case 3:
	                ordenar_nodo();
	                break;
	            case 4:
	                agregar_nodo_final();
	                break;
	            case 5:
	                listar_nodo();
	                break;
	            case 6:
	                vaciar_nodo();
	                break;
	            case 7:
	                System.out.println("Saliendo del programa...");
	                System.exit(0);
	            default:
	                System.out.println("Opcion invalida. Intente nuevamente.\n");
	        }
	    }
	}

	
	// Clase Nodo que representa un nodo de la lista enlazada
	static class Nodo {
	    int dato;
	    Nodo siguiente;

	    public Nodo(int dato) {
	        this.dato = dato;
	        this.siguiente = null;
	    }
	}
	
	// Referencia a la cabeza de la lista
	public static Nodo cabeza = null;
	private static void agregar_nodo() {
		int nuevoDato;

		// Bucle para solicitar un valor valido al usuario
		while (true) {
	        System.out.print("Ingrese el valor del nodo: ");
	        if (scanner.hasNextInt()) {
	            nuevoDato = scanner.nextInt();
	            scanner.nextLine(); 					
	            break; 									
	        } else {
	            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
	            scanner.nextLine(); 					
	        }
	    }
		
		// Crear un nuevo nodo con el dato ingresado
	    // Enlaza el nodo al inicio de la lista
	    Nodo nuevoNodo = new Nodo(nuevoDato);
	    nuevoNodo.siguiente = cabeza; 			             
	    cabeza = nuevoNodo; 								 

	    System.out.println("Nodo agregado correctamente.\n");
	
	}

	// Metodo para eliminar un nodo de la lista
	private static void eliminar_nodo() {
	    if (cabeza == null) {
	        System.out.println("La lista esta vacia. No hay nodos para eliminar.");
	        return;
	    }
	    
		// Solicitar al usuario el valor del nodo a eliminar
	    int valorEliminar;
	    while (true) {
	        System.out.print("Ingrese el valor del nodo a eliminar: ");
	        if (scanner.hasNextInt()) {
	            valorEliminar = scanner.nextInt();
	            scanner.nextLine(); 		// Limpiar el buffer del scanner
	            break;
	        } else {
	            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
	            scanner.nextLine(); 		// Limpiar la entrada incorrecta
	        }
	    }

	    // Caso: eliminar la cabeza
	    if (cabeza.dato == valorEliminar) {
	        cabeza = cabeza.siguiente;
	        System.out.println("Nodo eliminado correctamente.\n");
	        return;
	    }

	    // Caso: eliminar un nodo intermedio o final
	    Nodo actual = cabeza;
	    Nodo anterior = null;

	    while (actual != null && actual.dato != valorEliminar) {
	        anterior = actual;
	        actual = actual.siguiente;
	    }

	    if (actual == null) {
	        System.out.println("El nodo con el valor ingresado no existe en la lista.\n");
	    } else {
	        anterior.siguiente = actual.siguiente; // Desvincular el nodo de la lista
	        System.out.println("Nodo eliminado correctamente.\n");
	    }
	}
	
	// Metodo para ordenar los nodos de la lista
	private static void ordenar_nodo() {
		 if (cabeza == null || cabeza.siguiente == null) {
		        System.out.println("La lista esta vacia o tiene solo un nodo. No hay nada que ordenar.\n");
		        return;
		    }
		 
			// Bucle para ordenar la lista usando el metodo burbuja
		    // Este metodo compara los datos de los nodos y los intercambia si estan en el orden incorrecto
		    boolean cambiado;
		    do {
		        cambiado = false;
		        Nodo actual = cabeza;
		        while (actual.siguiente != null) {
		            if (actual.dato > actual.siguiente.dato) {
		                int temp = actual.dato;					// Intercambiar valores (no nodos, solo datos)
		                actual.dato = actual.siguiente.dato;
		                actual.siguiente.dato = temp;
		                cambiado = true;
		            }
		            actual = actual.siguiente;
		        }
		    } while (cambiado);

		    System.out.println("Lista ordenada correctamente.\n");
	
	}
	
	// Metodo para agregar un nodo al final de la lista
	private static void agregar_nodo_final() {
		 int nuevoDato;

		    while (true) {
		        System.out.print("Ingrese el valor del nodo: ");
		        if (scanner.hasNextInt()) {
		            nuevoDato = scanner.nextInt();
		            scanner.nextLine(); 						// Limpiar el buffer del scanner
		            break;
		        } else {
		            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
		            scanner.nextLine(); 						// Limpiar la entrada incorrecta
		        }
		    }
			
		    Nodo nuevoNodo = new Nodo(nuevoDato);

			// Enlaza el nuevo nodo al final de la lista
		    if (cabeza == null) {
		        cabeza = nuevoNodo;
		    } else {
		        Nodo actual = cabeza;
		        while (actual.siguiente != null) {
		            actual = actual.siguiente;
		        }
		        actual.siguiente = nuevoNodo;
		    }

		    System.out.println("Nodo agregado al final correctamente.\n");
	}
	
	// Metodo para listar todos los nodos de la lista	
	private static void listar_nodo() {
	    if (cabeza == null) {
	        System.out.println("La lista está vacía.");
	        return;
	    }

	    Nodo actual = cabeza;
	    System.out.println("Elementos en la lista:");
	    while (actual != null) {
	        System.out.print(" " + actual.dato + " -> ");
	        actual = actual.siguiente;
	    }
	    System.out.println("Fin de la lista.\n");
	}

		// Metodo para vaciar la lista completa
	private static void vaciar_nodo() {
	    cabeza = null;										
	    System.out.println("La lista ha sido vaciada.\n");
	}
}
