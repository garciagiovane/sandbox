# Microserviço potenciação calculadora
- execute o comando gradle build na raiz do projeto
- após, execute gradle run e aguarde até carregar
- acesse 127.0.01:6007/math/pow/primeiro_valor/segundo_valor, será mostrado o resultado de potenciação
- para integrar com a calculadora, apenas suba os outros serviços, seguindo os passos 1 e 2
- execute o eureka server no tomcat adicionando o war do eureka na pasta webapps
- aguarde de 5 a 10 minutos para que os serviços se registrem
- acesse http://localhost:6005/math/calc/primeiro_valorsegundo_valoroperação_desejada (tudo junto)
- as operações disponíveis são "+-*/^"
