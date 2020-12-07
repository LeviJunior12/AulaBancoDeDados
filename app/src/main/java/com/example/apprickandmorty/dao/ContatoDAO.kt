package com.example.apprickandmorty.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apprickandmorty.models.Contato

@Dao
interface ContatoDAO {
    @Insert
    suspend fun addContato(contato: Contato)

    @Query("SELECT * FROM contato")
    suspend fun getAllContatos():List<Contato>
}