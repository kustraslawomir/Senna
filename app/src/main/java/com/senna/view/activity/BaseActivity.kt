package com.senna.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.senna.utils.extensions.makeActivityFullScreen

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.makeActivityFullScreen()
        setContentView(getContentView())
    }

    abstract fun getContentView() : Int

    abstract fun getViewModel() : ViewModel

    fun <T : ViewModel> provideViewModel(@NonNull modelClass: Class<T>): T {
        return ViewModelProviders
                .of(this)
                .get(modelClass)
    }
}