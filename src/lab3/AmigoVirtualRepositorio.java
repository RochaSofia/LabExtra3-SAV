package lab3;

import java.util.Scanner;

/**
 * Classe responsável por manter um conjunto de dados referentes ao SAV e realizar as operações.
 */
public class AmigoVirtualRepositorio {

    private AmigoVirtual[] amigos;

    public AmigoVirtualRepositorio() {
        this.amigos = new AmigoVirtual[1000];
    }

    /**
     * Menu à ser exibido.
     */
    public void intro() {
        System.out.println("-- Amigo Virtual --");
        System.out.println("(C)adastrar");
        System.out.println("(E)xibir");
        System.out.println("(P)rocurar");
        System.out.println("(V)erificar Repeticoes");
        System.out.println("-- Outros --");
        System.out.println("(S)air");
        System.out.println();
        System.out.print("Opcao> ");
    }

    /**
     * Método para cadastrar.
     * É pedido posição, nome, ID e anotações. Podendo serem os campos de nome, ID e anotações vazios.
     * Se a posição for entre 0 e 999, o cadastro é realizado. Sendo exibida a mensagem "CADASTRO REALIZADO".
     * Caso não, será exibida a mensagem "POSICAO INVALIDA".
     * Se já existir um AV na posição, o mesmo é substituido.
     */
    public void cadastrar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Posicao: ");
        int posicao = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        if (nome == null) nome = "";
        System.out.print("ID: ");
        String id = sc.nextLine();
        if (id == null) id = "";
        System.out.print("Anotacoes: ");
        String anotacoes = sc.nextLine();
        if (anotacoes == null) anotacoes = "";
        if (posicao <= 999) {
            AmigoVirtual novo = new AmigoVirtual(posicao, nome, id, anotacoes);
            this.amigos[posicao] = novo;
            System.out.println("CADASTRO REALIZADO!\n");
        }
        else{
            System.out.println("POSICAO INVALIDA!\n");
        }
    }

    /**
     * Método para exibir.
     * É pedido o número(posição) entre 0 e 999.
     * Se for passado um número que não esteja englobado ou uma uma posição vazia, será exibida a mensagem "POSICAO INVALIDA".
     * Caso tenha um AV na posição, são exibidos os seus dados.
     */
    public void exibir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero> ");
        int posicao = sc.nextInt();
        sc.nextLine();
        System.out.println();
        if (this.amigos[posicao] == null || posicao > 999) {
            System.out.println("POSICAO INVALIDA!\n");
        }
        else System.out.println(this.amigos[posicao].toString() + "\n");
    }

    /**
     * Método para procurar.
     * É pedido o nome e o ID. Podendo os campos serem vazios.
     * Caso tenha AVs com o nome e ID apresentados, serão exibidos em ordem.
     * Caso não, não é exibido nada.
     */
    public void procurar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome> ");
        String nome = sc.nextLine();
        System.out.print("ID> ");
        String id = sc.nextLine();
        System.out.println();

        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] != null) {
                String nomeObj = this.amigos[i].getNome();
                String idObj = this.amigos[i].getId();
                if (nomeObj.contains(nome) && idObj.contains(id)) {
                    int posicaoObj = this.amigos[i].getPosicao();
                    System.out.println(posicaoObj + " -- " + nomeObj + " -- " + idObj);
                }
            }
        }
        System.out.println();
    }

    /**
     * Método para verificar repetição.
     * Todos os AVs que apresentarem duplicatas(nome e ID iguais) em posições subsequentes serão exibidos.
     */
    public void verificaRepeticao() {
        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] == null) continue;
            String saida = "";
            for (int j = i + 1; j < this.amigos.length; j++) {
                if (this.amigos[j] == null) continue;
                if (this.amigos[i].equals(this.amigos[j])) {
                    if (saida.equals("")) {
                        saida += this.amigos[j].getPosicao();
                    }
                    else saida += ", " + this.amigos[j].getPosicao();
                }
            }
            if (!saida.equals("")) {
                String nomeObj = this.amigos[i].getNome();
                String idObj = this.amigos[i].getId();
                int posicaoObj = this.amigos[i].getPosicao();
                System.out.println(posicaoObj + " -- " + nomeObj + " -- " + idObj);
                System.out.println("Duplicatas: " + saida +"\n");
            }
        }
    }
}
