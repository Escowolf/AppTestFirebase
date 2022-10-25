package com.example.oficina

class Carro {
    private var modelo: String? = null
    private var estilo: String? = null
    private var proprietario = 0

    fun Carro() { //metodo construtor
    }

    //metodos GET e Set:
    fun getModelo(): String? {
        return modelo
    }

    fun setModelo(modelo: String?) {
        this.modelo = modelo
    }

    fun getEstilo(): String? {
        return estilo
    }

    fun setEstilo(estilo: String?) {
        this.estilo = estilo
    }

    fun getProprietario(): Int {
        return proprietario
    }

    fun setProprietario(proprietario: Int) {
        this.proprietario = proprietario
    }
}