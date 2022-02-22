package com.savelievoleksandr.dependencyinjection

import com.savelievoleksandr.dependencyinjection.viewModels.FragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    factory {
        ListUseCase(moviesListRepository = get())
    }
}
val dataModule = module {
    single<ListRepository> {
        ListRepositoryImpl(listService = get())
    }
}
val appModule = module {
    viewModel {
        FragmentViewModel(listUseCase = get())
    }
}