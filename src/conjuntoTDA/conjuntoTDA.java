package conjuntoTDA;

public interface conjuntoTDA {
  void InicializarConjunto(); //sin precondiciones, inicializa el conjunto
  boolean Pertenece(int x); // conjunto inicializado, devuelve True si pertenece al conjunto
  void Agregar(int x); // conjunto inicializado, agrega un elemento  al conjunto 
  void Sacar(int x); // conjunto inicializado,  elimina un elemento del conjunto
  boolean ConjuntoVacio(); // conjunto inicializado, devuelve true si el conjunto está vacio.
  int Elegir(); // conjunto inicializado y que no este vacio , devuelvo un valor aleatorio del conjunto
}
