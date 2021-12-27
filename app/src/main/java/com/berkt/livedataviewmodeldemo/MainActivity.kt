package com.berkt.livedataviewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.berkt.livedataviewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.currentUsers.observe(this, Observer {
            binding.tvTextView.text = userViewModel.listOfUsers.toString()
        })

        addUsers()
        clearUsers()
    }

    private fun addUsers() {
        binding.btnAdd.setOnClickListener {
            val name = "Berk"

            userViewModel.listOfUsers.add(UserData(userViewModel.userId, name))

            userViewModel.userId++

            userViewModel.currentUsers.value = userViewModel.listOfUsers

        }
    }

    private fun clearUsers() {
        binding.btnClear.setOnClickListener {
            //clear list of users
            userViewModel.listOfUsers.clear()

            //notify list being cleared to our observer
            userViewModel.currentUsers.value = userViewModel.listOfUsers

            userViewModel.userId = 1
        }

    }
}