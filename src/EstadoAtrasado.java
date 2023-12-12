public class EstadoAtrasado implements Estado {
    private Voo voo;

    public EstadoAtrasado (Voo voo) {
        this.voo = voo;
        this.voo.notificarTripulantes("O voo está atrasado");
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException{
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoConfirmado || estado instanceof EstadoCancelado) {
            voo.setEstado(estado);
        }
        else {
            throw new EstadoErradoException();
        }
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado Atrasado não pode adicionar passageiro");
    }

    @Override
    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de atrasado não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de atrasado não pode trocar o portão");
    }

    @Override
    public void definirEscalaDoVoo(String partida, String chegada) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de atrasado não pode mudar o horário do voo");
    }

    
}
