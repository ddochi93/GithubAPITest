package com.example.githubapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.githubapi.databinding.ActivityMainBinding
import com.example.githubapi.globalconst.Consts

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDataBinding()
    }

    private fun setUpDataBinding() {
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.activity = this
    }

    fun buttonClicked() {
        startActivity(Intent(this, GithubActivity::class.java).apply {
            putExtra(Consts.USER_NAME, mainBinding.insertAppLink.text.toString().trim() )
        })
    }
}