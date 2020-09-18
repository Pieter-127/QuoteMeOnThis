package com.pieterventer.quotemeonthis.ui

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pieterventer.quotemeonthis.R
import com.pieterventer.quotemeonthis.data.model.Quote
import com.pieterventer.quotemeonthis.ui.QuoteAdapter.ReminderHolder.Companion.GALLERY_COMPARATOR
import com.pieterventer.quotemeonthis.util.inflateView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.quote_item.view.*

class QuoteAdapter :
    PagingDataAdapter<Quote, QuoteAdapter.ReminderHolder>(GALLERY_COMPARATOR) {

    override fun onBindViewHolder(holder: ReminderHolder, position: Int) {
        val item = getItem(position)

        if (item != null) {
            val context = holder.containerView.context

            val defaultAuthorText = context.getString(R.string.default_author_text)

            holder.containerView.quoteText.text = item.quote
            holder.containerView.author.text =
                if (item.author.isNullOrEmpty()) defaultAuthorText else item.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderHolder =
        ReminderHolder.inflate(parent)

    class ReminderHolder constructor(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        companion object {
            fun inflate(parent: ViewGroup):
                    ReminderHolder =
                ReminderHolder(inflateView(R.layout.quote_item, parent, false))

            val GALLERY_COMPARATOR = object : DiffUtil.ItemCallback<Quote>() {
                override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean =
                    oldItem.author == newItem.author &&
                            oldItem.quote == newItem.quote

                override fun areContentsTheSame(
                    oldItem: Quote,
                    newItem: Quote
                ): Boolean =
                    oldItem == newItem
            }
        }
    }
}