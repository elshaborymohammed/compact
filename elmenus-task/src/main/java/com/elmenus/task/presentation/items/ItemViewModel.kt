package com.elmenus.task.presentation.items

import com.compact.app.viewmodel.CompactDataViewModel
import com.compact.app.viewmodel.CompactViewModel
import com.compact.executor.MainThread
import com.compact.executor.RxCompactSchedulers
import com.compact.executor.WorkerThread
import com.elmenus.task.domain.model.Item
import com.elmenus.task.domain.usecase.ItemsUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemViewModel
@Inject constructor(
        private val useCase: ItemsUseCase,
        private val compose: RxCompactSchedulers
) : CompactDataViewModel<List<Item>>() {

    override fun call() {
    }

    fun get(tagName: String) {
        disposable.add(
                useCase.get(tagName)
                        .compose(compose.applyOnSingle())
                        .compose(composeLoadingSingle())
                        .subscribe()
        )
    }

    fun getOne(name: String): Item? {
        return data.value?.filter { it.name == name }?.get(0)
    }
}