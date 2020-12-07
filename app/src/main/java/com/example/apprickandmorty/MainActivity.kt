package com.example.apprickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apprickandmorty.database.AppDatabase
import com.example.apprickandmorty.models.Contato
import com.example.apprickandmorty.services.Repository
import com.example.apprickandmorty.services.RepositoryImpl
import com.example.apprickandmorty.ui.ContatoViewModel


class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDB()

        repository = RepositoryImpl(db.contatoDAO())

        val viewModel by viewModels<ContatoViewModel> {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return ContatoViewModel(repository) as T
                }

            }
        }

        viewModel.addNewContato(Contato(1, "Levi", 9966))

        viewModel.listContatos.observe(this) {
            Log.i("Main Activity", it.toString())
        }

    }

    fun initDB() {
        db = AppDatabase.invoke(this)
    }

}