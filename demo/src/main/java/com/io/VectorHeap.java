package com.io;
import java.util.Vector;

/**
 * VectorHeap es una implementación de PriorityQueue que utiliza un heap
 * mínimo almacenado en un Vector para garantizar que el elemento de mayor prioridad
 * (menor según compareTo) siempre esté en la raíz.
 * 
 * @param <E> Tipo de elemento almacenado (debe ser Comparable)
 * @author Alejandro Sagastume
 * @version 1.0
 */
public class VectorHeap<E extends Comparable<E>> {

    protected Vector<E> data; // El Vector que almacena el heap

    /**
     * Constructor por defecto. Inicializa el Vector vacío.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Constructor que recibe un vector con elementos iniciales.
     * 
     * @param v Vector con elementos iniciales
     */
    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Retorna el índice del padre de un nodo.
     * @param i Índice del nodo hijo
     * @return Índice del padre
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Retorna el índice del hijo izquierdo de un nodo.
     * @param i Índice del nodo padre
     * @return Índice del hijo izquierdo
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Retorna el índice del hijo derecho de un nodo.
     * @param i Índice del nodo padre
     * @return Índice del hijo derecho
     */
    protected static int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Añade un elemento al heap y lo reordena para mantener la propiedad de heap.
     * @param value Elemento a insertar
     */
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Reordena el heap hacia arriba tras insertar un nodo.
     * @param leaf Índice del nodo insertado
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Retira y devuelve el elemento de mayor prioridad (raíz del heap).
     * @return Elemento de mayor prioridad, o null si el heap está vacío.
     */
    public E remove() {
        if (data.size() == 0) return null;
        E minVal = data.get(0);
        E lastVal = data.remove(data.size() - 1);
        if (data.size() > 0) {
            data.set(0, lastVal);
            percolateDown(0);
        }
        return minVal;
    }

    /**
     * Reordena el heap hacia abajo tras eliminar la raíz.
     * @param root Índice de inicio (debería ser 0)
     */
    protected void percolateDown(int root) {
        int child = left(root);
        E value = data.get(root);
        while (child < data.size()) {
            int right = right(root);
            if (right < data.size() && data.get(right).compareTo(data.get(child)) < 0) {
                child = right;
            }
            if (data.get(child).compareTo(value) < 0) {
                data.set(root, data.get(child));
                root = child;
                child = left(root);
            } else {
                break;
            }
        }
        data.set(root, value);
    }

    /**
     * Retorna el tamaño actual del heap.
     * @return Número de elementos en el heap
     */
    public int size() {
        return data.size();
    }

    /**
     * Verifica si el heap está vacío.
     * @return true si no hay elementos, false si hay elementos
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Devuelve el elemento de mayor prioridad sin removerlo.
     * @return Elemento en la raíz del heap o null si vacío
     */
    public E peek() {
        if (data.size() == 0) return null;
        return data.get(0);
    }
}