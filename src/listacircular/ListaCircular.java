package listacircular;

public class ListaCircular {
    private NoCircular inicio;
    private NoCircular fim;

    public void inserir(int valor) {
        NoCircular novo = new NoCircular(valor);
        if (inicio == null) {
            inicio = fim = novo;
            fim.proximo = inicio;
        } else {
            fim.proximo = novo;
            fim = novo;
            fim.proximo = inicio;
        }
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        NoCircular aux = inicio;
        do {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        } while (aux != inicio);
        System.out.println();
    }

    public void remover(int valor) {
        if (inicio == null) return;

        NoCircular aux = inicio;
        NoCircular anterior = fim;

        do {
            if (aux.valor == valor) {
                if (aux == inicio) {
                    inicio = inicio.proximo;
                    fim.proximo = inicio;
                } else if (aux == fim) {
                    fim = anterior;
                    fim.proximo = inicio;
                } else {
                    anterior.proximo = aux.proximo;
                }
                System.out.println("Removido: " + valor);
                return;
            }
            anterior = aux;
            aux = aux.proximo;
        } while (aux != inicio);
        System.out.println("Valor não encontrado!");
    }
}