package com.example.safari.modelos;

public enum StatusIngresso {
        VALIDO("Válido", true),
        VENCIDO("Vencido", false),
        JA_UTILIZADO("Já Utilizado", false);

        private final String descricao;
        private final boolean valido;

        StatusIngresso(String descricao, boolean valido) {
            this.descricao = descricao;
            this.valido = valido;
        }

        public String getDescricao() {
            return descricao;
        }

        public boolean isValido() {
            return valido;
        }

        public static StatusIngresso fromDescricao(String descricao) {
            for (StatusIngresso status : values()) {
                if (status.descricao.equalsIgnoreCase(descricao.trim())) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Status de ingresso desconhecido: " + descricao);
        }
}
