# web_service_cep
Web Service Consultas CEP - NS

A solução teve o objetivo de expor um serviço através de um webservice, no qual já exista um site que tenha um localizador de CEP.
Foi separado a camada de negócio a camada responsável por expor o webservice, no que diminuiu o acoplamento e a responsabilidade dos objetos.

Utilizado o webservice RestFul por ser simples e de forma a facilitar o teste, e também utilizado o framework Jersey no qual implementa a  API JAX-RS (ou Java API for RESTful Web Services), sendo o responsável para expor o webservice Rest. 

Além destes possui o framework spring para injeções dos Beans e o Maven como repositório. 

Para os teste foi utilizado o JUnit e o Mockito para mocks de retornos.   

Aplicação desenvolvida através do Intellij e utilizando o WebContainer GlassFish. 

O serviço está disponibilizado em services/cep, sendo a seguir alguns dos retornos:
Get services/cep/12345678

{
 "Cep" : {
  Rua : "abcefg",
  Bairro : " abcefg ",
  Cidade : " abcefg ",
  Estado : " ab"
 }
}

e Caso não encontre retorna: 111 CEP inválido
