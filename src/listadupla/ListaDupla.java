package listadupla;

public class ListaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;

    public void inserir(int valor) {
        NoDuplo novo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void listar() {
        NoDuplo aux = inicio;
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public void listarReverso() {
        NoDuplo aux = fim;
        while (aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.anterior;
        }
        System.out.println();
    }

    public void remover(int valor) {
        NoDuplo aux = inicio;

        while (aux != null && aux.valor != valor) {
            aux = aux.proximo;
        } 

        if (aux == null) {
            System.out.println("Valor não encontrado!");
            return;
        }

        if (aux == inicio) {
            inicio = inicio.proximo;
            if (inicio != null) inicio.anterior = null;
        } else if (aux == fim) {
            fim = fim.anterior;
            fim.proximo = null;
        } else {
            aux.anterior.proximo = aux.proximo;
            aux.proximo.anterior = aux.anterior;
        }

        System.out.println("Removido: " + valor);
    }
}
