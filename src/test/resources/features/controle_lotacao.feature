#language:pt
  @SafariTeste
  Funcionalidade: Controle de Lotação do Parque

    Contexto:

      Dado que a capacidade máxima do safari é de 50 veículos
      E um visitante com "SUV Fechado" e ingresso "Válido" está na portaria


    Cenário: Última vaga disponível é ocupada

      Dado que o parque possui atualmente 49 veículos em circulação
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Permitido"
      E o parque deve passar a ter 50 veículos em circulação


    Cenário: Parque lotado nega novas entradas

      Dado que o parque possui atualmente 50 veículos em circulação
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Negado: Lotação Máxima Atingida"
      E o parque deve continuar com 50 veículos em circulação


    Cenário: Saída de um veículo libera uma vaga

      Dado que o parque possui atualmente 50 veículos em circulação
      E um veículo sai do parque pelo portão de saída
      Quando o guarda solicita a liberação da cancela
      Então o sistema deve retornar a mensagem "Acesso Permitido"
      E o parque deve passar a ter 50 veículos em circulação