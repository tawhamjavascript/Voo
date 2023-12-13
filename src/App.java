import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Repositorio repositorio = Repositorio.getInstance();

        while (true) {
            System.out.println("[1] - Cadastrar voo");
            System.out.println("[2] - Mudar portão");
            System.out.println("[3] - Cancelar voo");
            System.out.println("[4] - Informar estado do voo");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println("Preencha com as informações da aeronave");
                System.out.print("Nome da aeronave: ");
                String nome = sc.next();
                System.out.print("Quantidade de assentos: ");
                int quantidadeDeAssentos = sc.nextInt();
                Aeronave aeronave = new Aeronave(nome, quantidadeDeAssentos);

                System.out.println("Preencha com as informações do Voo");
                System.out.print("Informe o identificador do voo: ");
                String id = sc.next();
                System.out.print("Informe o aeroporto de origem: ");
                String origem = sc.next();
                System.out.print("Informe o aeroporto de destino: ");
                String destino = sc.next();
                System.out.print("Informe a data do voo: ");
                String data = sc.next();
                System.out.print("Informe a previsão do horário de partida: ");
                String partida = sc.next();
                System.out.print("Informe a previsão do horário de chegada: ");
                String horario = sc.next();
                System.out.print("Informe o portão de embarque: ");
                String portao = sc.next();

                Voo voo = new Voo(id, origem, destino, data, partida, horario, portao, aeronave);
                repositorio.salvar(voo);
            }
            else if (opcao == 2) {
                System.out.print("Informe o id do voo: ");
                String id = sc.next();
                System.out.print("Informe o portão de embarque: ");
                String portao = sc.next();
                Voo voo = repositorio.getVoo(id);
                
                if (voo == null) {
                    System.out.println("Voo não existe");
                }
                else {
                    try {
                        voo.trocarPortaoDeEmbarque(portao);    
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if (opcao == 3) {
                System.out.print("Informe o id do Voo: ");
                String id = sc.next();
                Voo voo = repositorio.getVoo(id);
                try {
                    voo.mudarEstado(1);
                } catch (EstadoErradoException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (opcao == 4) {
                System.out.print("Informe o id do Voo: ");
                String id = sc.next();
                Voo voo = repositorio.getVoo(id);

                System.out.println("Informe o estado do voo");
                System.out.println("[2] - Confirmado");
                System.out.println("[3] - Atrasado");                
                System.out.println("[4] - Mudança de portão");

                int op = sc.nextInt();

                try {
                    voo.mudarEstado(op);
                } catch (EstadoErradoException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        
    }
}
