import java.util.List;

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
        }
        else {
            throw new EstadoErradoException();
        }
    }

    @Override
    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        voo.addTripulante();
    }

    @Override
    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        List<Tripulante> tripulantes = voo.getTripulantes();
        tripulantes.remove(tripulante);
    }

    @Override
    public void trocarPortaoDeEmbarque(String portao ) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Estado de programado não pode trocar o portão");
    }

    @Override
    public void definirEscalaDoVoo(String partida, String chegada) throws UnsupportedOperationException {
        // TODO Auto-generated method stub
       voo.setPrevisaoHorarioPartida(partida); 
       voo.setPrevisaoHorarioChegada(chegada);
    }
    
}
