package com.exemploretrofit

object UsuarioResponse {

    data class Result(
        var erro: Int,
        var erros: Erros? = null,
        var retorno: Retorno? = null
    )

    data class Erros(
        var token: String? = null,
        var erro_api: String? = null
    )

    data class Retorno(
        var usuario: UsuarioRet? = null,
        var distribuidores: List<Distribuidores>? = null,
        var menu: List<Menu>? = null,
        var carros:List<Carro>? = null
    )

    data class UsuarioRet( var Usuario: Usuario)

    data class Usuario(
        var id : String,
        var nome : String,
        var email: String,
        var senha : String,
        var cpf : String,
        var created: String,
        var telefone : String? = null
    )

    data class Menu(
        var Tela: Tela? = null,
        var children: List<Menu>? = null
    )

    data class Tela (
        var id: String,
        var parent_id: String,
        var controller: String? = null,
        var action: String? = null,
        var nome: String,
        var exibe_menu: String,
        var exibe_deslogado: String,
        var exibe_para_todos: String,
        var exibe_edicao_grupo: String,
        var status: String,
        var class_icone: String? = null,
        var posicao:String? = null
    )

    data class Distribuidores( var Distribuidor: Distribuidor)
    data class Distribuidor(
        var id: String,
        var nome: String,
        var atendente: String? = null,
        var cnpj: String,
        var id_atendente_padrao: String,
        var exibir_painel_power_bi: String,
        var status: String
    )

    data class Carro(
        var id_carro_active: String,
        var placa: String,
        var marca_modelo: String
    )

}