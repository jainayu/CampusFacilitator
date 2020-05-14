package com.example.campusfacilitator.ui.home.quotes

import com.example.campusfacilitator.R
import com.example.campusfacilitator.data.db.entities.Quote
import com.example.campusfacilitator.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
): BindableItem<ItemQuoteBinding>(){
    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }

}