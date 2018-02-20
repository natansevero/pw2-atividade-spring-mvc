# 1ª Atividade do módulo "Frameworks Web"

Para esta atividade será necessário conhecimento em:

- Configuração básica do Spring MVC
- Controladores
- Mapeamento de Requisições (@RequestMapping e demais anotações)

## O que deve ser feito

Nesta atividade, você irá desenvolver um micro-blog pessoal, semelhante ao Twitter, porém sem funcionalidades para seguir outros usuários ou favoritar postagens.

Inicialmente, é necessário fazer uma funcionalidade simples de criar conta e fazer autenticação no sistema.

Ao se autenticar, a tela inicial da aplicação deve mostrar todos os posts do usuário logado, uma coluna indicando qual usuário está logado e uma caixa de texto para inserir um novo post. A Figura abaixo mostra como deve ser a disposição da tela inicial.

![Figura 1](https://i.imgur.com/JLsBT7A.png)

Em cada post deve conter um hyperlink que o leva para uma pagina semelhante a figura abaixo, exibindo apenas a postagem individualmente. Isto serve para fazer um link direto para a postagem

![Figura 2](https://i.imgur.com/v2fjXx0.png)

Neste micro-blog também deve ser permitido visualizar postagens de outros usuários, digitando seu nome de usuário na barra de endereços. A Figura abaixo mostra como deve ser disposta a tela de visualização de outros usuários

![Figura 3](https://i.imgur.com/WiyUsCh.png)

## Outras considerações

Para facilitar o desenvolvimento e avaliação desta atividade:

- Utilize um container web embarcado
- Utilize um banco de dados embarcado

## Entrega

Esta atividade deve ser entregue até o dia 19/02/2018, o código executável deve estar em um repositório no Github na organização da disciplina.

