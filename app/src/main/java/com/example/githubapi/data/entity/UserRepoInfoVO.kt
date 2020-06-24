package com.example.githubapi.data.entity

data class UserRepoInfoVO (
    var avatarUrl: String?,
    var ownerName: String?,
    var repoName: String?,
    var repoDesc: String?,
    var starCount: Int?,
    var viewType: Int
)