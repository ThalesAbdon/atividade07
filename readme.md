# Exercícios de Estruturas de Dados e Algoritmos

Este repositório contém uma série de exercícios relacionados a estruturas de dados e algoritmos implementados em Java. Cada exercício demonstra o uso de diferentes estruturas de dados, como listas encadeadas, filas e pilhas. Abaixo estão os detalhes e instruções para executar cada exercício.

## Exercícios

### 1. Lista Simplesmente Encadeada

#### 1.1 Gerenciador de Tarefas

**Descrição:** Implemente um gerenciador de tarefas usando uma lista simplesmente encadeada, onde cada tarefa é um nó na lista. O programa permite adicionar, remover e marcar tarefas como concluídas.

**Arquivo:** `TaskManager.java`

**Como Executar:**

1. Compile: `javac TaskManager.java`
2. Execute: `java TaskManager`

#### 1.2 Histórico de Navegação

**Descrição:** Crie uma aplicação que simule o histórico de navegação de um navegador utilizando uma lista simplesmente encadeada. Implemente funcionalidades para adicionar novas URLs e remover URLs antigas quando a lista atingir um certo tamanho.

**Arquivo:** `BrowserHistorySimulator.java`

**Como Executar:**

1. Compile: `javac BrowserHistorySimulator.java`
2. Execute: `java BrowserHistorySimulator`

#### 1.3 Sistema de Controle de Reversão (Undo)

**Descrição:** Implemente um sistema de controle de reversão (undo) para uma aplicação de edição de texto. Use uma lista simplesmente encadeada para armazenar as ações realizadas e permita que o usuário desfaça as últimas ações. O texto é mantido como uma única string, e o sistema deve permitir a concatenação e reversão de ações.

**Arquivo:** `TextEditorUndoRedo.java`

**Como Executar:**

1. Compile: `javac TextEditorUndoRedo.java`
2. Execute: `java TextEditorUndoRedo`

### 2. Lista Duplamente Encadeada - Editor de Texto com Undo/Redo

**Descrição:** Implemente um editor de texto simples com funcionalidades de desfazer e refazer usando uma lista duplamente encadeada. O editor permite adicionar texto, desfazer a última ação e refazer ações desfeitas.

**Arquivo:** `TextEditor.java`

**Como Executar:**

1. Compile: `javac TextEditor.java`
2. Execute: `java TextEditor`

### 3. Fila - Simulador de Atendimento Bancário

**Descrição:** Crie uma fila para simular o atendimento em um banco, onde os clientes esperam atendimento na ordem em que chegam. O programa gerencia a chegada dos clientes e os atende na ordem correta.

**Arquivo:** `BankServiceSimulator.java`

**Como Executar:**

1. Compile: `javac BankServiceSimulator.java`
2. Execute: `java BankServiceSimulator`

### 4. Fila - Gerenciador de Trabalhos de Impressão

**Descrição:** Implemente um gerenciador de trabalhos de impressão onde os trabalhos são enfileirados e processados na ordem em que chegam. O programa simula a adição e o processamento dos trabalhos de impressão.

**Arquivo:** `PrintJobManager.java`

**Como Executar:**

1. Compile: `javac PrintJobManager.java`
2. Execute: `java PrintJobManager`

### 5. Fila - Escalonador de Processos

**Descrição:** Simule um escalonador de processos em um sistema operacional usando uma fila. O programa permite adicionar novos processos e executar o processo mais antigo na fila.

**Arquivo:** `ProcessScheduler.java`

**Como Executar:**

1. Compile: `javac ProcessScheduler.java`
2. Execute: `java ProcessScheduler`

3. **Compile os Arquivos Java:**
   Use o comando `javac` para compilar cada arquivo Java conforme mostrado nas instruções específicas de cada exercício.

4. **Execute os Programas:**
   Use o comando `java` para executar as classes compiladas.
