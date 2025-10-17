package listadupla;

public class MainDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        lista.inserir(5);
        lista.inserir(15);
        lista.inserir(20);

        System.out.println("➡️ Ordem normal:");
        lista.listar();

        System.out.println("⬅️ Ordem reversa:");
        lista.listarReverso();

        lista.remover(10);
        System.out.println("\n📋 Após remoção:");
        lista.listar();
    }
}

