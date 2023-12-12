public class Bilhete {

  private String horario;
  private String data;
  private String origem;
  private String destino;
  private String nomdeDoPassageiro;
  private String nomeDoVoo;


  public Bilhete(String horario, String data, String origem, 
  String destino, String nomeDoPassageiro, String nomeDoVoo) {
    this.horario = horario;
    this.data = data;
    this.origem = origem;
    this.destino = destino;
    this.nomdeDoPassageiro = nomeDoPassageiro;
    this.nomeDoVoo = nomeDoVoo;
  }

  public String getHorario() {
    return this.horario;
  }

  public void setHorario(String novoHorario) {
    this.horario = novoHorario;
  }

  public String getData() {
    return this.data;
  }

  public void setData(String novaData) {
    this.data = novaData;
  }

  public String getOrigem() {
    return this.origem;
  }

  public String getDestino() {
    return destino;
  }

  public String getNomeDoPassageiro() {
    return nomdeDoPassageiro;
  }

  public String getNomeDoVoo() {
    return nomeDoVoo;
  }
}