# Trabalho_POO_Agenda
## Classe Evento
### Atributos
private int	id -> Identificador único dentro da agenda\
private String titulo -> Título obrigatório\
private String descricao -> Detalhes opcionais\
private LocalTime	horarioInicio -> Hora inicial\
private LocalTime	horarioFim -> Hora final\
private boolean	concluido -> false = pendente; true = concluído\

### Metodos
Evento(int id, String titulo, String descricao, LocalTime inicio, LocalTime fim) = Construtor; inicia concluido=false\
int getId()	Consulta ID; -> sem setId para evitar alterações\
String getTitulo() / void setTitulo(String titulo) -> Lê/edita título\
String getDescricao() / void setDescricao(String descricao) ->	Lê/edita descrição\
LocalTime getHorarioInicio() / void setHorarioInicio(LocalTime inicio) -> Lê/edita início\
LocalTime getHorarioFim() / void setHorarioFim(LocalTime fim) -> Lê/edita fim\
boolean isConcluido() / void setConcluido(boolean concluido) -> Lê/atualiza status\
void concluir() / void reabrir() -> Atalhos para alterar status\
boolean horarioValido() -> Confere se fim é posterior ao início\

