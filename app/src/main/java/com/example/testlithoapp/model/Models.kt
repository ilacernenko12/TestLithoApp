package com.example.testlithoapp.model

import androidx.annotation.DrawableRes

class User(val username: String, @DrawableRes val avatarRes: Int)

class Post(
    val id: String,
    val user: User,
    @DrawableRes val imageRes: Int,
    val text: String? = null
)