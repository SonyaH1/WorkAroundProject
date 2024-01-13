package com.example.workaroundproject.cat_retrofit.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.workaroundproject.cat_retrofit.domain.model.CatFact
import com.example.workaroundproject.cat_retrofit.ui.vm.CatFactViewModel
import com.example.workaroundproject.cat_retrofit.ui.vm.CatFactViewState
import com.example.workaroundproject.databinding.CatFactActivityBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CatFactActivity: AppCompatActivity() {

    private lateinit var binding: CatFactActivityBinding

    /*
    we can do it like this, cuz we have implementation ("androidx.activity:activity-ktx:1.8.2")
    private val viewModel: CatFactViewModel by viewModels()
    below version without library
     */
    private val viewModel: CatFactViewModel by lazy {
        ViewModelProvider(this)[CatFactViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CatFactActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        subscribeToStateUpdates()

        binding.buttonNewFact.setOnClickListener {
            viewModel.getCatFact()
        }
    }

    private fun subscribeToStateUpdates() {
        viewModel.catFactViewStateFlow
            .flowWithLifecycle(lifecycle)
            .onEach { state ->
                when (state) {
                    is CatFactViewState.Loading -> showLoadingState()
                    is CatFactViewState.Success -> showSuccessState(state.data)
                    is CatFactViewState.Failure -> showFailureState(state.errorMessage)
                }
            }
            .launchIn(lifecycleScope)
    }

    private fun showLoadingState() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showSuccessState(item: CatFact) {
        binding.progressBar.visibility = View.INVISIBLE
        binding.tvFactAboutCat.text = item.fact
    }

    private fun showFailureState(errorMessage: String) {
        binding.progressBar.visibility = View.INVISIBLE
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).run {
            show()
        }
    }
}