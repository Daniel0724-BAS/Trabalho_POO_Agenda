# Trabalho_POO_Agenda
## Instruções Iniciais
1. Abra sua IDE (IntelliJ ou VSCode)
2. Crie uma pasta no seu computador e de a ela o nome (Trabalho_POO)
3. Abra essa pasta em sua IDE
4. Abra o terminal e digite o seguinte comando
```bash
git clone "https://github.com/Daniel0724-BAS/Trabalho_POO_Agenda.git"
```
- Isso fará com que o repositório do Git Hub seja clonado para sua IDE.
```bash
git pull origin main
```
- Isso atualizará sua pasta de acordo com as atualizações feita no repositório do Git Hub. (Deve aparecer "Already up to date.", para estar pronto)
5. Abra a pasta [Trabalho_POO_Agenda]
6. Abra a pasta [src]
7. Abra a pasta [java] -> (Se estiver no IntelliJ veja isso) Verifique se ela está com a cor azul. Se não, clique com o botão direito do mouse, encontre a opção: "Mark Direcotry As"; escolha a opção: "Sources Root".
8. Na pasta [Java] você encontrá 3 pastas. Por enquanto foque apenas na pasta [Model]
9. Abra a pasta [Model] ela guardará as entidades do projeto.
10. Abra o arquivo que você foi designado e LEIA OS PASSOS ABAIXO.

## EXTREMAMENTE IMPORTANTE (LEIA)
- Sempre antes de começar a codificar, siga estritamente os seguintes passos.
- Estamos utilizando o Git Hub, logo temos algumas regras que devem ser seguidas.
### REGRAS
Antes de começar a desenvolver qualquer coisa sempre digite esse comando no terminal:
```bash
git pull origin main
```
Para desenvolver uma nova funcionalidade do projeto, você deve utilizar os seguintes comandos:
1.
```bash
git switch -c "feat/nome-funcionalidade ou nome-classe"
```
- Isso cria um espaço de trabalho para você, protegendo o código já desenvolvido de futuras falhas.

2. Codifique normalmente na classe que foi designado, lembre-se o nome dado no comando deve ser o mesmo da classe ou funcionalidade que você foi designado.
3. Após terminar de desenvolver a tarefa que foi designado faça os seguintes comandos:
```bash
git status
```
- Mostra o que foi alterado nos arquivos.
- Copie o caminho que estiver vermelho; Exemplo: "src/java/model/Agenda.java"
- Depois digite o seguinte comando:
```bash
git add src/java/model/Agenda.java
```
4. Após isso se você der um (git status) o "src/java/model/Agenda.java" estará verde, se isso acontecer está correto.
5. Digite o seguinte no terminal:
```bash
git commit -m "Mensagem convencional de commit"
```
### Mensagens convencionais de commit
- Se for uma <b>nova funcionalidade</b>: "feat: Implementa nome-nova-funcionalidade"
- Se for uma <b>alteração em código</b> já existente <b>QUE ALTERE A LÓGICA</b>: "refactor: Altera descreva-o-que-alterou"
- Se for uma <b>alteração em código</b> já existente <b>QUE NÃO ALTERE A LÓGICA</b>: "style: Altera descreva-o-que-alterou"
6. depois disso: digite:
```bash
git push origin main
```
7. Depois abra o Git Hub no navegador
8. Encontre a aba Pull Requests lá em cima nas opções [Code, Issues, Pull request ...].
9. Submeta um pull request da branch [Espaço de trabalho que havia criado].
10. volte para o sua IDE, digite:
```bash
git switch main
```
```bash
git pull origin main
```
- Verifique se seus códigos estão ai após ver a mensagem de "Already up to date."

## Sprint 1
### Classe Evento
### Atributos
- private int	id -> Identificador único dentro da agenda\
- private String titulo -> Título obrigatório\
- private String descricao -> Detalhes opcionais\
- private LocalTime	horarioInicio -> Hora inicial\
- private LocalTime	horarioFim -> Hora final\
- private boolean	concluido -> false = pendente; true = concluído\

### Metodos
- Evento(int id, String titulo, String descricao, LocalTime inicio, LocalTime fim) = Construtor; inicia concluido=false\
- int getId()	Consulta ID; -> sem setId para evitar alterações\
- String getTitulo() / void setTitulo(String titulo) -> Lê/edita título\
- String getDescricao() / void setDescricao(String descricao) ->	Lê/edita descrição\
- LocalTime getHorarioInicio() / void setHorarioInicio(LocalTime inicio) -> Lê/edita início\
- LocalTime getHorarioFim() / void setHorarioFim(LocalTime fim) -> Lê/edita fim\
- boolean isConcluido() / void setConcluido(boolean concluido) -> Lê/atualiza status\
- void concluir() / void reabrir() -> Atalhos para alterar status\
- boolean horarioValido() -> Confere se fim é posterior ao início\

