package colaConPrioridadesTDA;

public class ColaPrioridad implements ColaTDA{
    class Elemento{
        int valor;
        int prioridad;
    }

    Elemento[] elementos;
    int indice;


    @Override
    public void InicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        int j = indice;

        for (; j > 0 && elementos[j-1].prioridad >= prioridad; j--) {
            elementos[j] = elementos[j-1];
        }
        elementos[j]= new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        indice++;
    }

    @Override
    public void Desacolar() {
        elementos[indice-1] = null;
        indice--;
    }

    @Override
    public int Primero() {
        return elementos[indice-1].valor;
    }

    @Override
    public boolean ColaVacia() {
        return (indice == 0);
    }

    @Override
    public int Prioridad() {
        return elementos[indice-1].prioridad;
    }
}

/*ANALISIS DE COSTO

- InicializarCola(): O(1)
La inicializacion de un arreglo de tamaño fijo y la asignación de un valor a una variable son operaciones constantes.

- AcolarPrioridad(int x, int prioridad): O(n)
La inserción de un elemento en la cola requiere desplazar otros elementos para mantener el orden de prioridad, lo que en el peor caso implica mover todos los elementos ya presentes.

-Desacolar(): O(1)
Simplemente eliminar el último elemento en la cola es una operación constante, ya que no requiere reordenar ni desplazar elementos.

-Primero(): O(1)
Acceder al valor del último elemento en el arreglo es una operación constante.

- ColaVacia(): O(1)
La comprobación de si un arreglo está vacío es una operación constante.

- Prioridad(): O(1)
Acceder al valor de la prioridad del último elemento en el arreglo es una operación constante.
 */
