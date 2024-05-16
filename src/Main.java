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
