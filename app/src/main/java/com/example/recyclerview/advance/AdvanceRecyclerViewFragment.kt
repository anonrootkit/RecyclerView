package com.example.recyclerview.advance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview.databinding.FragmentAdvanceRecyclerViewBinding

class AdvanceRecyclerViewFragment : Fragment() {

    private lateinit var binding : FragmentAdvanceRecyclerViewBinding
    private lateinit var viewModel : AdvanceViewModel

    private val advanceAdapter : RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdvanceRecyclerViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, AdvanceViewModel.Factory()).get(AdvanceViewModel::class.java)

        viewModel.list.observe(viewLifecycleOwner) { list ->
            if (!list.isNullOrEmpty()){
                advanceAdapter.submitList(list)
            }
        }

        binding.recyclerView.adapter = advanceAdapter
    }
}