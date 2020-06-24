package com.example.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.githubapi.databinding.ActivityGithubBinding
import org.koin.android.ext.android.get

class GithubActivity : AppCompatActivity(), GithubContract.View {
    private lateinit var binding: ActivityGithubBinding
    private lateinit var presenter: GithubPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        setUpDataBinding()
        initView()
    }

    private fun initPresenter() {
        presenter = GithubPresenter(this, get(), get())
    }

    private fun setUpDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_github)
    }

    private fun initView() {

    }

    override fun setUserInfo() {

    }

    override fun setUserRepoList() {

    }
}