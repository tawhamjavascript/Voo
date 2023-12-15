public class EstadoCancelado implements Estado{

    private Voo voo;

    public EstadoCancelado() {
    }
    
    
    
    @Override
    public void trocarEstado(int tipoEstado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode ser modificado");
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode adicionar passageiro");
    }

    @Override
    public void removerTripulante(String tripulante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode trocar o portão");
    }

    @Override
    public void setVoo(Voo voo) {
        // TODO Auto-generated method stub
        this.voo = voo;

    }

 
}
