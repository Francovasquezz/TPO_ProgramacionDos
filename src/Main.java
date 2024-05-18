import colaConPrioridadesTDA.*;
import conjuntoTDA.*;

public class Main {
    public static void main(String[] args) {

        Conjunto conjuntoEmpresa = new Conjunto();
        Conjunto conjuntoParticularCliente = new Conjunto();
        Conjunto conjuntoParticularNoCliente = new Conjunto();

        conjuntoEmpresa.InicializarConjunto();
        conjuntoParticularCliente.InicializarConjunto();
        conjuntoParticularNoCliente.InicializarConjunto();

        ColaPrioridad cola = new ColaPrioridad();
        cola.InicializarCola();

        cola.AcolarPrioridad(101, 1);
        cola.AcolarPrioridad(102, 2);
        cola.AcolarPrioridad(103, 1);
        cola.AcolarPrioridad(104, 3);
        cola.AcolarPrioridad(105, 2);
        cola.AcolarPrioridad(106, 1);
        cola.AcolarPrioridad(107, 3);
        cola.AcolarPrioridad(108, 2);
        cola.AcolarPrioridad(109, 1);
        cola.AcolarPrioridad(110, 3);
        cola.AcolarPrioridad(111, 2);
        cola.AcolarPrioridad(112, 1);
        cola.AcolarPrioridad(113, 3);
        cola.AcolarPrioridad(114, 2);
        cola.AcolarPrioridad(115, 1);

        // Creamos una copia de la cola para no modificar la original
        ColaPrioridad copiaCola = new ColaPrioridad();
        copiaCola.InicializarCola();

        // Copiamos los elementos de la cola original a la copia
        while (!cola.ColaVacia()) {
            int elemento = cola.Primero();
            int prioridad = cola.Prioridad();
            copiaCola.AcolarPrioridad(elemento, prioridad);
            cola.Desacolar();
            System.out.println("Elemento: " + elemento + ", Prioridad: " + prioridad);
        }

        while (!copiaCola.ColaVacia()) {
            int identificador = copiaCola.Primero();
            int prioridad = copiaCola.Prioridad();
            switch (prioridad) {
                case 1:
                    conjuntoEmpresa.Agregar(identificador);
                    break;
                case 2:
                    conjuntoParticularCliente.Agregar(identificador);
                    break;
                case 3:
                    conjuntoParticularNoCliente.Agregar(identificador);
                    break;
            }
            copiaCola.Desacolar();
        }
        System.out.println();
        System.out.println("Clientes que son empresas: ");
        while (!conjuntoEmpresa.ConjuntoVacio()) {
            int elemento = conjuntoEmpresa.Elegir();
            System.out.print(elemento + " ");
            conjuntoEmpresa.Sacar(elemento);
        }
        System.out.println();
        System.out.println("\nClientes que son particulares: ");
        while (!conjuntoParticularCliente.ConjuntoVacio()) {
            int elemento = conjuntoParticularCliente.Elegir();
            System.out.print(elemento + " ");
            conjuntoParticularCliente.Sacar(elemento);
        }
        System.out.println();
        System.out.println("\nClientes que no son particulares: ");
        while (!conjuntoParticularNoCliente.ConjuntoVacio()) {
            int elemento = conjuntoParticularNoCliente.Elegir();
            System.out.print(elemento + " ");
            conjuntoParticularNoCliente.Sacar(elemento);
        }
    }
}

/*ANALISIS DE COSTO

-Inicialización de Conjuntos y Colas = O(1)
Cada llamada a InicializarConjunto() y InicializarCola() es una operación constante O(1), ya que simplemente asignan memoria y establecen variables iniciales.

-Acolar elementos en la cola = O(n)
Tiene un costo O(n) en el peor caso porque puede necesitar desplazar todos los elementos en la cola para mantener el orden de prioridad.

-Copiar la cola original a la cola de copia = O(n^2) 
El bucle se ejecuta 15 veces, y cada vez se llama a AcolarPrioridad() en copiaCola, lo que toma O(n) tiempo cada vez. 
Por lo tanto, el costo total para esta sección es O(n^2) en el peor caso debido a las 15 iteraciones y el desplazamiento potencial de elementos en cada llamada a AcolarPrioridad().

-Distribuir elementos de copiaCola en los conjuntos = O(n^2) 
El bucle se ejecuta 15 veces, y cada vez se llama a Agregar(), que toma O(n) tiempo cada vez. 
Por lo tanto, el costo total para esta sección es O(n^2) en el peor caso.

-Imprimir los elementos de cada conjunto = O(n^2) 
Cada bucle se ejecuta hasta que el conjunto esté vacío, lo cual puede tomar hasta n iteraciones en el peor caso. 
Sacar() toma O(n) tiempo cada vez, resultando en un costo total de O(n^2) para cada conjunto.

*/
