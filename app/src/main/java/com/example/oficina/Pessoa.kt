package com.example.oficina

class Pessoa {
    private var id = 0
    private var nome: String? = null

    fun Pessoa() { //metodo construtor
    }

    //metodos GET e Set:
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getNome(): String? {
        return nome
    }

    fun setNome(nome: String?) {
        this.nome = nome
    }
}