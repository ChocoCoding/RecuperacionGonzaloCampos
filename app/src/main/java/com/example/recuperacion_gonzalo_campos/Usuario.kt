package com.example.recuperacion_gonzalo_campos

data class Usuario (val username:String,val password: String){
}


fun getListaUsuarios():List<Usuario>{
    val  listaUsuarios : MutableList<Usuario> = mutableListOf(
        Usuario("gonzalo@gmail.com", "abc123."),
        Usuario("campos@teis.gal", "abc123."),
        Usuario("dominguez@teis.gal", "abc123.")
    )
    return listaUsuarios;
}

var users = getListaUsuarios().toMutableList()

fun addUser(usuario: Usuario) {
    users = (users + usuario).toMutableList()
}



