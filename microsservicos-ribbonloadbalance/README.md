# Microsserviços com balanceamento de carga nas requisições
- As requisições ao SongService são balanceadas, uma para cada instancia da aplicação registrada no eureka
- todos os serviços se registram no eureka
- songservice busca as músicas do banco de acordo com o id
- playlistservice busca o id das músicas que estão em uma playlist
- appservice busca o título das músicas com base no id da playlist