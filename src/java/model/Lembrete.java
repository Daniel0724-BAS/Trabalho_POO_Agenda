package model;

import exception.HorarioInvalidoException;

import java.time.LocalTime;

public class Lembrete extends ItemAgenda {

    private static final long serialVersionUID = 1L;

    private LocalTime horario;
    private boolean alertaSonoro;

    public Lembrete(String titulo, LocalTime horario, boolean alertaSonoro) {
        this(titulo, "", horario, alertaSonoro);
    }

    public Lembrete(String titulo, String descricao, LocalTime horario, boolean alertaSonoro) {
        super(titulo, descricao);
        this.horario = horario;
        this.alertaSonoro = alertaSonoro;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public boolean isAlertaSonoro() {
        return alertaSonoro;
    }

    public void setAlertaSonoro(boolean alerta) {
        this.alertaSonoro = alerta;
    }

    @Override
    public String getTipo() {
        return "Lembrete";
    }

    @Override
    public String getResumo() {
        return "Lembrete: " + getTitulo() + " (" + horario + ")" + (alertaSonoro ? " [alerta sonoro]" : "");
    }

    @Override
    public LocalTime getHorarioReferencia() {
        return horario;
    }

    @Override
    public LocalTime getHorarioLimite() {
        return horario;
    }

    @Override
    public void validar() throws HorarioInvalidoException {
        if (horario == null) {
            throw new HorarioInvalidoException("O lembrete precisa de um horário.");
        }
    }
}