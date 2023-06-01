package com.example.sportquiz.ui.shopScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportquiz.databinding.ItemBackgroundBinding

interface ActionListener {
    fun buy(id: Int)

    fun returnToHome()
}

class ShopAdapter(
    private val actionListener: ActionListener
) : RecyclerView.Adapter<ShopAdapter.ViewHolderShop>(), View.OnClickListener {

    var mapOfBackgrounds = emptyMap<Int, Int>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShop {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBackgroundBinding.inflate(inflater, parent, false)

        binding.btBuy.setOnClickListener(this)

        return ViewHolderShop(binding)
    }

    override fun getItemCount(): Int = mapOfBackgrounds.size

    override fun onBindViewHolder(holder: ViewHolderShop, position: Int) {
        val backgroundImg = mapOfBackgrounds[position+1]
        holder.binding.btBuy.tag = position+1
        holder.itemView.tag = mapOfBackgrounds[position+1]

        with(holder.binding) {
            Glide.with(imageBackground.context)
                .load(backgroundImg)
                .circleCrop()
                .into(imageBackground)
        }
    }

    class ViewHolderShop(
        val binding: ItemBackgroundBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onClick(view: View?) {
        val id = view?.tag as Int

        AlertDialog.Builder(view.context)
            .setTitle("Are you shure?")
            .setPositiveButton("Yes") { _, _ ->
                actionListener.buy(id)
                actionListener.returnToHome()
            }
            .setNegativeButton("No", null)
            .create()
            .show()
    }
}