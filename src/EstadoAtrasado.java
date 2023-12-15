public class EstadoAtrasado implements Estado {
    private Voo voo;

    public EstadoAtrasado () {
        
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException{
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoFinalizado || estado instanceof EstadoCancelado) {
            voo.setEstado(estado);
            estado.setVoo(voo);
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
    public void removerTripulante(String tripulante) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de atrasado não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de atrasado não pode trocar o portão");
    }

    @Override
    public void setVoo(Voo voo) {
        // TODO Auto-generated method stub
        this.voo = voo;
    }

    
}
