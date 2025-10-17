
package listasimples;


public class ListaSimples {
    private No inicio; // primeiro elemento da lista

    // Inserir no final
    public void inserir(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
        }
    }

    // Listar todos os elementos
    public void listar() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }
        No aux = inicio;
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    // Buscar um valor
    public void buscar(int valor) {
        No aux = inicio;
        while (aux != null) {
            if (aux.valor == valor) {
                System.out.println("Valor " + valor + " encontrado!");
                return;
            }
            aux = aux.proximo;
        }
        System.out.println("Valor não encontrado!");
    }

    // Remover um valor
    public void remover(int valor) {
        if (inicio == null) return;

        if (inicio.valor == valor) {
            inicio = inicio.proximo;
            return;
        }

        No aux = inicio;
        while (aux.proximo != null && aux.proximo.valor != valor) {
            aux = aux.proximo;
        }

        if (aux.proximo != null) {
            aux.proximo = aux.proximo.proximo;
            System.out.println("Valor removido: " + valor);
        } else {
            System.out.println("Valor não encontrado!");
        }
    }
}


