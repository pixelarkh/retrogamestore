// Esta é uma "subclasse" da classe Jogo, ou seja ela vai herdar todos os atributos e métodos da classe pai (Jogo).
// "Extends" quer dizer que a classe herda de outra.
public class JogoDigital extends Jogo {

    // Além de título, plataforma e preço, um jogo físico precisa ter um controle de estoque.
    private int chaveAtivacao;

    //Recebe dados necessários para criar um objeto JogoDigital
    //"super" passa os valores que pertencem a classe pai (Jogo).
    public JogoDigital(String id, String titulo, String plataforma, double preco, int chaveAtivacao) {
        super(id, titulo, plataforma, preco);
        this.chaveAtivacao = chaveAtivacao;
    }

    //Getter e Setter
    public int getChaveAtivacao() { return chaveAtivacao; }
    public void setChaveAtivacao(int chaveAtivacao) { this.chaveAtivacao = chaveAtivacao; }

    //Polimorfismo aplicado para alterar o comportamento do método herdado
    @Override
    public String getDescricao() {
        return "[DIGITAL] " + super.getDescricao() + " | Quantidade: " + chaveAtivacao;
    }
}
