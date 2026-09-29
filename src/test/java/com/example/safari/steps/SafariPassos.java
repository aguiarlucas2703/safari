package com.example.safari.steps;

import com.example.safari.modelos.StatusIngresso;
import com.example.safari.modelos.TipoVeiculo;
import com.example.safari.service.SafariAccessControl;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafariPassos {

    private SafariAccessControl safari;

    private TipoVeiculo veiculo;
    private StatusIngresso ingresso;

    private String mensagemRetornada;

    @Before
    public void inicializar() {
        safari = new SafariAccessControl();
        veiculo = null;
        ingresso = null;
        mensagemRetornada = null;
    }

    // VALIDAÇÃO DE VEÍCULO E INGRESSO

    @Dado("que um visitante chega à portaria com um {string}")
    public void visitanteChegaComVeiculo(String tipoVeiculo) {
        veiculo = TipoVeiculo.fromDescricao(tipoVeiculo);
    }

    @Dado("possui um ingresso {string}")
    public void possuiUmIngresso(String situacao) {
        ingresso = StatusIngresso.fromDescricao(situacao);
    }

    @Quando("o guarda solicita a liberação da cancela")
    public void guardaSolicitaLiberacaoDaCancela() {
        mensagemRetornada = safari.solicitarEntrada(veiculo, ingresso);
    }

    @Entao("o sistema deve retornar a mensagem {string}")
    public void sistemaDeveRetornarMensagem(String mensagemEsperada) {
        assertEquals(mensagemEsperada, mensagemRetornada);
    }

    // CONTROLE DE LOTAÇÃO

    @Dado("que a capacidade máxima do safari é de {int} veículos")
    public void capacidadeMaximaDoSafari(int capacidade) {
        assertEquals(SafariAccessControl.CAPACIDADE_MAXIMA, capacidade);
    }

    @Dado("um visitante com {string} e ingresso {string} está na portaria")
    public void visitanteEstaNaPortaria(String tipoVeiculo, String situacaoIngresso) {
        veiculo = TipoVeiculo.fromDescricao(tipoVeiculo);
        ingresso = StatusIngresso.fromDescricao(situacaoIngresso);
    }

    @Dado("que o parque possui atualmente {int} veículos em circulação")
    public void parquePossuiVeiculos(int quantidade) {
        safari.setQuantidadeVeiculos(quantidade);
    }

    @Dado("o parque possui atualmente {int} veículos em circulação")
    public void parquePossuiAtualmente(int quantidade) {
        safari.setQuantidadeVeiculos(quantidade);
    }

    @Dado("um veículo sai do parque pelo portão de saída")
    public void veiculoSaiDoParque() {
        safari.registrarSaida();
    }

    @Entao("o parque deve passar a ter {int} veículos em circulação")
    public void parqueDevePassarATer(int quantidadeEsperada) {
        assertEquals(quantidadeEsperada, safari.getQuantidadeVeiculos());
    }

    @Entao("o parque deve continuar com {int} veículos em circulação")
    public void parqueDeveContinuarCom(int quantidadeEsperada) {
        assertEquals(quantidadeEsperada, safari.getQuantidadeVeiculos());
    }

    // BLOQUEIO DE EMERGÊNCIA

    @Dado("que o portão principal está em {string} por um leão na via")
    public void portaoPrincipalEstaEmEmergencia(String estado) {
        if (estado.equalsIgnoreCase("Alerta de Emergência")) {
            safari.ativarEmergencia();
        }
    }

    @Dado("que o portão principal estava em {string}")
    public void portaoPrincipalEstavaEmEmergencia(String estado) {
        if (estado.equalsIgnoreCase("Alerta de Emergência")) {
            safari.ativarEmergencia();
        }
    }

    @Dado("o controlador de tráfego desativa o alerta")
    public void controladorDesativaAlerta() {
        safari.desativarEmergencia();
    }

    @Dado("um visitante chega com {string} e ingresso {string}")
    public void visitanteChegaComVeiculoEIngresso(String tipoVeiculo, String situacaoIngresso) {
        veiculo = TipoVeiculo.fromDescricao(tipoVeiculo);
        ingresso = StatusIngresso.fromDescricao(situacaoIngresso);
    }
}