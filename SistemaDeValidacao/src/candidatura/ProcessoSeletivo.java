package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        List<String> selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);

        for (String candidato : selecionados) {
            entrandoEmContato(candidato);
        }

    }

    //processos

    static List<String> selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        List<String> selecionados = new ArrayList<>();

        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (selecionados.size() < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("Candidato %s solicitou R$ %.2f de salário.%n", candidato, salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                selecionados.add(candidato);
            } else {
                System.out.println("O candidato " + candidato + " NÃO foi selecionado para a vaga.");
            }
            candidatoAtual++;
        }

        return selecionados;
    }

    static void imprimirSelecionados(List<String> selecionados) {
        System.out.println("\n Lista de candidatos selecionados:");

        for (int i = 0; i < selecionados.size(); i++) {
            System.out.println((i + 1) + ". " + selecionados.get(i));
        }
        System.out.println("--------------------------------------------------\n");
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean atendeu = false;

        System.out.println("Tentando contato com " + candidato + "...");

        do {
            atendeu = atender();

            if (!atendeu) {
                System.out.println("Tentativa " + tentativasRealizadas + ": Não atendeu.");
                tentativasRealizadas++;
            } else {
                System.out.println("Tentativa " + tentativasRealizadas + ": Contato realizado com sucesso!");
            }

        } while (!atendeu && tentativasRealizadas <= 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " após " + tentativasRealizadas + " tentativa(s).\n");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + " após " + (tentativasRealizadas - 1) + " tentativas.\n");
        }
    }

    //métodos de apoio
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
        } else {
            System.out.println("AGUARDAR O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}




