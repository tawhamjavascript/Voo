public interface Estado {

    public void trocarEstado(int tipoEstado) throws EstadoErradoException;

    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException;

    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException;

    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException;

    public void definirEscalaDoVoo(String partida, String chegada) throws UnsupportedOperationException;


    
} 
