# Retro Game Store

Sistema de gerenciamento de estoque essencial para controle de inventário.

## Funcionalidades

- Organização de jogos  
- Controle eficaz de estoque  
- Planejamento de reposições  
- Identificação e informação dos jogos  
- Pesquisa por nome  
- Remoção de itens  

## Tecnologias Usadas

- **Java**
- **Swing** (Interface gráfica)
- **Collections** (ArrayList)

## Recomendações para Instalação e Execução

1. Recomendo usar **VS Code** ou **IntelliJ IDEA** para abrir a pasta do projeto e rodar o `Main.java`.  
2. Instale o **Adoptium Temurin - JDK**:  
   [Site Oficial](https://adoptium.net/temurin/releases/)  
   *(ou procure por “Adoptium Temurin JDK” no Google)*  

## Como Usar

### Adicionar Jogo
- **ID do jogo:** informe a ID do jogo (Ex: `SNES01`)  
- **Título do jogo:** informe o nome do jogo (Ex: `Super Mario`)  
- **Plataforma:** (Ex: `SNES`)  
- **Preço:** valor do jogo  
- **Tipo de jogo:** escolha entre `Físico` ou `Digital`  
- **Quantidade em estoque:** informe a quantidade  

### Consultar Estoque
Mostra a lista de jogos adicionados no estoque com todas as informações preenchidas.  

### Pesquisar Jogo
Digite o **nome do jogo** (ou parte dele) para filtrar e encontrar rapidamente.  

### Remover Jogo
Digite o **ID** para remover:  
- Se for um jogo físico, remove **uma unidade** por vez.  
- Se for um jogo digital, remove completamente do estoque.  

### Sair
Fecha o programa.  

---

*Dica:* Mantenha seu estoque organizado e atualizado para facilitar o controle e evitar falta de produtos.
