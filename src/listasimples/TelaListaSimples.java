package listasimples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaListaSimples extends JFrame {
    private ListaSimples lista = new ListaSimples();
    private JTextField campoValor;
    private JTextArea areaTexto;

    public TelaListaSimples() {
        // Configura a janela
        setTitle("Lista Encadeada Simples - UNI FSA");
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
                    lista.inserir(valor); // Insere no final (simples)
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
                atualizarLista("Lista atual: " + lista.listar());
            }
        });
    }

    // Atualiza a área de texto com a lista
    private void atualizarLista(String mensagem) {
        areaTexto.setText(mensagem + "\n" + lista.listar());
    }

    public static void main(String[] args) {
        // Executa a GUI na thread de eventos
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaListaSimples().setVisible(true);
            }
        });
    }
}

// Classe do Nó
class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

// Classe da Lista Simples
class ListaSimples {
    private No inicio;

    public ListaSimples() {
        inicio = null;
    }

    // Inserir (no final, para simplicidade)
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

    // Buscar
    public boolean buscar(int valor) {
        No aux = inicio;
        while (aux != null) {
            if (aux.valor == valor) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    // Remover
    public boolean remover(int valor) {
        if (inicio == null) return false;
        if (inicio.valor == valor) {
            inicio = inicio.proximo;
            return true;
        }
        No aux = inicio;
        while (aux.proximo != null && aux.proximo.valor != valor) {
            aux = aux.proximo;
        }
        if (aux.proximo != null) {
            aux.proximo = aux.proximo.proximo;
            return true;
        }
        return false;
    }

    // Listar
    public String listar() {
        StringBuilder sb = new StringBuilder();
        No aux = inicio;
        while (aux != null) {
            sb.append(aux.valor).append(" -> ");
            aux = aux.proximo;
        }
        sb.append("null");
        return sb.toString();
    }
}