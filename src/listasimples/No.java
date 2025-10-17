package listasimples;

// Classe que representa cada nó (elemento) da lista
public class No {
    int valor;     // dado guardado
    No proximo;    // referência para o próximo nó

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
