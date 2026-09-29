#language:pt
  @SafariTeste
  Funcionalidade: Bloqueio de Emergência por Obstrução de Animais

    Cenário: Entrada bloqueada com alerta ativo

      Dado que o portão principal está em "Alerta de Emergência" por um leão na via
      E um visitante chega com "SUV Fechado" e ingresso "Válido"
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Suspenso Temporariamente"


    Cenário: Entrada volta ao normal após o fim do alerta

      Dado que o portão principal estava em "Alerta de Emergência"
      E o controlador de tráfego desativa o alerta
      E um visitante chega com "SUV Fechado" e ingresso "Válido"
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Permitido"


    Esquema do Cenário: Emergência tem prioridade sobre as outras regras

      Dado que o portão principal está em "Alerta de Emergência" por um leão na via
      E um visitante chega com "<veiculo>" e ingresso "<ingresso>"
      E o parque possui atualmente <ocupacao> veículos em circulação
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Suspenso Temporariamente"

      Exemplos:
        | veiculo            | ingresso | ocupacao |
        | Carro Conversível  | Válido   | 10       |
        | SUV Fechado        | Vencido  | 10       |
        | SUV Fechado        | Válido   | 50       |