package sinoticoonline;

public class Veiculo {
    private Integer id;
    private Integer clienteId;
    private String modeloModulo;
    private String identificadorModulo;

    public Veiculo(Integer id, Integer clienteId, String identificadorModulo) {
        this.id = id;
        this.clienteId = clienteId;
        this.modeloModulo = "MAXTRACK";
        this.identificadorModulo = identificadorModulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getModeloModulo() {
        return modeloModulo;
    }

    public void setModeloModulo(String modeloModulo) {
        this.modeloModulo = modeloModulo;
    }

    public String getIdentificadorModulo() {
        return identificadorModulo;
    }

    public void setIdentificadorModulo(String identificadorModulo) {
        this.identificadorModulo = identificadorModulo;
    }
}
