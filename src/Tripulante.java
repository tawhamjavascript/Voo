public abstract class Tripulante {
  private String nome;
  private Notificador notificador;

  public Tripulante(String nome, Notificador notificador) {
    this.nome = nome;
    this.notificador = notificador;

  }

  public void notificar(String msg) {
    this.notificador.enviar(msg);
  }

  public void setNotificador(Notificador n) {
    this.notificador = n;
  }

  public String getNome() {
    return this.nome;
  }
}