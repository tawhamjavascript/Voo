import java.util.ArrayList;
import java.util.List;

public class Voo {

    public String id;

    public List<Tripulante> tripulantes = new ArrayList<Tripulante>();

    public Estado estado;

    public String aeroportoDeOrigem;

    public String aeroportoDeDestino;

    public String data;

    public String previsaoHorarioPartida;

    public String previsaoHorarioChegada;

    public String portaoDeEmbarque;

    public Aeronave aeronave;



    public Voo(String id, String aeroportoDeOrigem, String aeroportoDeDestino, String data,
            String previsaoHorarioPartida, String previsaoHorarioChegada, String portaoDeEmbarque, Aeronave aeronave) {

        this.id = id;
        this.aeroportoDeOrigem = aeroportoDeOrigem;
        this.aeroportoDeDestino = aeroportoDeDestino;
        this.data = data;
        this.previsaoHorarioPartida = previsaoHorarioPartida;
        this.previsaoHorarioChegada = previsaoHorarioChegada;
        this.portaoDeEmbarque = portaoDeEmbarque;
        this.aeronave = aeronave;
        this.estado = new EstadoProgramado(this);

    }

    public void notificarTripulantes(String message) {
        this.tripulantes.forEach((tripulante) -> tripulante.notificar(message));
    }

    public void mudarEstado(int tipoEstado) throws EstadoErradoException {
        try {
            estado.trocarEstado(tipoEstado);    
        } catch (EstadoErradoException e) {
            throw e;
        }
        

    }

    public void adicionarTripulante(Tripulante tripulante) throws UnsupportedOperationException{
        this.estado.adicionarTripulante(tripulante);
    }

    public void removerTripulante(Tripulante tripulante) throws UnsupportedOperationException{
        this.estado.removerTripulante(tripulante);
    }
    
    public Tripulante procurarTripulante (String nome) {
        Tripulante result = null;
        for (Tripulante tripulante: tripulantes) {
            if (tripulante.getNome().equals(nome)) {
                result = tripulante;
                break;
            }
        }
        return result;
    }
    public boolean estaCheio() {
        return this.aeronave.getQuantidadeDeAssentos() == this.tripulantes.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addTripulante(Tripulante tripulante) {
        this.tripulantes.add(tripulante);
    }

    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getAeroportoDeOrigem() {
        return aeroportoDeOrigem;
    }

    public void setAeroportoDeOrigem(String aeroportoDeOrigem) {
        this.aeroportoDeOrigem = aeroportoDeOrigem;
    }

    public String getAeroportoDeDestino() {
        return aeroportoDeDestino;
    }

    public void setAeroportoDeDestino(String aeroportoDeDestino) {
        this.aeroportoDeDestino = aeroportoDeDestino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrevisaoHorarioPartida() {
        return previsaoHorarioPartida;
    }

    public void setPrevisaoHorarioPartida(String previsaoHorarioPartida) {
        this.previsaoHorarioPartida = previsaoHorarioPartida;
    }

    public String getPrevisaoHorarioChegada() {
        return previsaoHorarioChegada;
    }

    public void setPrevisaoHorarioChegada(String previsaoHorarioChegada) {
        this.previsaoHorarioChegada = previsaoHorarioChegada;
    }

    public String getPortaoDeEmbarque() {
        return portaoDeEmbarque;
    }

    public void setPortaoDeEmbarque(String portaoDeEmbarque) {
        this.portaoDeEmbarque = portaoDeEmbarque;
    }

    public void trocarPortaoDeEmbarque(String portaoDeEmbarque) throws UnsupportedOperationException {
        try {
            this.estado.trocarPortaoDeEmbarque(portaoDeEmbarque);            
        } catch (UnsupportedOperationException e) {
            throw e;
        }
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    
    
}
