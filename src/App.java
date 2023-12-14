import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Repositorio repositorio = Repositorio.getInstance();

        while (true) {
            System.out.println("[1] - Cadastrar voo");
            System.out.println("[2] - Mudar portão");
            System.out.println("[3] - Cancelar voo");
            System.out.println("[4] - Informar estado do voo");
            System.out.println("[5] - Adicionar passageiro");
            System.out.println("[6] - Remover Passageiro");

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

            else if(opcao == 5) {
                System.out.print("Informe o id do Voo: ");

                String id = sc.next();

                Voo voo = repositorio.getVoo(id);

                System.out.println("informe as informações do passageiro");

                System.out.print("nome do passageiro: ");

                String nomePassageiro = sc.next();

                System.out.println("Informe o meio de notificação: ");
                System.out.println("[1] - SMS ");
                System.out.println("[2] - EMAIL ");
                System.out.println("[3] - PushNotification ");
                
                int tipoNotificacao = sc.nextInt();
                Notificador notificador = SimpleFactoryNotificador.criarNotificador(tipoNotificacao);

                Bilhete bilhete = new Bilhete(voo.previsaoHorarioPartida, voo.data, voo.aeroportoDeOrigem, voo.aeroportoDeDestino, nomePassageiro, voo.getId());

                Passageiro passageiro = new Passageiro(nomePassageiro, notificador, bilhete);

                try{
                    voo.adicionarTripulante(passageiro);
                }
                catch(UnsupportedOperationException e) {
                    System.out.println(e.getMessage());
                }
            }

            else if(opcao == 6) {
                System.out.print("Informe o id do Voo: ");

                String id = sc.next();

                Voo voo = repositorio.getVoo(id);

                System.out.print("nome do passageiro: ");

                String nomePassageiro = sc.next();

                try{
                    Tripulante tripulante = voo.procurarTripulante(nomePassageiro);
                    if(tripulante == null) {
                        System.out.println("Tripulante não existe");
                    }
                    else {
                        voo.removerTripulante(tripulante);

                    }
                }
                catch(UnsupportedOperationException e) {
                    System.out.println(e.getMessage());
                }
            }
        } 
    }
}
