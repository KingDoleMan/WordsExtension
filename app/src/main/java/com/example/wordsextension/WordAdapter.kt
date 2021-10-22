package com.example.wordsextension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val letterId: String, context: Context) :
    RecyclerView.Adapter<LetterAdapter.MyViewHolder>() {
    private lateinit var wordList: List<String>

    init {
        val words: List<String> = context.resources.getStringArray(R.array.words).toList()

        //아래 과정은 모두 새로운 list 를 return 하는 방식이다.
        wordList = words.filter { it.startsWith(letterId, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LetterAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LetterAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterAdapter.MyViewHolder, position: Int) {
        val button = holder.button
        button.text = wordList[position]
        val context = button.context
        button.setOnClickListener {
            val searchUrl: Uri = Uri.parse("${SEARCH_PREFIX}${button.text}")
            val intent = Intent(Intent.ACTION_VIEW, searchUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = wordList.size


    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}