public class SimpleFactoryEstado {

    public static Estado criarEstado(int tipoEstado) {
        if (tipoEstado == 1) {
            return new EstadoCancelado();
        }
        else if(tipoEstado == 2) {
            return new EstadoConfirmado();
        }
        else if (tipoEstado == 3) {
            return new EstadoProgramado();
        }
        else if (tipoEstado == 4) {
            return new EstadoMudancaDePortao();
        }
    }
    
}
