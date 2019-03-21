package atlantico.poc.contentproducer;

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
