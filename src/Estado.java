

public interface Estado {

    public void trocarEstado(int tipoEstado) throws EstadoErradoException;

    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException, AviaoCheioException;

    public void removerTripulante(String nome) throws UnsupportedOperationException, ObjectNotFound;

    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException;

    public void setVoo(Voo voo);

    public void notificarTripulantes();





    
} 
