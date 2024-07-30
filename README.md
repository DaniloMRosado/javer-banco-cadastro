# Gerenciador de dados do Banco Javer
#### Esta aplicação persiste os dados que foram obtidos através do microsserviço [API REST](https://github.com/DaniloMRosado/api-javer-cadastro).

## Como executar a aplicação:
### Requisitos:
- JDK 17 instalado. (Recomendado configurar a variável de ambiente JAVA_HOME)
- Instalar Maven 3.9 (versão utilizada no projeto)
- Instalar o MySQL (recomendado utilizar versão 8.0)
- Estar com a aplicação [API REST](https://github.com/DaniloMRosado/javer-banco-cadastro) em execução na mesma máquina
### 1. Baixe o projeto
- Fazer o download do arquivo ZIP deste repositório
  ##### OU
- Clonar o repositório com o comando  ```git clone https://github.com/DaniloMRosado/api-javer-cadastro.git``` sendo executado no terminal
### 2. Rode a aplicação
> [!IMPORTANT]
> - No arquivo _src/main/resources/application.properties_ você precisa colocar o usuário e senha do seu banco MySQL
> - ```spring.datasource.username = ${DATASOURCE_USERNAME}```
> - ```spring.datasource.password = ${DATASOURCE_PASSWORD}``` 

- Abra o terminal na pasta que está o projeto e execute o comando maven ```mvn spring-boot:run```

