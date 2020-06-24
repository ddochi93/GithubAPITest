package com.example.githubapi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.data.entity.UserInfoRepoInfo
import com.example.githubapi.data.entity.UserRepoInfoVO
import com.example.githubapi.data.entity.ViewType
import com.example.githubapi.util.loadUrlCenterCrop
import kotlinx.android.synthetic.main.item_user_info.view.*
import kotlinx.android.synthetic.main.item_user_repo_list.view.*


class GithubAdapter(private val myDataList: ArrayList<UserRepoInfoVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.userInfo -> {
                UserInfoViewHolder(parent)
            }

            ViewType.repoInfo -> {
                RepoInfoViewHolder(parent)
            }
            else -> {
                UserInfoViewHolder(parent)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is UserInfoViewHolder) {
            viewHolder.bind(myDataList[position].ownerName, myDataList[position].avatarUrl)
        } else if (viewHolder is RepoInfoViewHolder) {
            viewHolder.bind(myDataList[position].repoName, myDataList[position].repoDesc, myDataList[position].starCount)
        }
    }

    override fun getItemCount(): Int {
        return myDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return myDataList[position].viewType
    }


    inner class UserInfoViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        ) {
        private val userName: TextView = itemView.findViewById(R.id.owner_name)
        private val avatar: ImageView = itemView.findViewById(R.id.avatar_image)

        fun bind(name : String?, avatarUrl: String?) {
            userName.text = name
            avatar.loadUrlCenterCrop(avatarUrl!!)
        }

    }

    inner class RepoInfoViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_repo_list, parent, false)
        ) {
        private val repoName: TextView = itemView.findViewById(R.id.repo_name)
        private val repoDescription: TextView = itemView.findViewById(R.id.repo_description)
        private val starCount: TextView = itemView.findViewById(R.id.star_count)

        fun bind(repoName: String?, description: String?, starCount: Int?) {
            this.repoName.text = repoName
            this.repoDescription.text = description
            this.starCount.text = starCount.toString()
        }
    }
}