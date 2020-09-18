package com.pieterventer.quotemeonthis.di

import com.pieterventer.quotemeonthis.data.retrofit.RestClient
import org.koin.dsl.module

val apiModule = module {

    single { RestClient.QUOTE_API }
}