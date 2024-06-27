package com.example.demolayoutv2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class GridViewLayoutAdapter(context: Context, cardItemArrayList: ArrayList<CardItem?>?) :
    ArrayAdapter<CardItem?>(context, 0, cardItemArrayList!!) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.grid_view_card_item, parent, false)
        }

        val cardItem: CardItem? = getItem(position)
        val cardItemTextView = listitemView!!.findViewById<TextView>(R.id.cardItemImageTextView)
        val cardItemImageView = listitemView.findViewById<ImageView>(R.id.cardItemImage)

        cardItemTextView.setText(cardItem!!.getCardItem_name())
        cardItemImageView.setImageResource(cardItem.getImgid())
        return listitemView
    }
}
