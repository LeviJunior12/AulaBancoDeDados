package com.example.apprickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contato")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val telefone: Int
)