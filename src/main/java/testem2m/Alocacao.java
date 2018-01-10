package testem2m;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.nio.serialization.VersionedPortable;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rodrigo on 27/11/17.
 */
public class Alocacao implements VersionedPortable {

    private String partida;
    private String chegada;
    private Date aberturaViagem;
    private Integer idVeiculo;
    private String horarioId;

    private static final long serialVersionUID = -8414311141095863980L;
    private int idCliente;
    private String viagemId;
    private Date ultimoUso;
    private Date dataTransmissao;
    private String idPlanejamento;
    private String idLinha;
    private String idTrajeto;

    public String getViagemId() {
        return viagemId;
    }

    public void setViagemId(String viagemId) {
        this.viagemId = viagemId;
    }

    public Date getDataTransmissao() {
        return dataTransmissao;
    }

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

    public Date getAberturaViagem() {
        return aberturaViagem;
    }

    public void setAberturaViagem(Date aberturaViagem) {
        this.aberturaViagem = aberturaViagem;
    }

    public int getFactoryId() {
        return 1;
    }

    public String getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(String horarioId) {
        this.horarioId = horarioId;
    }

    public int getClassId() {
        return 1;
    }

    public int getClassVersion() {
        return 1;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void writePortable(PortableWriter writer) throws IOException {
        /*portableWriter.writeUTF("partida",partida);
        portableWriter.writeUTF("chegada",chegada);
        portableWriter.writeLong("dataTransmissao",aberturaViagem.getTime());
        portableWriter.writeInt("idVeiculo",idVeiculo);
        portableWriter.writeUTF("horarioId",horarioId);*/

        writer.writeInt("idCliente",idCliente);
        writer.writeUTF("horarioId",horarioId);
        writer.writeUTF("viagemId",viagemId);
        writer.writeLong("ultimoUso",ultimoUso != null ? ultimoUso.getTime() : 0L);
        writer.writeLong("dataTransmissao",dataTransmissao != null ? dataTransmissao.getTime() : 0L);
        writer.writeInt("idVeiculo",idVeiculo);
        writer.writeUTF("idPlanejamento",idPlanejamento);
        writer.writeUTF("idLinha",idLinha);
        writer.writeUTF("idTrajeto",idTrajeto);
        writer.writeUTF("partida",partida);
        writer.writeUTF("chegada",chegada);
    }

    public void readPortable(PortableReader reader) throws IOException {
        /*partida = portableReader.readUTF("partida");
        chegada = portableReader.readUTF("chegada");
        aberturaViagem = new Date(portableReader.readLong("dataTransmissao"));
        idVeiculo = portableReader.readInt("idVeiculo");
        horarioId = portableReader.readUTF("horarioId"); */

        idCliente = reader.readInt("idCliente");
        horarioId = reader.readUTF("horarioId");
        viagemId = reader.readUTF("viagemId");
        ultimoUso = reader.readLong("ultimoUso") == 0 ? null : new Date(reader.readLong("ultimoUso"));
        dataTransmissao = reader.readLong("dataTransmissao") == 0 ? null : new Date(reader.readLong("dataTransmissao"));
        idVeiculo = reader.readInt("idVeiculo");
        idPlanejamento = reader.readUTF("idPlanejamento");
        idLinha = reader.readUTF("idLinha");
        idTrajeto = reader.readUTF("idTrajeto");
        partida = reader.readUTF("partida");
        chegada = reader.readUTF("chegada");
    }
}

