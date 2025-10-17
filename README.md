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
│
└── README.md  ← (este arquivo)
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
yaml
Copiar código
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
css
Copiar código
[10] → [20] → [30] → null
🔸 Lista Dupla
css
Copiar código
null ← [10] ⇄ [20] ⇄ [30] → null
🔵 Lista Circular
css
Copiar código
↻ [10] ⇄ [20] ⇄ [30]
     ↑             ↓
     └─────────────┘
Esses diagramas representam o fluxo dos ponteiros entre os nós, tornando o comportamento das estruturas mais compreensível.

�
 Link do vídeo explicativo: 
https:(//youtu.be/seuvideoexplicativo)


👨‍💻 Autor
Marcos André dos Santos Soares
📚 Projeto acadêmico – Estruturas de Dados em Java
