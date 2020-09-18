package com.pieterventer.quotemeonthis.data.response

import com.pieterventer.quotemeonthis.data.model.Quote

data class QuoteResponse(val quotes: ArrayList<Quote> = arrayListOf())