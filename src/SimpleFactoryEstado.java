public class SimpleFactoryEstado {

    public static Estado criarEstado(int tipoEstado, Voo voo) {
        if (tipoEstado == 1) {
            return new EstadoCancelado(voo);
        }
        else if(tipoEstado == 2) {
            return new EstadoConfirmado(voo);
        }
        else if (tipoEstado == 3) {
            return new EstadoAtrasado(voo);
        }
        else if (tipoEstado == 4) {
            return new EstadoMudancaDePortao(voo);
        }
        else {
            return null;
        }
    }
    
}
