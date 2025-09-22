import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

// Classe principal que representa a janela do sitema.
// Usamos Swing para criar a interface gráfica.
public class Main extends JFrame {
    // Lista que armazena os jogos que vamos cadastrar
    private final ArrayList<Jogo> estoque = new ArrayList<>();

    //construtor com as configurações da janela principal (titulo, tamanho, fechamento e componentes na tela)
    public Main() {
        setTitle("Game Retro Store - Estoque"); // titulo da janela
        setSize(800, 600); //tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha o programa clicando no "X"
        setLocationRelativeTo(null); //Centraliza a janela

        // Painel principal com BorderLayout
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adiciona imagem no topo
        ImageIcon logo = new ImageIcon("logo.png"); // imagem deve estar na mesma pasta do projeto
        JLabel labelLogo = new JLabel(logo);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER); //centraliza a imagem no topo
        painelPrincipal.add(labelLogo, BorderLayout.NORTH);

        // Painel de botões
        JPanel painelBotoes = new JPanel();

        // GridLayout(1, 5) -> 1 linha, 5 colunas, espaçamento de 6px entre os botões
        painelBotoes.setLayout(new GridLayout(1, 5, 6, 6));
        
        // Criação dos botões
        JButton btnAdd = new JButton("Adicionar Jogo");
        JButton btnListar = new JButton("Consultar Estoque");
        JButton btnBuscar = new JButton("Pesquisar Jogo");
        JButton btnRemover = new JButton("Remover Jogo");
        JButton btnSair = new JButton("Sair");
 
        // Associa cada botão à sua ação
        btnAdd.addActionListener(e -> adicionarJogo());
        btnListar.addActionListener(e -> listarJogos());
        btnBuscar.addActionListener(e -> buscarJogo());
        btnRemover.addActionListener(e -> removerJogo());
        btnSair.addActionListener(e -> System.exit(0));

        // Adiciona os botões no painel
        painelBotoes.add(btnAdd);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnSair);

        // Posiciona o painel do centro da janela
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);

        // Adiciona tudo na janela principal e a seta para visivel
        add(painelPrincipal);
        setVisible(true);
    }

    // Método que abre uma caixa de diálogo para cadastrar um novo jogo.
    private void adicionarJogo() {
        try {
            // Solicita dados básicos do jogo
            String id = JOptionPane.showInputDialog(this, "Id do jogo:"); // agora é String
            if (id == null || id.isBlank()) return; // cancela se nada for digitado

            String titulo = JOptionPane.showInputDialog(this, "Título do jogo:");
            if (titulo == null || titulo.isBlank()) return;

            String plataforma = JOptionPane.showInputDialog(this, "Plataforma:");
            if (plataforma == null || plataforma.isBlank()) return;

            double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Preço:"));

            // Escolha tipo de mídia entre Físico ou Digital
            String[] tipos = {"Físico", "Digital"};
            String tipo = (String) JOptionPane.showInputDialog(this, "Tipo de Jogo:",
                    "Escolha", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
            if (tipo == null) return;

            // Cria o objeto de acordo com o tipo
            if (tipo.equals("Físico")) {
                int qtd = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade em estoque:"));
                estoque.add(new JogoFisico(id, titulo, plataforma, preco, qtd));
            } else {
                int chave = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantidade em estoque:"));
                estoque.add(new JogoDigital(id, titulo, plataforma, preco, chave));
            }

            JOptionPane.showMessageDialog(this, "Jogo adicionado com sucesso!");
        } catch (NumberFormatException ex) {
            // Trata erro caso o usuário digite algo inesperado
            JOptionPane.showMessageDialog(this, "Erro: preço ou quantidade inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Trata qualquer outro erro
            JOptionPane.showMessageDialog(this, "Erro ao adicionar jogo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Exibir todos os jogos adicionados no estoque em uma janela de texto.
    private void listarJogos() {
        if (estoque.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Estoque vazio.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Jogo j : estoque) {
            sb.append(j).append("\n");
        }
        // Usa JTextArea para mostrar o texto formatado e JScrollPane para permitir rolagem
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Estoque", JOptionPane.INFORMATION_MESSAGE);
    }

    // Buscar jogo pelo titulo ou por parte dele
    private void buscarJogo() {
        String titulo = JOptionPane.showInputDialog(this, "Digite o nome do jogo:");
        if (titulo == null || titulo.isBlank()) return; // Cancela se nada for digitado

        String termo = titulo.toLowerCase(); // converte para minúsculo para busca case-insensitive
        StringBuilder sb = new StringBuilder();

        for (Jogo j : estoque) {
            if (j.getTitulo().toLowerCase().contains(termo)) { // busca parcial
                sb.append(j).append("\n");
            }
        }


        if (sb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum jogo encontrado para: " + titulo);
        } else {
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea),
                    "Resultados da busca", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // Remover jogo pelo ID, apenas 1 unidade do estoque
    private void removerJogo() {
        try {
            String id = JOptionPane.showInputDialog(this, "Digite o ID para remover:");

            for (Jogo j : estoque) {
                if (Objects.equals(j.getId(), id)) {
                    // Se for jogo físico, reduz 1 da quantidade
                    if (j instanceof JogoFisico) {
                        JogoFisico jf = (JogoFisico) j;
                        if (jf.getQuantidadeEmEstoque() > 1) {
                            jf.setQuantidadeEmEstoque(jf.getQuantidadeEmEstoque() - 1);
                            JOptionPane.showMessageDialog(this, "Uma unidade removida. Restam " + jf.getQuantidadeEmEstoque() + " no estoque.");
                        } else {
                            estoque.remove(jf); // Remove totalmente se só tinha 1
                            JOptionPane.showMessageDialog(this, "Última unidade removida. Jogo retirado do estoque.");
                        }
                    } else {
                        // Se for jogo digital, removemos o objeto inteiro (não há estoque físico)
                        estoque.remove(j);
                        JOptionPane.showMessageDialog(this, "Jogo digital removido do estoque.");
                    }
                    return; // encerra após remover
                }
            }
            JOptionPane.showMessageDialog(this, "Jogo com ID " + id + " não encontrado.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        new Main();
    } // Cria a janela e inicia o programa.
}
