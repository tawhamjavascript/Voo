public class PushNotification implements Notificador {

  public void enviar(String msg) {
    System.out.println("Mensagem enviada via PushNotification");    
    System.out.println(msg);
  }
  
}