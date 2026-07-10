package capitulo1;

public class PesquisaBinariaNumeros {
  public static void main(String[] args) {

    int[] minhaLista = {1, 3, 5, 7, 9};

    System.out.println("Posição do valor desejado: " + pesquisaBinaria(minhaLista, 3));
    System.out.println("Retorno ao enviar parâmetro inválido: " + pesquisaBinaria(minhaLista, -1));
  }

  private static Integer pesquisaBinaria(int[] lista, Integer item) {

    if (lista == null || item == null) {
      return null;
    }

    int baixo = 0;
    int alto = lista.length - 1;

    while (baixo <= alto) {

      int meio = baixo + (alto - baixo) / 2;
      int chute = lista[meio];

      if (chute == item) {
        return meio;
      }

      if (chute > item) {
        alto = meio - 1;
      } else {
        baixo = meio + 1;
      }
    }
    return null;
  }
}
