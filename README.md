Informações Gerais sobre o Projeto

Este projeto é um sistema de locadora simples, desenvolvido em Java, que permite o cadastro, listagem, empréstimo e devolução de itens do tipo Livro e Filme.
O objetivo principal é gerenciar os itens disponíveis para empréstimo, registrar os empréstimos realizados e possibilitar a remoção de itens do sistema.
O sistema é orientado a objetos, persistindo os dados em arquivos de texto para manter o estado entre as execuções.

Funcionalidades principais:

Cadastrar livros e filmes com informações específicas (autor, diretor, gênero, etc).
Listar todos os itens cadastrados ou filtrados por tipo (livros/filmes).
Realizar empréstimos e devoluções dos itens.
Remover itens do sistema.
Persistir os dados em arquivo texto para manter o histórico entre sessões.

Informações sobre as Classes e suas Relações:

O projeto possui as seguintes principais classes:
Item(abstract): Classe base abstrata para representar um item da locadora. Possui atributos comuns como título, código e status de empréstimo (emprestado).
Métodos abstratos como toText() para serialização e método estático fromText() para desserialização.
Livro: Subclasse de Item que representa um livro. Possui atributos específicos como autor, gênero e ISBN.
Filme: Subclasse de Item que representa um filme. Possui atributos como diretor, gênero e duração.
Locavel (interface): Interface que pode ser implementada por classes que têm comportamento de empréstimo. Pode ser usada para garantir que um item possa ser emprestado e devolvido de forma padronizada (se usada no seu projeto).
ItemController: Classe responsável pelo gerenciamento dos itens em memória (lista), leitura e gravação no arquivo, além de operações como cadastrar, remover e listar itens.
ItemView: Camada de interação com o usuário via console. Exibe menus, recebe entradas e invoca métodos do controller para executar as operações.
Console: Classe utilitária que encapsula os métodos de entrada de dados (como lerString(), lerInt(), lerFloat()), facilitando a leitura de informações via terminal e evitando repetições.

Observação: Durante o desenvolvimento após ter feito parte Teórica, removi a classe DetalhesItem, que continha uma relação de composição, pois percebi que não fazia sentido para o escopo do projeto como um todo. Isso ajudou a simplificar o modelo sem perder funcionalidades importantes.

Como Executar o Projeto:

É necessário clonar o repositório do GitHub para o seu computador. Para isso, copie a URL do repositório no GitHub. Depois, abra o terminal ou prompt de comando no seu computador e navegue até a pasta onde deseja salvar o projeto. Em seguida, execute o comando git clone seguido da URL copiada: git clone https://github.com/xavier-188/locadora-java.git Esse comando fará o download dos arquivos do projeto para o seu computador. Após a clonagem, abra o VSCode, clique em “Arquivo” e depois em “Abrir Pasta...”, selecione a pasta do projeto que foi clonada e clique em “Abrir”. Com isso, o projeto estará aberto no VSCode, pronto para ser visualizado, editado e executado.

Durante o desenvolvimento deste projeto, utilizei o ChatGPT para:

Solucionar problemas com persistência de dados e serialização/deserialização dos objetos.
Sugerir melhorias no fluxo de interação do usuário via console.

Referências e Recursos:

Material da disciplina.
