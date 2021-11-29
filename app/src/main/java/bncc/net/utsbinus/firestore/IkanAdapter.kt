package bncc.net.utsbinus.firestore

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bncc.net.utsbinus.databinding.ItemIkanBinding
import bncc.net.utsbinus.model.Ikan
import com.bumptech.glide.Glide

class IkanAdapter(val ikan: ArrayList<Ikan>, val context: Context) : RecyclerView.Adapter<IkanAdapter.ViewHolder>() {
    inner class ViewHolder(val view: ItemIkanBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Ikan) = with(view) {
            Glide.with(context).load(item.image).into(view.imgIkan)
            view.textIkan.text = item.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IkanAdapter.ViewHolder {
        val binding = ItemIkanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IkanAdapter.ViewHolder, position: Int) {
        with(holder) {
            bind(ikan[position])
        }
    }

    override fun getItemCount(): Int {
        return ikan.size
    }
}