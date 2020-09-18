package com.pieterventer.quotemeonthis.data.repository.dataSource

import androidx.paging.PagingData
import com.pieterventer.quotemeonthis.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun retrieveQuotes(): Flow<PagingData<Quote>>
}