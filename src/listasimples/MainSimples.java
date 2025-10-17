package listasimples;

public class MainSimples {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();

        lista.inserir(10);
        lista.inserir(18);
        lista.inserir(37);
        lista.inserir(40);

        System.out.println("📋 Lista atual:");
        lista.listar();

        System.out.println("\n🔍 Buscando o número 18:");
        lista.buscar(20);

        System.out.println("\n❌ Removendo o número 37:");
        lista.remover(30);

        System.out.println("\n📋 Lista após remoção:");
        lista.listar();
    }
}