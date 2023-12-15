

public class EstadoProgramado implements Estado {

    private Voo voo;

    public EstadoProgramado (Voo voo) {
        this.voo = voo;
    }

    @Override
    public void trocarEstado(int tipoEstado) throws EstadoErradoException {
        // TODO Auto-generated method stub
        Estado estado = SimpleFactoryEstado.criarEstado(tipoEstado);
        if (estado instanceof EstadoConfirmado) {
            voo.setEstado(estado);
            estado.setVoo(voo);

        }
        else {
            throw new EstadoErradoException();
        }
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException, AviaoCheioException {
        // TODO Auto-generated method stub
        if(!voo.estaCheio()) {
            voo.addTripulante(tripulante);

        }
        else {
            throw new AviaoCheioException();
        }

    }

    @Override
    public void removerTripulante(String nome) throws UnsupportedOperationException, ObjectNotFound {
        // TODO Auto-generated method stub
        Tripulante tripulante = this.voo.procurarTripulante(nome);

        if (tripulante == null) {
            throw new ObjectNotFound("Passageiro " + nome + " não encontrado");
        }
        else {
            this.voo.removerTripulante(tripulante);
        }
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao ) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de programado não pode trocar o portão");
    }

    @Override
    public void setVoo(Voo voo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVoo'");
    }

}
