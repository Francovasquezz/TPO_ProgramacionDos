package colaConPrioridadesTDA;

public interface ColaTDA {
    void InicializarCola(); //sin precondiciones, inicializa la cola

    void AcolarPrioridad(int x, int prioridad); //cola inicializada, agrega un elemento a la cola con prioridad

    void Desacolar(); //cola inicializada y no vacía, elimina el primer elemento de la cola

    boolean ColaVacia(); //cola inicializada, devuelve true si la cola está vacía

    int Primero(); //cola inicializada y no vacía, devuelve el primer elemento de la cola

    int Prioridad(); //cola inicializada y no vacía, devuelve la prioridad del primer elemento de la cola
}
