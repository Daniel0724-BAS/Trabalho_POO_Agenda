package repository;

import model.Agenda;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
public class AgendaArquivoRepository implements AgendaRepository {

    private Path caminhoArquivo;

    public AgendaArquivoRepository(Path caminho) {
        this.caminhoArquivo = caminho;
    }

    @Override 
    public void salvar(Agenda agenda) throws IOException {
        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(caminhoArquivo))) {
            Agenda agenda = (Agenda) entrada.readObject();

            agenda.sincronizador();
            return agenda;

        }
        catch (ClassNotFoundException e) {
            throw new IOException("Arquivo da agenda inválido ou de versão imcompatível.");
        }
    }


}
