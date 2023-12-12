public class SMS implements Notificador {

  public void enviar(String msg) {
    System.out.println("Mensagem enviada via SMS");    
    System.out.println(msg);
  }
  
}