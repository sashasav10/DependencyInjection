package com.savelievoleksandr.dependencyinjection

import com.savelievoleksandr.dependencyinjection.api.Service
import com.savelievoleksandr.dependencyinjection.model.Item

interface ListRepository {
    suspend fun getItemList(): List<Item>
}
class ListRepositoryImpl(private val listService: Service) : ListRepository {
    override suspend fun getItemList() = listService.getItems()
}
class ListUseCase(private val moviesListRepository: ListRepository) {
    suspend fun loadItemList() = moviesListRepository.getItemList()
}
