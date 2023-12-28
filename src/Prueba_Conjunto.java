// Interfaz Conjunto
// Define los métodos esenciales de un conjunto genérico.
import java.util.Scanner;

interface Conjunto<T> {
    // Agrega un elemento al conjunto.
    void agregar(T elemento);

    // Verifica si un elemento pertenece al conjunto.
    boolean pertenece(T elemento);

    // Devuelve el número de elementos en el conjunto.
    int num_elem();

    // Realiza la unión de este conjunto con otro.
    void union(Conjunto<T> otro_conjunto);

    // Devuelve los elementos del conjunto en forma de arreglo.
    T[] devolver_arreglo();

    // Devuelve una representación en cadena del conjunto.
    String toString();

}

// Implementación de Conjunto utilizando un array.
class Conjunto_Array<T> implements Conjunto<T> {
    private T[] elementos; // Almacena los elementos del conjunto.
    private int contador;  // Contador para la cantidad de elementos actuales.

    @SuppressWarnings("unchecked")
    public Conjunto_Array() {
        elementos = (T[]) new Object[100]; // Inicialización con capacidad de 100.
        contador = 0; // Inicialización del contador.
    }

    // Agrega un elemento al conjunto si no está presente.
    public void agregar(T elemento) {
        if (!pertenece(elemento)) {
            if (contador < elementos.length) {
                elementos[contador++] = elemento;
            }
        }
    }

    // Verifica si un elemento está en el conjunto.
    public boolean pertenece(T elemento) {
        for (int i = 0; i < contador; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    // Devuelve la cantidad de elementos en el conjunto.
    public int num_elem() {
        return contador;
    }

    // Agrega los elementos de otro conjunto a este conjunto.
    public void union(Conjunto<T> otro_conjunto) {
        T[] arr = otro_conjunto.devolver_arreglo();
        for (T elem : arr) {
            agregar(elem);
        }
    }

    // Devuelve una copia del arreglo de elementos.
    public T[] devolver_arreglo() {
        return java.util.Arrays.copyOf(elementos, contador);
    }

    // Devuelve una representación en cadena de los elementos del conjunto.
    public String toString() {
        return java.util.Arrays.toString(java.util.Arrays.copyOf(elementos, contador));
    }
}

// Implementación de Conjunto utilizando ArrayList.
class Conjunto_ArrayList<T> implements Conjunto<T> {
    private java.util.ArrayList<T> elementos; // Almacena los elementos del conjunto.

    public Conjunto_ArrayList() {
        elementos = new java.util.ArrayList<>(); // Inicialización del ArrayList.
    }

    // Agrega un elemento al conjunto si no está presente.
    public void agregar(T elemento) {
        if (!pertenece(elemento)) {
            elementos.add(elemento);
        }
    }

    // Verifica si un elemento está en el conjunto.
    public boolean pertenece(T elemento) {
        return elementos.contains(elemento);
    }

    // Devuelve la cantidad de elementos en el conjunto.
    public int num_elem() {
        return elementos.size();
    }

    // Agrega los elementos de otro conjunto a este conjunto.
    public void union(Conjunto<T> otro_conjunto) {
        for (T elem : otro_conjunto.devolver_arreglo()) {
            agregar(elem);
        }
    }

    // Devuelve una copia del arreglo de elementos del ArrayList.
    @SuppressWarnings("unchecked")
    public T[] devolver_arreglo() {
        T[] arr = (T[]) new Object[elementos.size()];
        return elementos.toArray(arr);
    }

    // Devuelve una representación en cadena de los elementos del conjunto.
    public String toString() {
        return elementos.toString();
    }
}

// Clase principal para probar las implementaciones de los conjuntos.
public class Prueba_Conjunto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación de dos conjuntos con diferentes implementaciones.
        Conjunto<Integer> c1 = new Conjunto_Array<>();
        Conjunto<Integer> c2 = new Conjunto_ArrayList<>();

        // Lectura y adición de elementos al conjunto c1.
        System.out.println("Introduce los elementos para el conjunto c1 (Conjunto_Array), separados por espacios:");
        String[] elementosC1 = scanner.nextLine().split(" ");
        for (String elem : elementosC1) {
            c1.agregar(Integer.parseInt(elem));
        }

        // Lectura y adición de elementos al conjunto c2.
        System.out.println("Introduce los elementos para el conjunto c2 (Conjunto_ArrayList), separados por espacios:");
        String[] elementosC2 = scanner.nextLine().split(" ");
        for (String elem : elementosC2) {
            c2.agregar(Integer.parseInt(elem));
        }

        // Realización de la unión de los conjuntos c1 y c2.
        c1.union(c2);

        // Impresión de los conjuntos después de la unión.
        System.out.println("Conjunto c1 (Conjunto_Array) después de la unión: " + c1 + " Total de elementos: " + c1.num_elem());
        System.out.println("Conjunto c2 (Conjunto_ArrayList): " + c2 + " Total de elementos: " + c2.num_elem());
    }
}
