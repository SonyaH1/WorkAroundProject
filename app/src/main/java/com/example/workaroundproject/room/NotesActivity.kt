package com.example.workaroundproject.room

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workaroundproject.cat_retrofit.ui.vm.CatFactViewState
import com.example.workaroundproject.databinding.NoteActivityBinding
import com.example.workaroundproject.databinding.RecyclerViewActivityBinding
import com.example.workaroundproject.room.domain.entities.NoteItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.random.Random

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {
    private lateinit var binding: NoteActivityBinding
    private val customAdapter by lazy {
        NotesAdapter(::deleteItem)
    }
    private val viewModel: NotesActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NoteActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@NotesActivity)
            adapter = customAdapter
        }

        binding.addButton.setOnClickListener {
            viewModel.insertNote(
                NoteItem(
                    id = customAdapter.itemCount + 1,
                    name = "random name ${Random.nextInt()}",
                    description = "random description${Random.nextInt()}"
                )
            )
        }

        observeData()
    }

    private fun observeData() {
        viewModel.noteViewStateFlow
            .flowWithLifecycle(lifecycle)
            .onEach {
                customAdapter.submitList(it.listOfNotes)
            }
            .launchIn(lifecycleScope)

    }

    private fun deleteItem(id: Int){
        viewModel.deleteNote(id)
    }
}