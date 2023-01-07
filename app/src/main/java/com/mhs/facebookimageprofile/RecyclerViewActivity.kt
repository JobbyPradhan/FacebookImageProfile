package com.mhs.facebookimageprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhs.facebookimageprofile.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}