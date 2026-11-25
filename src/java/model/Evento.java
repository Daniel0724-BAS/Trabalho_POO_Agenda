package model;

import java.time.LocalTime;

import exception.HorarioInvalidoException;

public class Evento extends ItemAgenda {

    private static final long serialVersionUID = 1L;

    private LocalTime horarioInicio;
    private LocalTime horarioFim;

    public Evento(String titulo, LocalTime inicio, LocalTime fim) {
        this(titulo, "", inicio, fim);
    }

    public Evento(String titulo, String descricao, LocalTime inicio, LocalTime fim) {
        super(titulo, descricao);
        this.horarioInicio = inicio;
        this.horarioFim = fim;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime inicio) {
        this.horarioInicio = inicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime fim) {
        this.horarioFim = fim;
    }
    @Override
    public String getTipo() {
        return "Evento";
    }
    @Override 
    public String getResumo() {
        return "Evento: " + getTitulo() + " (" + horarioInicio + " - " + horarioFim + ")";
    }
    @Override 
    public LocalTime getHorarioReferencia() {
        return horarioInicio;
    }
    @Override 
    public LocalTime getHorarioLimite() {
        return horarioFim;
    }
    @Override 
    public void validar() throws HorarioInvalidoException {
        if (horarioInicio == null || horarioFim == null) {
            throw new HorarioInvalidoException("O evento precisa de horário de inicio e de fim.");
        }
        if (!horarioFim.isAfter(horarioInicio)) {
            throw new HorarioInvalidoException("O horário de fim deve ser depois do horário de início.");
        }
    }
    @Override 
    public boolean conflitaCom(ItemAgenda outro) {
        if (!(outro instanceof Evento)) {
            return false;
        }
        Evento e = (Evento) outro;
        return this.horarioInicio.isBefore(e.horarioFim) && e.horarioInicio.isBefore(this.horarioFim);
    }
}