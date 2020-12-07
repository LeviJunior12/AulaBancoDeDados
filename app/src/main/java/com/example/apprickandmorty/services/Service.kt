package com.example.apprickandmorty.services

import com.example.apprickandmorty.dao.ContatoDAO
import com.example.apprickandmorty.models.Contato

interface Repository {

    suspend fun addContatoRepo(contato: Contato)

    suspend fun getAllContatoRepo(): List<Contato>
}

class RepositoryImpl(val contatoDAO: ContatoDAO): Repository {
    override suspend fun addContatoRepo(contato: Contato) {
        contatoDAO.addContato(contato)
    }

    override suspend fun getAllContatoRepo() = contatoDAO.getAllContatos()

}