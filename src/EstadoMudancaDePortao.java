public class EstadoMudancaDePortao implements Estado{
    private Voo voo;

    public EstadoMudancaDePortao (Voo voo) {
        this.voo = voo;
        this.voo.notificarTripulantes("O voo mudou de portão");
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException{
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoConfirmado) {
            voo.setEstado(estado);
        }
        else {
            throw new EstadoErradoException();
        }
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Mudança de Portão não pode adicionar passageiro");
    }

    @Override
    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Mudança de Portão não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        voo.setPortaoDeEmbarque(portao);
    }

    @Override
    public void definirEscalaDoVoo(String partida, String chegada) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'definirEscalaDoVoo'");
    }
    
}
