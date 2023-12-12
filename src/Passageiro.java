public class Passageiro extends Tripulante {

  private Bilhete bilhete;

  public Passageiro(String nome, Notificador notificador, Bilhete bilhete) {
    super(nome, notificador);
    this.bilhete = bilhete;
  }

  public Bilhete getBilhete() {
    return this.bilhete;
  }
}