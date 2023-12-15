import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Repositorio repositorio = Repositorio.getInstance();

        while (true) {
            System.out.println("[1] - Cadastrar voo");
            System.out.println("[2] - Alterar estado do voo");
            System.out.println("[3] - Adicionar passageiro");
            System.out.println("[4] - Remover Passageiro");
            System.out.println("[5] - Mudar portão");
            
            
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            sc.nextLine();
            
            if (opcao == 1) {
                System.out.println("Preencha com as informações da aeronave");
                System.out.print("Nome da aeronave: ");
                String nome = sc.nextLine();
                System.out.print("Quantidade de assentos: ");
                int quantidadeDeAssentos = sc.nextInt();
                sc.nextLine();
                Aeronave aeronave = new Aeronave(nome, quantidadeDeAssentos);

                System.out.println("Preencha com as informações do Voo");
                System.out.print("Informe o identificador do voo: ");
                String id = sc.nextLine();
                System.out.print("Informe o aeroporto de origem: ");
                String origem = sc.nextLine();
                System.out.print("Informe o aeroporto de destino: ");
                String destino = sc.nextLine();
                System.out.print("Informe a data do voo: ");
                String data = sc.nextLine();
                System.out.print("Informe a previsão do horário de partida: ");
                String partida = sc.nextLine();
                System.out.print("Informe a previsão do horário de chegada: ");
                String horario = sc.nextLine();
                System.out.print("Informe o portão de embarque: ");
                String portao = sc.nextLine();

                Voo voo = new Voo(id, origem, destino, data, partida, horario, portao, aeronave);
                repositorio.salvar(voo);
            }
            else if (opcao == 2) {
                System.out.print("Informe o id do Voo: ");
                String id = sc.nextLine();
                Voo voo = repositorio.getVoo(id);

                if (voo == null) {
                    System.out.println("Voo não existe");
                }
                else {

                    System.out.println("Selecione o estado do voo");
                    System.out.println("[1] - Cancelado");
                    System.out.println("[2] - Confirmado");
                    System.out.println("[3] - Atrasado");                
                    System.out.println("[4] - Mudança de portão");
                    System.out.println("[5] - Finalizado");

                    int op = sc.nextInt();
                    sc.nextLine();

                    try {
                        voo.mudarEstado(op);
                        System.out.print("Informe a mensagem de notificação de mudança de voo: ");
                        String mensagem = sc.nextLine();
                        voo.notificarTripulantes(mensagem);
                        if (voo.getEstado() instanceof EstadoAtrasado) {

                            System.out.print("Informe o novo horário de partida: ");
                            String horarioPartida = sc.nextLine();

                            System.out.print("Informe o novo horário de chegada: ");
                            String horarioChegada = sc.nextLine();

                            voo.setPrevisaoHorarioPartida(horarioPartida);

                            voo.setPrevisaoHorarioChegada(horarioChegada);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if(opcao == 3) {
                System.out.print("Informe o id do Voo: ");

                String id = sc.nextLine();

                Voo voo = repositorio.getVoo(id);



                if (voo == null) {
                    System.out.println("Voo não existe");
                }
                else {

                    System.out.println("informe as informações do passageiro");

                    System.out.print("nome do passageiro: ");

                    String nomePassageiro = sc.nextLine();

                    System.out.println("Informe o meio de notificação: ");
                    System.out.println("[1] - SMS ");
                    System.out.println("[2] - EMAIL ");
                    System.out.println("[3] - PushNotification ");
                    
                    int tipoNotificacao = sc.nextInt();
                    sc.nextLine();
                    Notificador notificador = SimpleFactoryNotificador.criarNotificador(tipoNotificacao);

                    Bilhete bilhete = new Bilhete(voo.getPrevisaoHorarioPartida(), voo.getData(), voo.getAeroportoDeOrigem(), voo.getAeroportoDeDestino(), nomePassageiro, voo.getId());

                    Passageiro passageiro = new Passageiro(nomePassageiro, notificador, bilhete);

                    try{
                        voo.adicionarTripulante(passageiro);
                        System.out.println("Passageiro " + nomePassageiro + " cadastrado com sucesso");
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if(opcao == 4) {
                System.out.print("Informe o id do Voo: ");

                String id = sc.nextLine();

                Voo voo = repositorio.getVoo(id);

                if(voo == null) {
                    System.out.println("Voo não existe");
                }
                else {

                    System.out.print("nome do passageiro: ");

                    String nomePassageiro = sc.nextLine();

                    try{
                        voo.removerTripulante(nomePassageiro);
                        System.out.println("Passageiro " + nomePassageiro +  " removido");
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if (opcao == 5) {
                System.out.print("Informe o id do voo: ");
                String id = sc.nextLine();
                System.out.print("Informe o portão de embarque: ");
                String portao = sc.nextLine();
                Voo voo = repositorio.getVoo(id);
                
                if (voo == null) {
                    System.out.println("Voo não existe");
                }
                else {
                    try {
                        voo.trocarPortaoDeEmbarque(portao);
                        System.out.println("Portão trocado com sucesso");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } 
    }
}
