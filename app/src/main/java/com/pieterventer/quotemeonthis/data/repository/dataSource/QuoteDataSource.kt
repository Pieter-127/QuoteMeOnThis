package com.pieterventer.quotemeonthis.data.repository.dataSource

import androidx.paging.PagingSource
import com.pieterventer.quotemeonthis.data.model.Quote
import com.pieterventer.quotemeonthis.data.retrofit.QuoteApi
import java.lang.Exception

class QuoteDataSource(
    private val quoteApi: QuoteApi
) :
    PagingSource<Int, Quote>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quote> {
        val position = params.key ?: 1

        try {
            val response = quoteApi.getQuotes(
                page = position,
                limit = params.loadSize
            )

            val result = response.body()

            return LoadResult.Page(
                data = result?.quotes ?: emptyList(),
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (result == null || result.quotes.isEmpty()) null else position + 1
            )
        } catch (ex: Exception) {
            return LoadResult.Error(ex)
        }
    }
}