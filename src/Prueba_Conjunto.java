// Interfaz Conjunto
// Cumple con lo descrito en el PDF. Solo hace falta implementar los comentarios.

interface Conjunto<T> {
    void agregar(T elemento);
    boolean pertenece(T elemento);
    int num_elem();
    void union(Conjunto<T> otro_conjunto);
    T[] devolver_arreglo();
    String toString();
}


// Implementación de Conjunto con Array
class Conjunto_Array<T> implements Conjunto<T> {
    private T[] elementos;
    private int contador;

    @SuppressWarnings("unchecked")
    public Conjunto_Array() {
        elementos = (T[]) new Object[100];
        contador = 0;
    }

    public void agregar(T elemento) {
        if (!pertenece(elemento)) {
            if (contador < elementos.length) {
                elementos[contador++] = elemento;
            }
        }
    }

    public boolean pertenece(T elemento) {
        for (int i = 0; i < contador; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int num_elem() {
        return contador;
    }

    public void union(Conjunto<T> otro_conjunto) {
        T[] arr = otro_conjunto.devolver_arreglo();
        for (T elem : arr) {
            agregar(elem);
        }
    }

    public T[] devolver_arreglo() {
        return java.util.Arrays.copyOf(elementos, contador);
    }

    public String toString() {
        return java.util.Arrays.toString(java.util.Arrays.copyOf(elementos, contador));
    }
}

// Implementación de Conjunto con ArrayList
class Conjunto_ArrayList<T> implements Conjunto<T> {
    private java.util.ArrayList<T> elementos;

    public Conjunto_ArrayList() {
        elementos = new java.util.ArrayList<>();
    }

    public void agregar(T elemento) {
        if (!pertenece(elemento)) {
            elementos.add(elemento);
        }
    }

    public boolean pertenece(T elemento) {
        return elementos.contains(elemento);
    }

    public int num_elem() {
        return elementos.size();
    }

    public void union(Conjunto<T> otro_conjunto) {
        for (T elem : otro_conjunto.devolver_arreglo()) {
            agregar(elem);
        }
    }

    @SuppressWarnings("unchecked")
    public T[] devolver_arreglo() {
        T[] arr = (T[]) new Object[elementos.size()];
        return elementos.toArray(arr);
    }

    public String toString() {
        return elementos.toString();
    }
}

// Clase para probar las implementaciones
public class Prueba_Conjunto {
    public static void main(String[] args) {
        Conjunto<Integer> c1 = new Conjunto_Array<>();
        Conjunto<Integer> c2 = new Conjunto_ArrayList<>();

        // Aquí puedes añadir lógica para poblar y probar los conjuntos
        // Por ejemplo, agregar elementos y luego hacer una unión
    }
}
