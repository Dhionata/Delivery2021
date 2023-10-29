package br.com.model

enum class FormaPagamento {
    DEBITO, CREDITO, PARCELADO, VISTA, BOLETO;

    companion object {
        @JvmStatic
        fun novaFormaPagamento(formaPagamento: Int): FormaPagamento {
            return when (formaPagamento) {
                1 -> {
                    DEBITO
                }

                2 -> {
                    CREDITO
                }

                3 -> {
                    PARCELADO
                }

                4 -> {
                    VISTA
                }

                5 -> {
                    BOLETO
                }

                else -> {
                    println("esse número não deveria estar aqui!$formaPagamento")
                    DEBITO
                }
            }
        }
    }
}
