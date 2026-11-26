package model;

import exception.HorarioInvalidoException;

import java.time.LocalTime;
public class Lembrete extends ItemAgenda { 
    private static final long serialVersionUID = 1L;

    private LocalTime horario;
    private boolean alertaSonoro;

    public Lembrete(String titulo, LocalTime horario, boolean alertaSonora) {
        this(titulo, "", horario, alertaSonora);
    }

    public Lembrete(String titulo, LocalTime horario, boolean alertaSonoro) {
        super(titulo, descricao);
        this.horario = horario;
        this.alertaSonora = alertaSonora;
    }

    public LocalTime getHorario() {
        return horario;
    }
    public void setHorario() {
        return horario;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public boolean isAlertaSonora() {
        return alertaSonoro;
    }
    public void setAlertaSonoro(boolean alerta) {
        this.alertaSonoro = alerta;
    }
}
