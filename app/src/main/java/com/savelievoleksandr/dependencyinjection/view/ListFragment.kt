package com.savelievoleksandr.dependencyinjection.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.savelievoleksandr.dependencyinjection.databinding.FragmentBinding
import com.savelievoleksandr.dependencyinjection.Adapter
import com.savelievoleksandr.dependencyinjection.viewModels.FragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val listItemAdapter = Adapter()
    private var binding: FragmentBinding? = null
    private val viewModel by viewModel<FragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBinding.inflate(layoutInflater)
        viewModel.loadItemList()
        binding!!.recyclerView.apply {
            adapter = listItemAdapter
        }
        viewModel.itemList.observe(viewLifecycleOwner) {
            listItemAdapter.submitList(it)
            binding!!.recyclerView.visibility = ProgressBar.VISIBLE
        }
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}