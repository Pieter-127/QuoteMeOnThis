package com.pieterventer.quotemeonthis.data.repository.dataSource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pieterventer.quotemeonthis.data.model.Quote
import com.pieterventer.quotemeonthis.data.retrofit.QuoteApi
import kotlinx.coroutines.flow.Flow

class QuoteRepositoryImpl(private val quoteApi: QuoteApi) : QuoteRepository {

    override fun retrieveQuotes(): Flow<PagingData<Quote>> {

        return Pager(
            config = PagingConfig(
                pageSize = 100,
                initialLoadSize = 100,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                QuoteDataSource(quoteApi)
            }
        ).flow
    }
}