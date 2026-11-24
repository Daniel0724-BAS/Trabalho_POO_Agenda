package model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Dia {
    // Atributos
    private LocalDate data;
    private List<Evento> eventos;
    private static final int LIMITE_EVENTOS = 10;
    // Construtor
    public Dia(LocalDate data) {
        this.data = Objects.requireNonNull( data, "A data não pode ser nula.");
        this.eventos = new ArrayList<>();
    }
    // Getters
    public LocalDate getData() {
        return data;
    }
    public List<Evento> getEventos() {
        return Collections.unmodifiableList(eventos);
    }
    public int getQuantidadeEventos() {
        return eventos.size();
    }
    public int getLimiteEventos() {
        return LIMITE_EVENTOS;
    }
    // Verifica se o dia possui vagas
    public boolean temVaga() {
        return eventos.size() < LIMITE_EVENTOS;
    }
    // Adiciona um novo evento
    public boolean adicionarEvento(Evento evento) {
        if (evento == null || !temVaga()) {
            return false;
        }
    // Impede IDs repetidos no mesmo dia
        if (buscarEvento(evento.getId()) != null) {
            return false;
        }
        eventos.add(evento);
        return true;
    }
    // Busca um evento pelo ID
    public Evento buscarEvento(int id) {
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }
    // Remove um evento pelo ID
    public boolean removerEvento(int id) {
        Evento evento = buscarEvento(id);
        if (evento == null) {
            return false;
        }
        return eventos.remove(evento);
    }
    // Retorna a lista de eventos
    public List<Evento> listarEventos() {
        return getEventos();
    }
}