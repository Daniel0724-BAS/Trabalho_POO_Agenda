# Trabalho_POO_Agenda

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

Este repositório contém o código-fonte de uma aplicação de agenda, desenvolvida em Java, utilizando conceitos de Orientação a Objetos.

---

# 1. Configuração inicial do projeto

Siga os passos abaixo para configurar o projeto no seu computador.

### 1.1. Preparando o ambiente

1. Abra sua IDE de preferência (IntelliJ IDEA ou VS Code).
2. Crie uma pasta no seu computador chamada `Trabalho_POO`.
3. Abra essa pasta na sua IDE.
4. Abra o terminal da IDE e execute o comando:

```bash
git clone https://github.com/Daniel0724-BAS/Trabalho_POO_Agenda.git
```

Esse comando fará o download do repositório do GitHub para o seu computador.

5. Entre na pasta do projeto:

```bash
cd Trabalho_POO_Agenda
```

6. Para garantir que você está utilizando a versão mais atualizada do projeto, execute:

```bash
git pull origin main
```

Se aparecer a mensagem `Already up to date.`, significa que não existem atualizações pendentes para baixar.

### 1.2. Configurando a estrutura do projeto

Após clonar o repositório:

1. Abra a pasta `Trabalho_POO_Agenda`.
2. Entre na pasta `src`.
3. Entre na pasta `java`.

**Importante para quem utiliza IntelliJ IDEA:**

Verifique se a pasta `java` está identificada como `Sources Root` (normalmente aparece na cor azul).

Caso não esteja:

1. Clique com o botão direito na pasta `java`.
2. Selecione `Mark Directory As`.
3. Escolha `Sources Root`.

### 1.3. Conhecendo a estrutura de pastas

Dentro da pasta `java`, você encontrará três pastas, cada uma com uma responsabilidade dentro do projeto.

Neste primeiro momento, concentre-se na pasta `Model`.

A pasta `Model` será responsável por armazenar as classes que representam as entidades do sistema.

Abra a classe que foi designada para você desenvolver e confira as especificações da tarefa na seção correspondente deste README.

---

# 2. Regras de utilização do Git e GitHub

<ins>**ATENÇÃO: Leia esta seção antes de começar a desenvolver qualquer funcionalidade.**</ins>

Como o projeto é desenvolvido em equipe e utiliza o GitHub para compartilhar o código, todos devem seguir um mesmo fluxo de trabalho.

Isso evita conflitos, perda de código e alterações acidentais na versão principal do projeto.

## 2.1. Antes de começar a desenvolver

Sempre que for iniciar uma tarefa, abra o terminal na pasta do projeto e execute:

```bash
git switch main
git pull origin main
```

O primeiro comando garante que você está na branch principal (`main`).

O segundo comando atualiza sua versão local com as alterações que já foram enviadas ao GitHub.

**Não comece a desenvolver antes de atualizar seu projeto!**

## 2.2. Criando uma branch para sua tarefa

Cada integrante deve desenvolver sua tarefa em uma branch própria, sem modificar diretamente a `main`.

Para criar uma nova branch, utilize:

```bash
git switch -c feat/nome-da-funcionalidade
```

Exemplo:

```bash
git switch -c feat/classe-evento
```

O comando cria uma nova branch e já direciona você para ela.

**Padrão para nomear as branches:**

- `feat/nome`: criação de uma nova funcionalidade ou classe.
- `fix/nome`: correção de um erro.
- `refactor/nome`: reorganização ou melhoria do código sem alterar seu comportamento.

Utilize nomes curtos e que identifiquem claramente a tarefa.

## 2.3. Desenvolvendo sua tarefa

Depois de criar a branch:

1. Abra a classe que foi designada para você.
2. Desenvolva somente o que foi solicitado.
3. Evite modificar arquivos que não fazem parte da sua tarefa.
4. Teste o código antes de enviá-lo.

## 2.4. Verificando as alterações

Quando terminar sua implementação, execute:

```bash
git status
```

Esse comando mostra quais arquivos foram modificados.

Os arquivos em vermelho representam alterações que ainda não foram adicionadas à área de preparação (*staging area*).

Para adicionar um arquivo específico, utilize:

```bash
git add caminho/do/arquivo
```

Exemplo:

```bash
git add src/java/Model/Evento.java
```

**Atenção:** utilize o caminho real do arquivo no seu projeto. O Git diferencia letras maiúsculas de minúsculas em alguns ambientes.

Se quiser adicionar todos os arquivos modificados, também é possível utilizar:

```bash
git add .
```

Execute novamente:

```bash
git status
```

Os arquivos adicionados deverão aparecer como alterações preparadas para commit (normalmente em verde).

## 2.5. Criando um commit

Depois de adicionar os arquivos, registre suas alterações com:

```bash
git commit -m "tipo: descrição da alteração"
```

Utilizamos mensagens convencionais para facilitar a identificação do que foi desenvolvido.

### Padrão das mensagens de commit

| Tipo | Quando utilizar | Exemplo |
|---|---|---|
| `feat` | Nova funcionalidade ou classe | `feat: implementa classe Evento` |
| `fix` | Correção de erros | `fix: corrige validação de horário` |
| `refactor` | Alteração na estrutura ou lógica interna do código | `refactor: reorganiza métodos da classe Evento` |
| `style` | Alterações visuais ou de formatação sem modificar a lógica | `style: ajusta formatação da classe Evento` |

## 2.6. Enviando sua branch para o GitHub

Depois de criar o commit, envie sua branch para o GitHub:

```bash
git push -u origin nome-da-sua-branch
```

Exemplo:

```bash
git push -u origin feat/classe-evento
```

O comando envia suas alterações para o repositório remoto.

## 2.7. Criando um Pull Request

Após enviar sua branch:

1. Acesse o repositório no GitHub.
2. Entre na aba `Pull requests`.
3. Clique em `New pull request`.
4. Em `base`, selecione `main`.
5. Em `compare`, selecione a branch que você criou.
6. Confira as alterações e clique em `Create pull request`.
7. Aguarde a revisão e aprovação antes de integrar suas alterações à `main`.

**Importante:** não faça o merge por conta própria sem seguir o processo de revisão combinado pela equipe.

## 2.8. Finalizando a tarefa

Depois que seu Pull Request for aprovado e integrado à `main`, volte para sua IDE e execute:

```bash
git switch main
```

Em seguida:

```bash
git pull origin main
```

Agora sua versão local estará atualizada com as alterações integradas ao projeto.

Você poderá começar uma nova tarefa seguindo novamente esse fluxo.

---

# 3. Sprint 1

## Classe: Evento

Nesta sprint, será desenvolvida a classe `Evento`, responsável por representar os compromissos cadastrados na agenda.

A classe deverá armazenar as informações de cada evento, permitir a consulta e alteração de seus dados e controlar se ele foi concluído ou não.

### 3.1. Atributos

Todos os atributos devem possuir visibilidade `private`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `id` | `int` | Identificador único do evento dentro da agenda. |
| `titulo` | `String` | Título obrigatório do evento. |
| `descricao` | `String` | Descrição ou detalhes adicionais. Pode ser opcional. |
| `horarioInicio` | `LocalTime` | Horário de início do evento. |
| `horarioFim` | `LocalTime` | Horário de término do evento. |
| `concluido` | `boolean` | Indica se o evento foi concluído. `false` representa pendente e `true` representa concluído. |

### 3.2. Construtor

A classe deverá possuir o seguinte construtor:

```java
Evento(int id, String titulo, String descricao,
       LocalTime inicio, LocalTime fim)
```

Responsabilidades:

- Inicializar os atributos recebidos.
- Definir o atributo `concluido` inicialmente como `false`.

### 3.3. Métodos

A classe deverá implementar os seguintes métodos:

| Método | Responsabilidade |
|---|---|
| `int getId()` | Retornar o identificador do evento. |
| `String getTitulo()` | Retornar o título. |
| `void setTitulo(String titulo)` | Alterar o título. |
| `String getDescricao()` | Retornar a descrição. |
| `void setDescricao(String descricao)` | Alterar a descrição. |
| `LocalTime getHorarioInicio()` | Retornar o horário de início. |
| `void setHorarioInicio(LocalTime inicio)` | Alterar o horário de início. |
| `LocalTime getHorarioFim()` | Retornar o horário de término. |
| `void setHorarioFim(LocalTime fim)` | Alterar o horário de término. |
| `boolean isConcluido()` | Consultar se o evento foi concluído. |
| `void setConcluido(boolean concluido)` | Atualizar o estado de conclusão. |
| `void concluir()` | Marcar o evento como concluído. |
| `void reabrir()` | Marcar o evento novamente como pendente. |
| `boolean horarioValido()` | Verificar se o horário de término é posterior ao horário de início. |

### 3.4. Regras importantes de implementação

- O atributo `id` deve possuir apenas um método de leitura (`getId`). Não deve existir `setId`, evitando alterações no identificador após a criação do evento.
- Todo evento deve começar com `concluido = false`.
- O horário de término deve ser posterior ao horário de início.
- O método `concluir()` deve alterar o estado do evento para `true`.
- O método `reabrir()` deve alterar o estado do evento para `false`.

**Observação:** utilize a classe `LocalTime`, pertencente ao pacote `java.time`, para representar os horários.

Exemplo de importação:

```java
import java.time.LocalTime;
```
## Classe: Dia

A classe `Dia` será responsável por representar um dia específico da agenda, armazenando sua data e os eventos cadastrados nele.

Cada dia poderá conter, no máximo, 10 eventos. A classe também deverá permitir adicionar, consultar, listar e remover eventos.

### 3.5.1. Atributos

Todos os atributos devem possuir visibilidade `private`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `data` | `LocalDate` | Data que representa o dia da agenda. |
| `eventos` | `List<Evento>` | Lista de eventos cadastrados nesse dia. |
| `LIMITE_EVENTOS` | `static final int` | Constante que define o limite máximo de eventos por dia (10). |

### 3.5.2. Construtor

A classe deverá possuir o seguinte construtor:

```java
Dia(LocalDate data)
```

Responsabilidades:
- Receber e armazenar a data correspondente ao dia.
- Inicializar a lista de eventos vazia.

### 3.5.3. Métodos

A classe deverá implementar os seguintes métodos:

| Método | Responsabilidade |
|---|---|
| `LocalDate getData()` | Retornar a data do dia. |
| `List<Evento> getEventos()` | Retornar uma consulta protegida da lista de eventos. |
| `int getQuantidadeEventos()` | Retornar a quantidade de eventos cadastrados. |
| `int getLimiteEventos()` | Retornar o limite máximo de eventos (10). |
| `boolean temVaga()` | Verificar se ainda existem vagas disponíveis para novos eventos. |
| `boolean adicionarEvento(Evento evento)` | Validar e adicionar um evento à lista, caso seja possível. |
| `Evento buscarEvento(int id)` | Localizar um evento pelo seu identificador. |
| `boolean removerEvento(int id)` | Remover um evento da lista a partir do seu identificador. |
| `List<Evento> listarEventos()` | Retornar a lista de eventos cadastrados no dia. |

### 3.5.4. Regras importantes de implementação

- Um dia pode possuir, no máximo, 10 eventos.
- A lista de eventos deve ser inicializada vazia no construtor.
- O método `temVaga()` deve retornar `true` quando a quantidade de eventos for menor que 10.
- O método `adicionarEvento()` não deve permitir adicionar eventos quando o limite for atingido.
- O método `adicionarEvento()` também deve impedir a inserção de eventos nulos.
- O método `buscarEvento()` deve retornar o evento correspondente ao ID informado ou `null` caso não encontre.
- O método `removerEvento()` deve retornar `true` quando conseguir remover o evento e `false` caso ele não exista.
- Os métodos de consulta da lista não devem permitir que outras classes modifiquem diretamente a lista interna de eventos.

### 3.5.5. Importações necessárias

Utilize as seguintes classes da biblioteca Java:

```java
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
```

---

# 4. Observações gerais

- Respeite a estrutura de pastas já definida no projeto.
- Utilize encapsulamento, mantendo os atributos privados.
- Siga os padrões de nomenclatura do Java.
- Evite alterar códigos desenvolvidos por outros integrantes sem comunicação prévia.
- Em caso de dúvidas sobre a implementação, converse com a equipe antes de realizar alterações que possam afetar outras partes do projeto.

**O objetivo é manter o código organizado, padronizado e integrado, permitindo que todos os integrantes desenvolvam suas tarefas sem prejudicar o trabalho dos demais.**

