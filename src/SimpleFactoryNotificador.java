public class SimpleFactoryNotificador {

  public static Notificador criarNotificador(int tipoNotificador) {
    if (tipoNotificador == 1) {
      return new SMS();
    }
    else if (tipoNotificador == 2) {
      return new Email();
    }
    else if (tipoNotificador == 3) {
      return new PushNotification();
    }
  }
}