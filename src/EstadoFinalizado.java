public class EstadoFinalizado implements Estado {
    private Voo voo;

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Finalizado não pode ser modificado");
    }
    
    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Finalizado não pode adicionar passageiro");
    }
    
    @Override
    public void removerTripulante(String nome) throws UnsupportedOperationException, ObjectNotFound {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Finalizado não pode remover tripulante");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Finalizado não pode trocar portão de embarque");
    }

    @Override
    public void setVoo(Voo voo) {
        this.voo = voo;
        // TODO Auto-generated method stub
        
    }
    
    
    
    @Override
    public void notificarTripulantes() {
        // TODO Auto-generated method stub
        this.voo.notificarTripulantes("O voo partiu para o destino");
        

    }
    
}
