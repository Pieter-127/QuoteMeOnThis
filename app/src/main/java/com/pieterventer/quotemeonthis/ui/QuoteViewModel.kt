package com.pieterventer.quotemeonthis.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pieterventer.quotemeonthis.data.model.Quote
import com.pieterventer.quotemeonthis.data.repository.dataSource.QuoteRepository
import kotlinx.coroutines.flow.Flow

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    fun retrieveQuotes(): Flow<PagingData<Quote>> {
        return repository.retrieveQuotes()
            .cachedIn(viewModelScope)
    }
}
