package com.example.wordsextension

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsextension.databinding.FragmentWordListBinding


class WordListFragment : Fragment() {
    private lateinit var binding: FragmentWordListBinding
    lateinit var recyclerView: RecyclerView
    private lateinit var letterId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString("letter").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.wordListRecyclerView
        recyclerView.adapter= WordAdapter(letterId,requireContext())
    }
}