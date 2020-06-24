package com.example.githubapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapi.data.entity.UserRepoInfoVO
import com.example.githubapi.databinding.ActivityGithubBinding
import org.koin.android.ext.android.get

class GithubActivity : AppCompatActivity(), GithubContract.View {
    private lateinit var binding: ActivityGithubBinding
    private lateinit var presenter: GithubPresenter
    private lateinit var githubAdapter: GithubAdapter

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
        presenter.getUserInfo("ddochi93")
    }

    override fun setRepoInfo() {
        presenter.getUserRepoList("ddochi93")
    }

    override fun setView(userRepoInfoList: ArrayList<UserRepoInfoVO>) {
        githubAdapter = GithubAdapter(userRepoInfoList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = githubAdapter

        }
    }
}