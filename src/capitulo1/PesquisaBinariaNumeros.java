package capitulo1;

public class PesquisaBinariaNumeros {
  public static void main(String[] args) {

    int[] minhaLista = {1, 3, 5, 7, 9};

    long inicio1 = System.nanoTime();
    Integer pos1 = pesquisaBinaria(minhaLista, 3);
    long fim1 = System.nanoTime();
    double tempo1Ms = (fim1 - inicio1) / 1_000_000.0;

    System.out.printf("Posição do valor desejado: %s (Tempo: %.4f ms)%n", pos1, tempo1Ms);

    long inicio2 = System.nanoTime();
    Integer pos2 = pesquisaBinaria(minhaLista, -1);
    long fim2 = System.nanoTime();
    double tempo2Ms = (fim2 - inicio2) / 1_000_000.0;

    System.out.printf("Retorno ao enviar parâmetro inválido: %s (Tempo: %.4f ms)%n", pos2,
        tempo2Ms);

    System.out.println("Sistema Operacional: " + System.getProperty("os.name"));
    System.out.println("Caminho do Java: " + System.getProperty("java.home"));
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
