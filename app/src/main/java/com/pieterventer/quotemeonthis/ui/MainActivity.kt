package com.pieterventer.quotemeonthis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pieterventer.quotemeonthis.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<QuoteViewModel>()

    lateinit var quoteAdapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar?.let {
            setSupportActionBar(it)
        }

        setupQuoteAdapter()

        lifecycleScope.launch {

            viewModel.retrieveQuotes().collectLatest {
                quoteAdapter.submitData(it)
            }
        }
    }

    private fun setupQuoteAdapter() {
        quoteAdapter = QuoteAdapter()

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL

        quoteGallery.apply {
            layoutManager = manager
            adapter = quoteAdapter
        }
    }
}