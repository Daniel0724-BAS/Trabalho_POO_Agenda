package model;

import java.time.LocalTime;

public class Evento {

    private int id;
    private String titulo;
    private String descricao;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private boolean concluido;

    public Evento(int id, String titulo, String descricao, LocalTime inicio, LocalTime fim) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.horarioInicio = inicio;
        this.horarioFim = fim;
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public boolean isConcluido() {
        return concluido;
        
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void concluir() {
        concluido = true;
    }

    public void reabrir() {
        concluido = false;
    }

    public boolean horarioValido() {
        return horarioFim.isAfter(horarioInicio)
    }
}