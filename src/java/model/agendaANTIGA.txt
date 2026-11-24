package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private Map<LocalDate, Dia> dias;
    private int proximoId;

    public Agenda(String nome) {
        this.nome = nome;
        this.dias = new TreeMap<>();
        this.proximoId = 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<LocalDate, Dia> getDias() {
        return new TreeMap<>(dias);
    }

    public Dia buscarDia(LocalDate data) {
        return dias.get(data);
    }

    private Dia buscarOuCriarDia(LocalDate data) {
        if (!dias.containsKey(data)) {
            dias.put(data, new Dia(data));
        }

        return dias.get(data);
    }

    public List<Evento> listarEventos(LocalDate data) {
        Dia dia = buscarDia(data);

        if (dia == null) {
            return new ArrayList<>();
        }

        return dia.listarEventos();
    }

    public boolean adicionarEvento(LocalDate data, String titulo,
            String descricao, LocalTime inicio, LocalTime fim) {

        return adicionarItem(data, titulo, descricao, inicio, fim, "EVENTO", 2);
    }

    public boolean adicionarItem(LocalDate data, String titulo,
            String descricao, LocalTime inicio, LocalTime fim,
            String tipo, int prioridade) {

        if (data == null || titulo == null || titulo.trim().isEmpty()) {
            return false;
        }

        if (inicio == null || fim == null || !fim.isAfter(inicio)) {
            return false;
        }

        Evento novoEvento = new Evento(proximoId, titulo, descricao, inicio, fim, tipo, prioridade);

        if (!novoEvento.tipoValido() || !novoEvento.prioridadeValida()) {
            return false;
        }

        Dia dia = buscarOuCriarDia(data);

        if (!dia.temVaga()) {
            return false;
        }

        if (dia.adicionarEvento(novoEvento)) {
            proximoId++;
            return true;
        }

        return false;
    }

    public boolean removerEvento(LocalDate data, int id) {
        Dia dia = buscarDia(data);

        if (dia == null) {
            return false;
        }

        return dia.removerEvento(id);
    }

    public boolean concluirEvento(LocalDate data, int id) {
        Dia dia = buscarDia(data);

        if (dia == null) {
            return false;
        }

        Evento evento = dia.buscarEvento(id);

        if (evento == null) {
            return false;
        }

        evento.concluir();
        return true;
    }

    public boolean reabrirEvento(LocalDate data, int id) {
        Dia dia = buscarDia(data);

        if (dia == null) {
            return false;
        }

        Evento evento = dia.buscarEvento(id);

        if (evento == null) {
            return false;
        }

        evento.reabrir();
        return true;
    }

    public boolean editarEvento(LocalDate data, int id,
            String titulo, String descricao,
            LocalTime inicio, LocalTime fim) {

        Dia dia = buscarDia(data);

        if (dia == null || titulo == null || titulo.trim().isEmpty()) {
            return false;
        }

        if (inicio == null || fim == null || !fim.isAfter(inicio)) {
            return false;
        }

        Evento evento = dia.buscarEvento(id);

        if (evento == null) {
            return false;
        }

        evento.setTitulo(titulo);
        evento.setDescricao(descricao);
        evento.setHorarioInicio(inicio);
        evento.setHorarioFim(fim);

        return true;
    }

    public List<Evento> buscarPorTitulo(String titulo) {
        List<Evento> encontrados = new ArrayList<>();

        if (titulo == null || titulo.trim().isEmpty()) {
            return encontrados;
        }

        for (Dia dia : dias.values()) {
            for (Evento evento : dia.listarEventos()) {

                if (evento.getTitulo().toLowerCase()
                        .contains(titulo.toLowerCase())) {

                    encontrados.add(evento);
                }
            }
        }

        return encontrados;
    }

    public List<Evento> listarAtrasados(LocalDate data) {
        List<Evento> atrasados = new ArrayList<>();

        Dia dia = buscarDia(data);

        if (dia == null) {
            return atrasados;
        }

        for (Evento evento : dia.listarEventos()) {

            if (evento.estaAtrasado(data)) {
                atrasados.add(evento);
            }
        }

        return atrasados;
    }
}