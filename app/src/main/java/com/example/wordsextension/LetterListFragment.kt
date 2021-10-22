package com.example.wordsextension

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsextension.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    lateinit var binding: FragmentLetterListBinding
    lateinit var recyclerView: RecyclerView

    private val letterList = ('A').rangeTo('Z').toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = binding.letterListRecyclerView
        recyclerView.adapter = LetterAdapter(letterList)
    }
}

