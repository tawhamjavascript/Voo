public class EstadoConfirmado implements Estado{

    private Voo voo;

    public EstadoConfirmado () {
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException {
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoCancelado || estado instanceof EstadoAtrasado || estado instanceof EstadoMudancaDePortao || estado instanceof EstadoFinalizado) {
            voo.setEstado(estado);
            estado.setVoo(voo);

        }
        else {
            throw new EstadoErradoException();
        }
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado confirmado não pode adicionar passageiro");
    }

    @Override
    public void removerTripulante(String tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado confirmado não pode remover Tripulante");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estato de confirmado não pode trocar portão de embarque");
    }

    @Override
    public void setVoo(Voo voo) {
        // TODO Auto-generated method stub
        this.voo = voo;

    }

   
}
