package com.elmenus.task.presentation.tag

import com.compact.app.viewmodel.CompactViewModel
import com.compact.executor.MainThread
import com.compact.executor.WorkerThread
import com.elmenus.task.domain.model.Tag
import com.elmenus.task.domain.usecase.TagsUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TagViewModel
@Inject constructor(
        private val useCase: TagsUseCase,
        private val subscribeOn: WorkerThread,
        private val observeOn: MainThread
) : CompactViewModel<List<Tag>>() {

    var SeletcedTag = 0

    override fun call() {
        get()
    }

    fun get(): Disposable {
        return useCase.get()
                .subscribeOn(subscribeOn.scheduler)
                .observeOn(observeOn.scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribe(doOnSuccess(), doOnError())
    }

    fun fetch(page: Int) {
        disposable.add(useCase.get(page)
                .subscribeOn(subscribeOn.scheduler)
                .observeOn(observeOn.scheduler)
                .doOnSubscribe(doOnSubscribe())
                .subscribe(Consumer { data.accept(it) }, doOnError()))
    }
}