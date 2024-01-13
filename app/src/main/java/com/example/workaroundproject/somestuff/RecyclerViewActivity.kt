package com.example.workaroundproject.somestuff


import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workaroundproject.databinding.RecyclerViewActivityBinding
import com.example.workaroundproject.somestuff.viewmodel.RecyclerViewActivityViewModel


class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: RecyclerViewActivityBinding
    private val customAdapter by lazy {
        CustomBindingRecyclerViewAdapter(::showToast)
    }
    private val viewModel: RecyclerViewActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = customAdapter
        }

        binding.addButton.setOnClickListener {
            viewModel.incrementAgeForAllElements()
        }

        observeData()
    }

    private fun observeData(){
        viewModel.listOfLifeBeingsLiveData().observe(this) { list->
            customAdapter.lifeBeings = list
        }

    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).run {
            show()
        }
    }
}