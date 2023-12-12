public class Email implements Notificador {

  public void enviar(String msg) {
    System.out.println("Mensagem enviada via Email");    
    System.out.println(msg);
  }
  
}