public class EstadoConfirmado implements Estado{

    private Voo voo;

    public EstadoConfirmado (Voo voo) {
        this.voo = voo;
        voo.notificarTripulantes("O voo está confirmado");
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException {
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado, this.voo);
        if (estado instanceof EstadoCancelado || estado instanceof EstadoAtrasado || estado instanceof EstadoMudancaDePortao) {
            voo.setEstado(estado);
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
    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado confirmado não pode remover Tripulante");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estato de confirmado não pode trocar portão de embarque");
    }

    @Override
    public void definirEscalaDoVoo(String partida, String chegada) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de confirmado não pode definir escala de voo");
    }

    
}
