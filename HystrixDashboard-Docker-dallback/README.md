# Consumidor Apis rodando em Docker
- escreva as seguintes variáveis de ambiente no seu setup e coloque as suas chaves
- OAuthConsumerKey, OAuthConsumerSecret, OAuthAccessToken, OAuthAccessTokenSecret
- Execute o comando gradle build dentro das pastas Totalizador, Github e Twitter
- logo após, execute sudo docker-compose up na pasta tema10, aguarde o carregamento
- para usar a consulta do github acesse http://loclahost:8083/github/usuario-do-github
- para usar a consulta do twitter acesse http://loclahost:8082/twitter/usuario-do-twitter
- para totalizar os resultados acesse http://localhost:8080/api/twitter/usuario-do-twitter/github/usuario-do-github
- acesse histrix-dashboard e adicione localhost:8080/hystrix.stream, localhost:8082/hystrix.stream e localhost:8083/hystrix.stream ao monitor