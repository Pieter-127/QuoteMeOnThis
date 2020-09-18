package com.pieterventer.quotemeonthis.di

import com.pieterventer.quotemeonthis.data.repository.dataSource.QuoteRepository
import com.pieterventer.quotemeonthis.data.repository.dataSource.QuoteRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<QuoteRepository> { QuoteRepositoryImpl(get()) }
}