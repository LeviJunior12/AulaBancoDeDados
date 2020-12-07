package com.example.apprickandmorty.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickandmorty.models.Contato
import com.example.apprickandmorty.services.Repository
import kotlinx.coroutines.launch

class ContatoViewModel(val repository: Repository): ViewModel() {
    val listContatos = MutableLiveData<List<Contato>>()

    fun addNewContato(contato: Contato) {
        viewModelScope.launch {
            repository.addContatoRepo(contato)
        }
    }

    fun getAllContato() {
        viewModelScope.launch {
            listContatos.value = repository.getAllContatoRepo()
        }
    }
}