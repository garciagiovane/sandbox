# Calculadora com Spring rodando em container
- Abra um terminal na pasta arquivos-do-war e execute os comandos gradle wrapper e ./gradlew clean build, respectivamente
- feche o terminal
- abra um terminal na pasta tema06 e execute o comando sudo docker build -t tema06 .
- quando terminar, execute o comando docker run -it -p 8080:8080 tema06
- após completar, acesse localhost:8080/arquivos-do-war-1.0-SNAPSHOT/ no navegador
- Para utilizar a calculadora, digite o primeiro valor no campo valor A, depois digite o segundo valor no campo valor B, selecione o tipo de cálculo e clique em calcular
