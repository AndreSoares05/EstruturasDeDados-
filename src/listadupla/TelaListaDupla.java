package listadupla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaListaDupla extends JFrame {
    private ListaDupla lista = new ListaDupla();
    private JTextField campoValor;
    private JTextArea areaTexto;

    public TelaListaDupla() {
        // Configura a janela
        setTitle("Lista Duplamente Encadeada - UNI FSA");
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
        JButton btnListarReversa = new JButton("Listar Reversa"); // Extra para demonstrar bidirecional

        painelBotoes.add(btnInserir);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnListarReversa);
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
                atualizarLista("Lista (para frente): " + lista.listar());
            }
        });

        btnListarReversa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarLista("Lista (reversa): " + lista.listarReversa());
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
                new TelaListaDupla().setVisible(true);
            }
        });
    }
}

// Classe do Nó para Dupla
class No {
    int valor;
    No proximo;
    No anterior;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

// Classe da Lista Dupla
class ListaDupla {
    private No inicio;
    private No fim;

    public ListaDupla() {
        inicio = null;
        fim = null;
    }

    // Inserir (no final)
    public void inserir(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
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
        No aux = inicio;
        while (aux != null) {
            if (aux.valor == valor) {
                if (aux.anterior != null) {
                    aux.anterior.proximo = aux.proximo;
                } else {
                    inicio = aux.proximo;
                }
                if (aux.proximo != null) {
                    aux.proximo.anterior = aux.anterior;
                } else {
                    fim = aux.anterior;
                }
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    // Listar para frente
    public String listar() {
        StringBuilder sb = new StringBuilder();
        No aux = inicio;
        while (aux != null) {
            sb.append(aux.valor).append(" <-> ");
            aux = aux.proximo;
        }
        sb.append("null");
        return sb.toString();
    }

    // Listar reversa
    public String listarReversa() {
        StringBuilder sb = new StringBuilder();
        No aux = fim;
        while (aux != null) {
            sb.append(aux.valor).append(" <-> ");
            aux = aux.anterior;
        }
        sb.append("null");
        return sb.toString();
    }
}