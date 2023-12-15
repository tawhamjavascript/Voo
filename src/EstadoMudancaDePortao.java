public class EstadoMudancaDePortao implements Estado{
    private Voo voo;

    
    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException{
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoFinalizado) {
            voo.setEstado(estado);
            estado.setVoo(voo);
            estado.notificarTripulantes();
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
    public void removerTripulante(String tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de Mudança de Portão não pode remover um passageiro");
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        voo.setPortaoDeEmbarque(portao);
    }
    
    @Override
    public void setVoo(Voo voo) {
        // TODO Auto-generated method stub
        this.voo = voo;

    }

    @Override
    public void notificarTripulantes() {
        // TODO Auto-generated method stub
        this.voo.notificarTripulantes("O voo mudou de portão");

    }
}
