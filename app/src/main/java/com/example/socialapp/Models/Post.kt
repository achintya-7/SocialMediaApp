package com.example.socialapp.Models

data class Post (
    val text: String = "",
    val createdBy: UserData = UserData(),
    val createdAt: Long = 0L,
    val likedBy: ArrayList<String> = ArrayList())