package conjuntoTDA;

public class Conjunto implements ConjuntoTDA {
  

  int [] a; //declaro  el arreglo para almacenar el conjunto
  int cantidad; //cantidad de elementos en el conjunto

  public void InicializarConjunto(){
    a = new int[100]; 
    cantidad = 0;
  }

  public boolean Pertenece(int x) {
    int i = 0;
    while (i < cantidad && a[i] !=x){
      i++;
    }
    return (i < cantidad);
  }

  public void Agregar(int x){
    if (!this.Pertenece(x)){ // verifico que el elemento no este en el conjunto
      a[cantidad] = x;
      cantidad++;  
      }
  }

  public void Sacar(int x){
    int i=0;
    while (i < cantidad && a[i] != x) {
      i++;
    }
    if  (i < cantidad) { // si lo encontró, elimino el elemento
      a[i] = a[cantidad - 1];
      cantidad --;
    }
  }


  public boolean ConjuntoVacio(){
    return (cantidad ==0);
  }

  public int Elegir(){
    return a[cantidad -1]; //Esto es arbitrario
  }
  
}

/*ANALISIS DE COSTO

- InicializarConjunto() = O(1)
La operación consiste en la asignación de un nuevo arreglo de tamaño fijo (100 elementos) y la inicialización de una variable cantidad. 
Ambas son operaciones elementales que se ejecutan una sola vez y no dependen del tamaño del arreglo ni del número de elementos. Por lo tanto, el tiempo de ejecución es constante.

-Pertenece(int x) = O(n)
El método busca el elemento x en el arreglo. En el peor caso, el elemento no está presente y el bucle debe recorrer todo el arreglo, resultando en un costo lineal.

-Agregar(int x) = O(n)
La operación principal es la verificación de si el elemento ya está en el conjunto mediante el método Pertenece(x), que tiene un costo O(n) en el peor caso (cuando el elemento no está en el conjunto y se debe recorrer todo el arreglo).
La asignación y el incremento de cantidad son operaciones constantes, pero el costo dominante es la llamada a Pertenece(x).

-Sacar(int x) = O(n)
El bucle while recorre el arreglo para encontrar el elemento x, lo que puede tomar hasta O(n) operaciones en el peor caso (cuando x no está presente o está al final del arreglo). 
La reasignación del último elemento al lugar de x y el decremento de cantidad son operaciones constantes, pero el costo dominante es la búsqueda en el bucle.

 -ConjuntoVacio() = O(1) 
La operación compara el valor de cantidad con cero, lo cual es una operación constante que no depende del tamaño del conjunto.

-Elegir() = O(1) 
El acceso al último elemento del arreglo es una operación de tiempo constante, ya que se trata de una sola operación de acceso a un arreglo y retorno del valor.
*/
