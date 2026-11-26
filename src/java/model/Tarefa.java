package model;


import exception.HorarioInvalidoException;
import java.time.LocalTime;

public class Tarefa extends ItemAgenda { 

    private static final long serialVersionUID = 1L;

    private LocalTime prazo;
    private Prioridade prioridade;

    
}
