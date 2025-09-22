//Esta é uma "subclasse" da classe Jogo, ou seja ela vai herdar todos os atributos e métodos da classe pai (Jogo).
//"Extends" quer dizer que a classe herda de outra.
public class JogoFisico extends Jogo {

    // Além de título, plataforma e preço, um jogo físico precisa ter um controle de estoque.
    private int quantidadeEmEstoque;

    //Recebe dados necessários para criar um objeto JogoFisico
    //"super" passa os valores que pertencem a classe pai (Jogo).
    public JogoFisico(String id, String titulo, String plataforma, double preco, int quantidade) {
        super(id, titulo, plataforma, preco);
        this.quantidadeEmEstoque = quantidade;
    }

    // GETTER e SETTER
    // Métodos para acessar e alterar a quantidade em estoque de forma controlada.
    public int getQuantidadeEmEstoque() { return quantidadeEmEstoque; }

    public void setQuantidadeEmEstoque(int quantidade) { this.quantidadeEmEstoque = quantidade; }

    //Polimorfismo aplicado para alterar o comportamento do método herdado
    @Override
    public String getDescricao() {
        return "[FÍSICO] " + super.getDescricao() + " | Quantidade: " + quantidadeEmEstoque;
    }
}
