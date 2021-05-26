package com.example.recyclerview.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview.R
import com.example.recyclerview.databinding.FragmentBasicRecyclerViewBinding

class BasicRecyclerViewFragment : Fragment() {

    private lateinit var binding : FragmentBasicRecyclerViewBinding
    private lateinit var viewModel : BasicViewModel

    private val basicAdapter : RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasicRecyclerViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, BasicViewModel.Factory()).get(BasicViewModel::class.java)

        viewModel.list.observe(viewLifecycleOwner) { list ->
            if (!list.isNullOrEmpty()){
                basicAdapter.initList(list)
            }
        }

        binding.recyclerView.adapter = basicAdapter
    }

}