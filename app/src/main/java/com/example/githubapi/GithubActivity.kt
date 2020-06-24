package com.example.githubapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapi.data.entity.UserRepoInfoVO
import com.example.githubapi.databinding.ActivityGithubBinding
import com.example.githubapi.globalconst.Consts
import org.koin.android.ext.android.get

class GithubActivity : AppCompatActivity(), GithubContract.View {
    private lateinit var binding: ActivityGithubBinding
    private lateinit var presenter: GithubPresenter
    private lateinit var githubAdapter: GithubAdapter
    private var username: String? = ""

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
        if (Intent.ACTION_VIEW == intent.action) {
            val uri = intent.data
            username = uri?.path?.replace("/","")
        }
        presenter.getUserInfo(username!!)
    }

    override fun setRepoInfo() {
        presenter.getUserRepoList(username!!)
    }

    override fun setView(userRepoInfoList: ArrayList<UserRepoInfoVO>) {
        githubAdapter = GithubAdapter(userRepoInfoList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = githubAdapter

        }
    }
}