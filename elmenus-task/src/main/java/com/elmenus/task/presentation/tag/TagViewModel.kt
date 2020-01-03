package com.elmenus.task.presentation.tag

import com.compact.app.viewmodel.CompactDataViewModel
import com.compact.executor.RxCompactSchedulers
import com.elmenus.task.domain.model.Tag
import com.elmenus.task.domain.usecase.TagsUseCase
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagViewModel
@Inject constructor(
        private val useCase: TagsUseCase,
        private val compose: RxCompactSchedulers
) : CompactDataViewModel<List<Tag>>() {

    var selectedTag = 0

    override fun call() {
        get()
    }

    fun get(): Disposable {
        return useCase.get()
                .compose(compose.applyOnSingle())
                .compose(composeLoadingSingle())
                .subscribe()
    }

    fun fetch(page: Int) {
        disposable.add(useCase.get(page)
                .compose(compose.applyOnSingle())
                .compose(composeLoadingSingle())
                .subscribe())
    }
}