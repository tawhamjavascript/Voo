public class EstadoErradoException extends Exception {
    public EstadoErradoException() {
        super("O estado atual não pode mudar para o estado solicitado");

    }
    
}
