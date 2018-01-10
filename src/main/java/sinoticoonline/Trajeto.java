package sinoticoonline;

public class Trajeto {
    private String trajetoId;
    private String linhaId;

    public Trajeto(String trajetoId, String linhaId) {
        this.trajetoId = trajetoId;
        this.linhaId = linhaId;
    }

    public String getTrajetoId() {
        return trajetoId;
    }

    public void setTrajetoId(String trajetoId) {
        this.trajetoId = trajetoId;
    }

    public String getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(String linhaId) {
        this.linhaId = linhaId;
    }
}
