import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Informe o primeiro número inteiro: ");
        int n1 = terminal.nextInt();

        System.out.println("Informe o segundo número inteiro: ");
        int n2 = terminal.nextInt();

        try{
            contar(n1, n2);
        } catch(contador.ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    static void contar (int n1, int n2) throws contador.ParametrosInvalidosException {

        if (n1 > n2) {
            throw new contador.ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = n2 - n1;

        for (int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o número: " + (i + 1));
        }
    }
}
