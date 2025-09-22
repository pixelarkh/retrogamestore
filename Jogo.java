//classe pai, essa classe vai ser a base do nosso sistema, vai ser o molde para criar outros objetos do tipo jogo.
public class Jogo {
    //Atributos
    //private indica que só a propria classe pode acessar
    public  String id; //id do jogo, vamos usar para buscar o jogo para deleta-lo da lista através do botão remover jogo
    private String titulo; //nome do jogo
    private String plataforma; //plataforma (Ex: Snes, MegaDrive, Playstation, Xbox, PC)
    private double preco; //preço do jogo (usei double porque preços podem ter centavos e int só trabalha com inteiros.

    //Construtor
    //chamado sempre que criamos um objeto do tipo Jogo e recebe os valores dos atributos do jogo.
    public Jogo(String id, String titulo, String plataforma, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.preco = preco;
    }

    // Getters e Setters
    //métodos públicos para acessar e modificar atributos privados (encapsulamento)
    public  String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    // Método polimórfico
    // Este método será sobrescrito (override) nas classes filhas para mostrar as informações de forma diferente. (polimorfismo)
    public String getDescricao() {
        return "ID:" + id + "Título: " + titulo + " | Plataforma: " + plataforma + " | Preço: R$" + preco;
    }

    // toString()
    // Quando tentamos imprimir o objeto Jogo, o Java chama este método automaticamente.
    // Usamos getDescricao() para mostrar as informações formatadas.
    @Override
    public String toString() {
        return getDescricao();
    }
}
