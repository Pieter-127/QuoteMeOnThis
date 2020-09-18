package com.pieterventer.quotemeonthis.data.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quoteText")
    val quote: String,
    @SerializedName("quoteAuthor")
    val author: String? = null
)