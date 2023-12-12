public class Aeronave {
    private String nome;
    private int quantidadeDeAssentos;

    public Aeronave(String nome, int quantidadeDeAssentos) {
        this.nome = nome;
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDeAssentos() {
        return quantidadeDeAssentos;
    }

    public void setQuantidadeDeAssentos(int quantidadeDeAssentos) {
        this.quantidadeDeAssentos = quantidadeDeAssentos;
    }

    

    
}
