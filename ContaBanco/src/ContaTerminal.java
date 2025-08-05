import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        double saldo = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, informe o número da conta: xxxx");
        int numeroConta = scanner.nextInt();

        System.out.println("Por favor, informe o número da agência: xxx-x");
        String numeroAgencia = scanner.next();

        scanner.nextLine();

        System.out.println("Por favor, informe o nome completo do titular da conta: ");
        String nomeTitular = scanner.nextLine();

        System.out.printf("Olá %s, obrigada por criar uma conta em nosso banco, sua agência é %s, conta %d. Atualmente seu saldo é de R$%.2f.\n", nomeTitular, numeroAgencia, numeroConta, saldo);

        System.out.println("");

        System.out.println("Gostaria de fazer um depósito? (Responda 's' para realizar depósito ou 'n' para finalizar sessão.)");
        String respostaDeposito = scanner.next();

        if (respostaDeposito.equals("s")) {
            System.out.println("Informe o valor que deseja depositar: ");
            double deposito = scanner.nextDouble();

            saldo += deposito;

            System.out.println("Depósito realizado com sucesso!");

            System.out.println("");

            System.out.printf("Agora seu saldo é de R$%.2f e já está disponível para saque.\n", saldo);

            System.out.println("");

            System.out.println("Gostaria de realizar um saque? (Responda 's' para realizar saque ou 'n' para finalizar sessão.)");
            String respostaSaque = scanner.next();

            if (respostaSaque.equals("s")) {
                System.out.println("Informe o valor que deseja sacar: ");
                double saque = scanner.nextDouble();

                if (saque <= saldo) {
                    saldo -= saque;
                    System.out.printf("Valor sacado com sucesso. Agora seu saldo é de: R$%.2f\n", saldo);
                    System.out.println("Sessão finalizada!");
                } else {
                    System.out.println("Saldo insuficiente para realizar o saque.");
                    System.out.println("Sessão finalizada!");
                }
            } else {
                System.out.println("Sessão finalizada!");
            }
        } else {
            System.out.println("Sessão finalizada!");
        }

        scanner.close();
    }
}
