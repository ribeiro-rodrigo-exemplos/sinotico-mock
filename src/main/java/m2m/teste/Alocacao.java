package m2m.teste;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;

/**
 * Created by rodrigo on 27/11/17.
 */
public class Alocacao implements Portable {

    private String partida;
    private String chegada;
    private String aberturaViagem;

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public String getAberturaViagem() {
        return aberturaViagem;
    }

    public void setAberturaViagem(String aberturaViagem) {
        this.aberturaViagem = aberturaViagem;
    }

    public int getFactoryId() {
        return 1;
    }

    public int getClassId() {
        return 1;
    }

    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF("partida",partida);
        portableWriter.writeUTF("chegada",chegada);
        portableWriter.writeUTF("aberturaViagem",aberturaViagem);
    }

    public void readPortable(PortableReader portableReader) throws IOException {
        partida = portableReader.readUTF("partida");
        chegada = portableReader.readUTF("chegada");
        aberturaViagem = portableReader.readUTF("aberturaViagem");
    }
}
