package com.example.githubapi

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubapi.data.entity.ViewType
import kotlinx.android.synthetic.main.item_user_repo_list.view.*


class GithubAdapter(private val myDataList: ArrayList<UserInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
        if (viewHolder is CenterViewHolder) {
            viewHolder.content.setText(myDataList.get(position).getContent())
        } else if (viewHolder is LeftViewHolder) {
            (viewHolder as LeftViewHolder).name.setText(myDataList.get(position).getName())
            (viewHolder as LeftViewHolder).content.setText(myDataList.get(position).getContent())
        } else {
            (viewHolder as RightViewHolder).name.setText(myDataList.get(position).getName())
            (viewHolder as RightViewHolder).content.setText(myDataList.get(position).getContent())
        }
    }

    override fun getItemCount(): Int {
        return myDataList.size()
    }

    override fun getItemViewType(position: Int): Int {
        return myDataList.get(position).getViewType()
    }


    inner class UserInfoViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        ) {

    }

    inner class RepoInfoViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_repo_list, parent, false)
        ) {
        private val repoName: TextView = itemView.repo_name
        private val repoDescription: TextView = itemView.repo_description
        private val starCount: TextView = itemView.star_count

        fun bind(repoName: String, description: String, starCount: Int) {
            this.repoName.text = repoName
            this.repoDescription.text = description
            this.starCount.text = starCount.toString()
        }
    }
}