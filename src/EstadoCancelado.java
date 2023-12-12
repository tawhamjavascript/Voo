public class EstadoCancelado implements Estado{

    private Voo voo;

    public EstadoCancelado(Voo voo) {
        this.voo = voo;
        this.voo.notificarTripulantes("O voo está cancelado");
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
    public void removerTripulante(Tripulante tripulante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode trocar o portão");
    }

    @Override
    public void definirEscalaDoVoo(String partida, String chegada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de cancelado não pode mudar o horário do voo");
    }

    
}
