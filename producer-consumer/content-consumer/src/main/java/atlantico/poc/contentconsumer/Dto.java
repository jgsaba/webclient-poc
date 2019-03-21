package atlantico.poc.contentconsumer;


public class Dto {

    private String nome;

    public Dto(String nome) {
        this.nome = nome;
    }

    public Dto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
