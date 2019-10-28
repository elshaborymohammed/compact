package com.elmenus.task.presentation.items

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.transition.TransitionInflater
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.compact.app.CompactFragment
import com.elmenus.task.R
import com.elmenus.task.app.GlideApp
import com.elmenus.task.domain.model.Item
import kotlinx.android.synthetic.main.fragment_item_details.*
import kotlinx.android.synthetic.main.fragment_item_details.view.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class ItemDetailsFragment : CompactFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var itemViewModel: ItemViewModel

    override fun layoutRes(): Int {
        return R.layout.fragment_item_details
    }

    override fun onViewBound(view: View) {
        sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        
        itemViewModel = ViewModelProviders.of(requireActivity(), factory).get(ItemViewModel::class.java)

        view.toolbar?.let {
            val activity = activity as AppCompatActivity
            activity.setSupportActionBar(it)
            activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            it.setNavigationOnClickListener { activity.onBackPressed() }
        }
        arguments?.let { bundle ->
            itemViewModel.getOne(ItemDetailsFragmentArgs.fromBundle(bundle).name)?.let { bind(it) }
        }
    }

    private fun bind(it: Item) {
        toolbar_layout?.title = it.name
        description?.text = it.description
        image?.let { imageView ->
            GlideApp
                    .with(this)
                    .load(it.photo)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)
        }
    }
}