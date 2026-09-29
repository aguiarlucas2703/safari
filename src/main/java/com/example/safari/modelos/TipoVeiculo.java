package com.example.safari.modelos;

public enum TipoVeiculo {
    SUV_FECHADO("SUV Fechado", true),
    VAN("Van", true),
    CAMINHONETE_COM_CABINE("Caminhonete com Cabine", true),

    CARRO_CONVERSIVELS("Carro Conversível", false),
    MOTO("Moto", false),
    BICICLETA("Bicicleta", false);

    private final String descricao;
    private final boolean seguro;

    TipoVeiculo(String descricao, boolean seguro) {
        this.descricao = descricao;
        this.seguro = seguro;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public static TipoVeiculo fromDescricao(String descricao) {
        for (TipoVeiculo tipo : values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao.trim())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de veículo desconhecido: " + descricao);
    }
}
