package lab3;

/**
 * Classe responsável pela construção dos AVs e administração de seus métodos.
 */
public class AmigoVirtual {

    private int posicao;
    private String nome;
    private String id;
    private String anotacoes;

    public AmigoVirtual(int posicao, String nome, String id, String anotacoes) {
        this.posicao = posicao;
        this.nome = nome;
        this.id = id;
        this.anotacoes = anotacoes;
    }

    /**
     * Método de exibição dos dados da classe para CLI.
     * @return String
     */
    @Override
    public String toString() {
        String anotacao = this.anotacoes.trim(); //são tirados os espaços
        if (!anotacao.equals("")) {
            return this.posicao + " -- " + this.nome + " -- " + this.id + "\nAnotações: " + this.anotacoes;
        }
        return this.posicao + " -- " + this.nome + " -- " + this.id;
    }

    /**
     * Método que retorna o nome.
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que retorna o ID.
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Método que retorna a posição.
     * @return posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * Método para comparar se o nome e o ID dos AVs são iguais.
     * @param objeto o amigo virtual a ser comparado com o outro.
     * @return boolean
     */
    public boolean equals(AmigoVirtual objeto) {
        if (this.nome.equals(objeto.getNome()) && this.id.equals(objeto.getId())) return true;
        else return false;
    }
}