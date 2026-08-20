package capitulo1;

public class PesquisaBinariaNomes {
  public static void main(String[] args) {

    String[] minhaLista = {"Alice", "Bob", "Charlie", "David", "Eve"};

    String primeiroNome = "Charlie";
    long inicio1 = System.nanoTime();
    Integer posicaoPrimeiroNomePesquisado = pesquisaBinaria(minhaLista, primeiroNome);
    long fim1 = System.nanoTime();
    double tempo1Ms = (fim1 - inicio1) / 1_000_000.0;

    System.out.printf("Posição de %s: %s (Tempo: %.4f ms)%n", primeiroNome,
        (posicaoPrimeiroNomePesquisado != null ? posicaoPrimeiroNomePesquisado : "Não encontrado"),
        tempo1Ms);

    String segundoNome = "Frank";
    long inicio2 = System.nanoTime();
    Integer posicaoSegundoNomePesquisado = pesquisaBinaria(minhaLista, segundoNome);
    long fim2 = System.nanoTime();
    double tempo2Ms = (fim2 - inicio2) / 1_000_000.0;

    System.out.printf("Posição de %s: %s (Tempo: %.4f ms)%n", segundoNome,
        (posicaoSegundoNomePesquisado != null ? posicaoSegundoNomePesquisado : "Não encontrado"),
        tempo2Ms);

  }

  private static Integer pesquisaBinaria(String[] lista, String item) {

    if (lista == null || item == null) {
      return null;
    }

    /**
     * Etapa: Inicialização Frequência de execução: uma vez.
     */
    int baixo = 0;

    /**
     * Etapa: Inicialização Frequência de execução: uma vez.
     */
    int alto = lista.length - 1;

    /**
     * Etapa: condição de loop. Frequência de execução: Executada 1+log2​N vezes (onde N é o tamanho
     * da lista).
     */
    while (baixo <= alto) {

      /**
       * Etapa: cálculo do meio Frequência de execução: Executada log2​N vezes.
       * 
       * Explicação: A expressão "baixo + (alto - baixo) / 2" evita o integer overflow porque a
       * primeira operação feita é a subtração (alto - baixo). Garantia: Como alto é sempre maior ou
       * igual a baixo (se o código estiver correto), a subtração "alto - baixo" nunca resultará em
       * um número maior do que o tamanho total da array menos um. Segurança: Já que o tamanho
       * máximo de uma array em Java (embora teoricamente limitado pela memória) não pode exceder o
       * limite de um int (2^31 − 1, aproximadamente 2.147 bilhões), o resultado de (alto - baixo)
       * está sempre dentro dos limites seguros do tipo int e não causará estouro. Cálculo: Você
       * está calculando o deslocamento "(alto - baixo) / 2" do ponto baixo e somando esse
       * deslocamento a baixo para encontrar o ponto central. Em resumo, esta linha de código é a
       * maneira preferida de calcular o meio em uma busca binária por ser resistente ao overflow em
       * listas extremamente longas.
       */
      int meio = baixo + (alto - baixo) / 2;

      /**
       * Etapa: Acesso ao Array. Frequência de execução: Executada log2​N vezes.
       */
      String chute = lista[meio];

      /**
       * Etapa: Execução de comparação. Frequência de execução: Executada log2​N vezes.
       */
      int comparacao = chute.compareTo(item);

      /**
       * Etapa: Verificação de sucesso. Frequência de execução: Executada log2​N vezes.
       */
      if (comparacao == 0) {
        return meio;
      }

      /**
       * Etapa: Ajuste de limites. Frequência de execução: Executada log2​N vezes.
       */
      if (comparacao > 0) { // Se 'chute' vem DEPOIS (é maior) do que 'item'.
        alto = meio - 1;
      } else { // Se 'chute' vem ANTES (é menor) do que 'item'
        baixo = meio + 1;
      }

    }

    /**
     * Etapa: Retorno de falha. Frequência de execução: Executada somente uma vez, apenas se não for
     * encontrado.
     */
    return null;
  }
}
