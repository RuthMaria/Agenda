package agenda.Model;


public class Compromisso {
    
private String data;
private String hora;
private String tipo;
private String prioridade;
private long id_compromisso;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public long getId_compromisso() {
        return id_compromisso;
    }

    public void setId_compromisso(long id_compromisso) {
        this.id_compromisso = id_compromisso;
    }

    
}
