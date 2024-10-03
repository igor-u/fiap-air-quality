## Monitoramento da Qualidade do Ar em PL/SQL

Este projeto tem como objetivo simular o monitoramento da qualidade do ar em determinada região, coletando dados de sensores e armazenando-os em um banco de dados Oracle. São gerados logs para alertar sobre possíveis problemas.

Os logs foram configurados como se fossem e-mails, considerando a falta de privilégio no banco de dados para fazer envios reais, utilizando pacotes como UTL_MAIL ou UTL_SMTP.

### Ferramentas
* Oracle Database 19c;
* SQL Developer;
* SQL*Plus.

### Como Usar
* Importe os scripts SQL para criar as tabelas e sequências;
* Importe os scripts PL/SQL para criar as procedures e triggers;
* Importe os scripts SQL para realizar os testes.
