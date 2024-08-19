package org.brmgf;

import org.brmgf.exception.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = getParametroInteiro(scanner);

        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = getParametroInteiro(scanner);

        try {
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            System.out.println(exception.getMessage());
        }

        scanner.close();
    }

    private static int getParametroInteiro(Scanner scanner) {
        while (true) {
            try {
                return Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Valor digitado inválido. Por favor, digite um valor numérico: ");
            }
        }
    }

    private static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int quantidadeVezes = parametroDois - parametroUm;
        for (int i = 1; i <= quantidadeVezes; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}