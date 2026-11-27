package model;


import exception.HorarioInvalidoException;
import java.time.LocalTime;

public class Tarefa extends ItemAgenda { 

    private static final long serialVersionUID = 1L;

    private LocalTime prazo;
    private Prioridade prioridade;

    public Tarefa(String titulo, LocalTime prazo, Prioridade prioridade) {
        this(titulo, "", prazo, prioridade);
    }

    public Tarefa(String titulo, String descricao, LocalTime prazo, Prioridade prioridade) {
        super(titulo, descricao);
        this.prazo = prazo;
        this.prioridade = prioridade;
    }

    public LocalTime getPrazo() {
        return prazo;
    }
    public void setPrazo(LocalTime prazo) {
        this.prazo = prazo;

    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String getTipo() {
        return "Tarefa";
    }

    @Override
    public String getResumo() {
        return "Tarefa: " + getTitulo() + " (prazo " + prazo + ", prioridade " + prioridade.getRotulo() + ")";
    }

    @Override
    public LocalTime getHorarioReferencia() {
        return prazo;
    }

    @Override
    public LocalTime getHorarioLimite() {
        return prazo;
    }

    @Override
    public void validar() throws HorarioInvalidoException {
        if (prazo == null) {
            throw new HorarioInvalidoException("A tarefa precisa de um prazo.");
        }
        if (prioridade == null) {
            throw new HorarioInvalidoException("A tarefa precisa de uma prioridade.");
        }
    }
}
