
package listacircular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaListaCircular extends JFrame {
    private ListaCircular lista = new ListaCircular();
    private JTextField campoValor;
    private JTextArea areaTexto;

    public TelaListaCircular() {
        // Configura a janela
        setTitle("Lista Encadeada Circular - UNI FSA");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // Layout principal
        setLayout(new BorderLayout());

        // Painel superior: Campo de entrada
        JPanel painelEntrada = new JPanel(new FlowLayout());
        campoValor = new JTextField(10);
        painelEntrada.add(new JLabel("Digite um valor: "));
        painelEntrada.add(campoValor);
        add(painelEntrada, BorderLayout.NORTH);

        // Painel central: Área de texto para exibir a lista
        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false); // Só leitura
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Painel inferior: Botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton btnInserir = new JButton("Inserir");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnRemover = new JButton("Remover");
        JButton btnListar = new JButton("Listar");

        painelBotoes.add(btnInserir);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnListar);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    lista.inserir(valor); // Insere no final
                    atualizarLista("Inserido: " + valor);
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido!");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    boolean encontrado = lista.buscar(valor);
                    if (encontrado) {
                        atualizarLista("Valor " + valor + " encontrado!");
                    } else {
                        atualizarLista("Valor " + valor + " não encontrado!");
                    }
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido!");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(campoValor.getText());
                    if (lista.remover(valor)) {
                        atualizarLista("Removido: " + valor);
                    } else {
                        atualizarLista("Valor " + valor + " não encontrado!");
                    }
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido!");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarLista("Lista circular: " + lista.listar());
            }
        });
    }

    // Atualiza a área de texto com a lista
    private void atualizarLista(String mensagem) {
        areaTexto.setText(mensagem + "\n");
    }

    public static void main(String[] args) {
        // Executa a GUI na thread de eventos
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaListaCircular().setVisible(true);
            }
        });
    }
}

// Classe do Nó para Circular
class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe da Lista Circular
class ListaCircular {
    private No inicio;

    public ListaCircular() {
        inicio = null;
    }

    // Inserir (no final, fechando círculo)
    public void inserir(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
            novo.proximo = inicio;
        } else {
            No aux = inicio;
            while (aux.proximo != inicio) {
                aux = aux.proximo;
            }
            aux.proximo = novo;
            novo.proximo = inicio;
        }
    }

    // Buscar
    public boolean buscar(int valor) {
        if (inicio == null) return false;
        No aux = inicio;
        do {
            if (aux.valor == valor) {
                return true;
            }
            aux = aux.proximo;
        } while (aux != inicio);
        return false;
    }

    // Remover
    public boolean remover(int valor) {
        if (inicio == null) return false;
        No aux = inicio;
        No anterior = null;
        do {
            if (aux.valor == valor) {
                if (anterior == null) { // Remove início
                    if (inicio.proximo == inicio) {
                        inicio = null;
                    } else {
                        No ultimo = inicio;
                        while (ultimo.proximo != inicio) {
                            ultimo = ultimo.proximo;
                        }
                        inicio = inicio.proximo;
                        ultimo.proximo = inicio;
                    }
                } else {
                    anterior.proximo = aux.proximo;
                }
                return true;
            }
            anterior = aux;
            aux = aux.proximo;
        } while (aux != inicio);
        return false;
    }

    // Listar (percorre até voltar ao início)
    public String listar() {
        if (inicio == null) return "Lista vazia";
        StringBuilder sb = new StringBuilder();
        No aux = inicio;
        do {
            sb.append(aux.valor).append(" -> ");
            aux = aux.proximo;
        } while (aux != inicio);
        sb.append("(circular)");
        return sb.toString();
    }
}