package com.elmenus.task.presentation.items

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.compact.app.CompactFragment
import com.elmenus.task.R
import com.elmenus.task.domain.model.Item
import com.elmenus.task.domain.model.Tag
import com.elmenus.task.presentation.tag.TagAdapter
import com.elmenus.task.presentation.tag.TagViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_items.view.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class ItemsFragment : CompactFragment, TagAdapter.OnClickListener, TagAdapter.OnLoadMoreListener,
        ItemAdapter.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var tagViewModel: TagViewModel
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var tagAdapter: TagAdapter
    private lateinit var itemAdapter: ItemAdapter

    constructor() {
        Log.i("ItemsFragment", "constructor")
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_items
    }

    override fun onViewBound(view: View) {
        sharedElementReturnTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        tagViewModel =
                ViewModelProviders.of(requireActivity(), factory).get(TagViewModel::class.java)
        itemViewModel =
                ViewModelProviders.of(requireActivity(), factory).get(ItemViewModel::class.java)

        tagAdapter = TagAdapter()
        tagAdapter.setOnClickListener(this)
        tagAdapter.setOnLoadMoreListener(this)
        view.tagList.adapter = tagAdapter

        itemAdapter = ItemAdapter()
        itemAdapter.setOnClickListener(this)
        view.itemList.adapter = itemAdapter
    }

    override fun subscriptions(): Array<Disposable> {
        return arrayOf(
//                tagViewModel.loading().subscribe(onLoading(), onError()),
//                itemViewModel.loading().subscribe(onLoading(), onError()),
//                itemViewModel.data()
//                        .subscribe(Consumer {
//                            println("$it")
//                            itemAdapter.swap(it)
//                        }, onError()),
//                tagViewModel.data()
//                        .subscribe(Consumer {
//                            tagAdapter.swap(it)
//                            tagAdapter.setSelectedIndex(tagViewModel.SeletcedTag)
//                        }, onError())
        )
    }

    override fun onClickTag(position: Int, obj: Tag) {
//        itemAdapter.swap(null)
        tagViewModel.selectedTag = position
        fetchItems(obj.name)
    }

    override fun onLoadMore(page: Int) {
        fetchTags(page)
    }

    override fun onClickItem(obj: Item, imageView: ImageView) {
        imageView.transitionName = "imageView"
        findNavController().navigate(
                ItemsFragmentDirections.actionHomeFragmentToItemDetailsFragment(
                        obj.name
                )
                , FragmentNavigatorExtras(imageView to "imageView")
        )
    }

    private fun onLoading(): Consumer<Boolean> {
        return Consumer {
            activity?.runOnUiThread {
                view?.loadingBar?.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
    }

    private fun fetchTags(page: Int) {
        tagViewModel.fetch(page)
    }

    private fun fetchItems(tagName: String) {
        itemViewModel.get(tagName)
    }
}