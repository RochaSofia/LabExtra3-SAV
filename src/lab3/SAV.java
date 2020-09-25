package lab3;

import java.util.Scanner;

/**
 * Classe que lida com o funcionamento do programa.
 * @author Mariane Silva de Carvalho
 *
 * O sistema de amigos virtuais (SAV) é um projeto que visa organizar os amigos virtuais (AV) de uma pessoa.
 * No SAV, é possível cadastrar amigos virtuais, consultar, procurar por esses amigos e verificar duplicatas nesses amigos.
 * Cada amigo virtual é identificado por um número, nome, id virtual e comentários.
 * O sistema pode ter até 1000 AVs identificados por valores entre 0 e 999 (inclusive).
 * Interage com o usuário através de uma interface de comandos de texto (ou, CLI -- Command Line Interface).
 */

public class SAV {

    public static void main(String[] args) {

        AmigoVirtualRepositorio repositorio = new AmigoVirtualRepositorio();

        Scanner sc = new Scanner(System.in);

        while (true) {
            repositorio.intro();
            String opcao = sc.nextLine().toUpperCase();
            System.out.println();
            if (!"CEPVS".contains(opcao) || opcao.length() > 1) {
                System.out.println("OPCAO INVALIDA!\n");
            }
            else if (opcao.equals("S")) break;
            else if (opcao.equals("C")) repositorio.cadastrar();
            else if (opcao.equals("E")) repositorio.exibir();
            else if (opcao.equals("P")) repositorio.procurar();
            else if (opcao.equals("V")) repositorio.verificaRepeticao();

        }
    }
}