package model;

import exception.ItemNaoEncontradoException;
import exception.LimiteDiaExcedidoException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int LIMITE_ITENS = 10;

    private LocalDate data;
    private List<ItemAgenda> itens;

    public Dia(LocalDate data) {
        this.data = Objects.requireNonNull(data, "A data do dia não pode ser nula.");
        this.itens = new ArrayList<>();
    }

    public LocalDate getData() {
        return data;
    }

    public List<ItemAgenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public int getVagasDisponiveis() {
        return LIMITE_ITENS - itens.size();
    }

    public static int getLimiteItens() {
        return LIMITE_ITENS;
    }

    public boolean temVaga() {
        return itens.size() < LIMITE_ITENS;
    }

    public void adicionarItem(ItemAgenda item) throws LimiteDiaExcedidoException {
        if (!temVaga()) {
            throw new LimiteDiaExcedidoException(
                    "O dia " + data + " já atingiu o limite de " + LIMITE_ITENS + " itens.");
        }
        itens.add(item);
    }

    public ItemAgenda buscarItem(int id) throws ItemNaoEncontradoException {
        for (ItemAgenda item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNaoEncontradoException("Item " + id + " não encontrado no dia " + data + ".");
    }

    public List<ItemAgenda> buscarPorTitulo(String trecho) {
        List<ItemAgenda> encontrados = new ArrayList<>();
        String busca = (trecho == null) ? "" : trecho.toLowerCase();
        for (ItemAgenda item : itens) {
            if (item.getTitulo().toLowerCase().contains(busca)) {
                encontrados.add(item);
            }
        }
        Collections.sort(encontrados);
        return encontrados;
    }

    public List<ItemAgenda> buscarConflitos(ItemAgenda item) {
        List<ItemAgenda> conflitos = new ArrayList<>();
        for (ItemAgenda outro : itens) {
            if (!outro.equals(item) && item.conflitaCom(outro)) {
                conflitos.add(outro);
            }
        }
        return conflitos;
    }

    public void removerItem(int id) throws ItemNaoEncontradoException {
        ItemAgenda item = buscarItem(id);
        itens.remove(item);
    }

    public List<ItemAgenda> listarItens() {
        List<ItemAgenda> copia = new ArrayList<>(itens);
        Collections.sort(copia);
        return copia;
    }

    public List<ItemAgenda> listarPorPrioridade() {
        List<ItemAgenda> copia = new ArrayList<>(itens);
        copia.sort((a, b) -> {
            int pesoA = (a instanceof Tarefa) ? ((Tarefa) a).getPrioridade().getPeso() : 0;
            int pesoB = (b instanceof Tarefa) ? ((Tarefa) b).getPrioridade().getPeso() : 0;
            int resultado = Integer.compare(pesoB, pesoA);
            return (resultado != 0) ? resultado : a.compareTo(b);
        });
        return copia;
    }

    public int getMaiorId() {
        int maior = 0;
        for (ItemAgenda item : itens) {
            if (item.getId() > maior) {
                maior = item.getId();
            }
        }
        return maior;
    }
}