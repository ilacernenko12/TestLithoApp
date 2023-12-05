package com.example.testlithoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testlithoapp.component.PostComponent
import com.example.testlithoapp.model.Post
import com.example.testlithoapp.model.User
import com.facebook.litho.LithoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = User(username = "Test Username", avatarRes = R.drawable.ic_test)
        val post = Post(id = "test_id", user = user, imageRes = R.drawable.ic_test, text = "description")

        val lithoComponent = LithoView.create(this, PostComponent(post))
        setContentView(lithoComponent)
    }
}