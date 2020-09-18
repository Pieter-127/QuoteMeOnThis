package com.pieterventer.quotemeonthis.di

import com.pieterventer.quotemeonthis.ui.QuoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { QuoteViewModel(get()) }
}