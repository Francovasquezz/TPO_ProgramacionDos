package conjuntoTDA;

public class Conjunto implements ConjuntoTDA {
  

  int [] a; //declaro  el arreglo para almacenar el conjunto
  int cantidad; //cantidad de elementos en el conjunto

  public void InicializarConjunto(){
    a = new int[100]; 
    cantidad = 0;
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

  public boolean Pertenece(int x) {
    int i = 0;
    while (i < cantidad && a[i] !=x){
      i++;
    }
    return (i < cantidad);
  }

  public boolean ConjuntoVacio(){
    return (cantidad ==0);
  }

  public int Elegir(){
    return a[cantidad -1]; //Esto es arbitrario
  }
  
}
