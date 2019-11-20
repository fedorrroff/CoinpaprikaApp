package com.fedorrroff.coinpaprikaapp.ui.currencies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.models.Coin

class CurrencyAdapter(
    private val items: MutableList<Coin> = mutableListOf()
) : RecyclerView.Adapter<CurrencyAdapter.CoinViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.currency_single, parent, false)
        return CoinViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(items.get(position), listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addAllItems(currencies: List<Coin>) {
        items.clear()
        items.addAll(currencies)
        notifyDataSetChanged()
    }

    inner class CoinViewHolder (
        view: View,
        val iv_logo: ImageView = view.findViewById(R.id.image_single),
        val tv_name: TextView = view.findViewById(R.id.tv_name_single),
        val requestOptions: RequestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)
        ) : RecyclerView.ViewHolder(view) {

        fun bind(coin: Coin?, listener: OnItemClickListener?) {
            Glide.with(itemView)
                .load("https://static2.coinpaprika.com/coin/" + (coin?.id ?: "") + "/logo.png")
                .apply(requestOptions)
                .into(iv_logo)

            tv_name.text = (coin?.name ?: "Undefined") + "(" + (coin?.symbol ?: "Undefined") + ")"

            itemView.setOnClickListener {
                if (coin != null) {
                    listener?.onItemClick(coin)
                }
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(coin: Coin)
    }
}

