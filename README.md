# 🧩 **Estruturas de Dados com Interface Gráfica – Java Swing**

## 📌 **Descrição do Projeto**
O projeto **Estruturas de Dados com Interface Gráfica** foi desenvolvido como parte dos estudos de **Estruturas de Dados**, com o objetivo de **visualizar o funcionamento interno das listas encadeadas** — **Simples**, **Dupla** e **Circular** — de forma **interativa e didática**.

A aplicação utiliza **Java Swing** para criar uma **interface gráfica amigável**, onde o usuário pode **inserir, remover e listar elementos** dinamicamente, observando como os nós da lista se comportam em tempo real.

---

## 🗂️ **Estrutura do Repositório**
/EstruturasDeDados
│
├── /ListaSimples
│   ├── src/
│   │   ├── No.java
│   │   ├── ListaSimples.java
│   │   ├── TelaListaSimples.java
│   │   └── MainSimples.java
│
├── /ListaDupla
│   ├── src/
│   │   ├── No.java
│   │   ├── ListaDupla.java
│   │   ├── TelaListaDupla.java
│   │   └── MainDuplo.java
│
├── /ListaCircular
│   ├── src/
│   │   ├── No.java
│   │   ├── ListaCircular.java
│   │   ├── TelaListaCircular.java
│   │   └── MainCircular.java
│   |   └── README


💻 Funcionalidades
Cada interface foi desenvolvida com foco na interatividade e simplicidade:

Função	Descrição
➕ Inserir	Adiciona um novo elemento à lista.
➖ Remover	Remove um elemento informado.
📋 Listar	Mostra todos os elementos presentes na lista.

🧱 Componentes da Interface (Swing)
Componente	Descrição
JFrame, JPanel, JButton	Estrutura da janela e botões.
JTextField	Campo de entrada de valores.
JTextArea	Exibição dos resultados e estado da lista.
ActionListener	Detecta e executa ações ao clicar nos botões.

🧠 Estruturas Implementadas
Estrutura	Características
🔹 Lista Simples	Cada nó aponta para o próximo elemento. Ideal para percursos unidirecionais.
🔸 Lista Dupla	Cada nó aponta para o anterior e o próximo, facilitando percursos nos dois sentidos.
🔵 Lista Circular	O último nó aponta de volta ao primeiro, formando um ciclo contínuo.

🧩 Exemplo de Interface – Lista Simples
+------------------------------------------------+
| Valor: [ 10 ] [Inserir] [Remover] [Listar]     |
|------------------------------------------------|
| ✅ Valor inserido: 10                          |
| ✅ Valor inserido: 20                          |
| ❌ Valor removido: 10                          |
| 📋 Lista atual: 20 -> null                     |
+------------------------------------------------+

🪄 Como Executar o Projeto
1️⃣ Abra o projeto em sua IDE Java preferida (Eclipse, IntelliJ ou NetBeans).
2️⃣ Escolha a estrutura desejada (Simples, Dupla ou Circular).
3️⃣ Execute o arquivo principal correspondente:

MainSimples.java

MainDuplo.java

MainCircular.java

4️⃣ A interface abrirá e você poderá testar as operações.


🧮 Conceito Visual – Estruturas
🔹 Lista Simples
[10] → [20] → [30] → null

🔸 Lista Dupla
null ← [10] ⇄ [20] ⇄ [30] → null

🔵 Lista Circular
↻ [10] ⇄ [20] ⇄ [30]
                 
     
     
Esses diagramas representam o fluxo dos ponteiros entre os nós, tornando o comportamento das estruturas mais compreensível.

📝 Breve Explicação dos Códigos
1. Lista Simples
No.java: Define a classe No com um inteiro valor e um ponteiro proximo. É a unidade básica da lista.
ListaSimples.java: Contém métodos como inserir, buscar, remover e listar, usando um nó inicio para gerenciar a lista unidirecional.
TelaListaSimples.java: Cria a GUI com JTextField para entrada, botões (Inserir, Remover, Listar) e JTextArea para exibir a lista (ex: "10 -> 20 -> null").
MainSimples.java: Classe principal que inicia a GUI com SwingUtilities.invokeLater.

2. Lista Dupla
No.java: Inclui valor, proximo e anterior, permitindo navegação bidirecional.
ListaDupla.java: Implementa inserir, buscar, remover, listar (para frente) e listarReversa, usando inicio e fim para otimizar operações.
TelaListaDupla.java: GUI com botões adicionais como "Listar Reversa", mostrando "10 <-> 20 <-> null" ou "20 <-> 10 <-> null".
MainDuplo.java: Inicia a GUI da lista dupla.

3. Lista Circular
No.java: Similar à simples, mas o proximo fecha o ciclo.
ListaCircular.java: Implementa inserir, buscar, remover e listar, com lógica para lidar com o ponteiro circular (ex: "10 -> 20 -> (circular)").
TelaListaCircular.java: GUI básica com os mesmos botões, adaptada para a natureza circular.
MainCircular.java: Inicia a GUI da lista circular.
�
 
 
🎥 Vídeo Explicativo
Link do vídeo:(https://youtu.be/jmUObx2PFpw)


👨‍💻 Autor
Marcos André dos Santos Soares
📚 Projeto acadêmico – Estruturas de Dados em Java
