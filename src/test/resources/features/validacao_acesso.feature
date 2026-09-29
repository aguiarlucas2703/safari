#language:pt
  @SafariTeste
  Funcionalidade: Validação de Acesso na Portaria

    Esquema do Cenário: Validação do tipo de veículo com ingresso válido

      Dado que um visitante chega à portaria com um "<veiculo>"
      E possui um ingresso "Válido"
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "<mensagem>"

      Exemplos:
        | veiculo                 | mensagem                          |
        | SUV Fechado             | Acesso Permitido                  |
        | Van                     | Acesso Permitido                  |
        | Caminhonete com Cabine  | Acesso Permitido                  |
        | Carro Conversível       | Acesso Negado: Veículo inseguro   |
        | Moto                    | Acesso Negado: Veículo inseguro   |
        | Bicicleta               | Acesso Negado: Veículo inseguro   |


    Esquema do Cenário: Ingresso inválido com veículo seguro

      Dado que um visitante chega à portaria com um "SUV Fechado"
      E possui um ingresso "<situacao>"
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Negado: Ingresso inválido"

      Exemplos:
        | situacao      |
        | Vencido       |
        | Já Utilizado  |