package com.example.safari.service;

import com.example.safari.modelos.StatusIngresso;
import com.example.safari.modelos.TipoVeiculo;

public class SafariAccessControl {
    public static final int CAPACIDADE_MAXIMA = 50;

    private int quantidadeVeiculos;
    private boolean emergenciaAtiva;

    public SafariAccessControl() {
        this.quantidadeVeiculos = 0;
        this.emergenciaAtiva = false;
    }

    public String solicitarEntrada(TipoVeiculo veiculo, StatusIngresso ingresso) {
        if (emergenciaAtiva) {
            return "Acesso Suspenso Temporariamente";
        }
        if (!ingresso.isValido()) {
            return "Acesso Negado: Ingresso inválido";
        }
        if (!veiculo.isSeguro()) {
            return "Acesso Negado: Veículo inseguro";
        }
        if (quantidadeVeiculos >= CAPACIDADE_MAXIMA) {
            return "Acesso Negado: Lotação Máxima Atingida";
        }
        quantidadeVeiculos++;

        return "Acesso Permitido";
    }

    public void registrarSaida() {
        if (quantidadeVeiculos > 0) {
            quantidadeVeiculos--;
        }
    }

    public void ativarEmergencia() {
        this.emergenciaAtiva = true;
    }

    public void desativarEmergencia() {
        this.emergenciaAtiva = false;
    }

    public boolean isEmergenciaAtiva() {
        return emergenciaAtiva;
    }

    public int getQuantidadeVeiculos() {
        return quantidadeVeiculos;
    }

    public void setQuantidadeVeiculos(int quantidadeVeiculos) {
        if (quantidadeVeiculos < 0 || quantidadeVeiculos > CAPACIDADE_MAXIMA) {
            throw new IllegalArgumentException("Quantidade de veículos inválida.");
        }
        this.quantidadeVeiculos = quantidadeVeiculos;
    }
}
