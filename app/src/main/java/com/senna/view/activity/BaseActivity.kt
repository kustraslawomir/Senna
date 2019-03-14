package com.senna.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senna.utils.extensions.makeActivityFullScreen
import kotlinx.android.synthetic.main.fragment_compositions.view.*

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.makeActivityFullScreen()
        setContentView(getContentView())
    }

    abstract fun getContentView() : Int


}