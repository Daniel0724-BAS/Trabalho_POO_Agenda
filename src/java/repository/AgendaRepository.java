package repository;
import model.Agenda;
import java.io.IOException;
public interface AgendaRepository {

    void salvar(Agenda agenda) throws IOException;

    Agenda carregar() throws IOException;

    boolean existeArquivo();

}
