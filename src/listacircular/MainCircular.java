package listacircular;

public class MainCircular {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.inserir(1);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);

        System.out.println("🔄 Lista Circular:");
        lista.listar();

        lista.remover(3);
        System.out.println("\n📋 Após remoção:");
        lista.listar();
    }
}