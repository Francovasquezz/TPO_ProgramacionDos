import colaConPrioridadesTDA.*;
import conjuntoTDA.*;

public class Main {
    public static void main(String[] args) {



        Conjunto conjuntoEntrada = new Conjunto();
        conjuntoEntrada.InicializarConjunto();

        conjuntoEntrada.Agregar(1);

        ColaPrioridad cola = new ColaPrioridad();
        cola.InicializarCola();


        }
}
