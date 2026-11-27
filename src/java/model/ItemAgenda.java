package model;

import java.io.Serializable;
import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class ItemAgenda implements
        Comparable<ItemAgenda>, Concluivel, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static int proximoId = 1;

    private final int id;
    private String titulo;
    private String descricao;
    private boolean concluido;

    protected ItemAgenda(String titulo, String descricao) {
        this.id = proximoId++;
        setTitulo(titulo);
        setDescricao(descricao);
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O título não pode ser vazio."
            );
        }

        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao == null ? "" : descricao;
    }

    @Override
    public boolean isConcluido() {
        return concluido;
    }

    @Override
    public void concluir() {
        this.concluido = true;
    }

    @Override
    public void reabrir() {
        this.concluido = false;
    }

    @Override
    public int compareTo(ItemAgenda outro) {
        if (this.id == outro.id) {
            return 0;
        }

        int comparacao = this.getHorarioReferencia()
                .compareTo(outro.getHorarioReferencia());

        if (comparacao == 0) {
            return Integer.compare(this.id, outro.id);
        }

        return comparacao;
    }

    public boolean conflitaCom(ItemAgenda outro) {
        if (outro == null || this.equals(outro)) {
            return false;
        }

        LocalTime inicio1 = this.getHorarioReferencia();
        LocalTime fim1 = this.getHorarioLimite();

        LocalTime inicio2 = outro.getHorarioReferencia();
        LocalTime fim2 = outro.getHorarioLimite();

        if (inicio1 == null || fim1 == null ||
                inicio2 == null || fim2 == null) {
            return false;
        }

        return inicio1.isBefore(fim2)
                && inicio2.isBefore(fim1);
    }

    public boolean isAtrasado(LocalDate data) {
        if (concluido || data == null) {
            return false;
        }

        LocalDate hoje = LocalDate.now();

        if (data.isBefore(hoje)) {
            return true;
        }

        if (data.isAfter(hoje)) {
            return false;
        }

        LocalTime limite = getHorarioLimite();

        return limite != null
                && LocalTime.now().isAfter(limite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ItemAgenda outro)) {
            return false;
        }

        return this.id == outro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return getResumo();
    }

    public static void sincronizarProximoId(int maiorId) {
        proximoId = Math.max(proximoId, maiorId + 1);
    }

    public abstract String getTipo();

    public abstract LocalTime getHorarioReferencia();

    public abstract LocalTime getHorarioLimite();

    public abstract void validar();

    public abstract String getResumo();

}