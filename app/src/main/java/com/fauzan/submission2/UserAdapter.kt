package com.fauzan.submission2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fauzan.submission2.databinding.ItemUserBinding
import com.fauzan.submission2.response.ItemsItem
import com.fauzan.submission2.ui.detail.DetailActivity

class UserAdapter(private val listUser: ArrayList<ItemsItem>, val context: Context?) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    fun setList(user: ArrayList<ItemsItem>) {
        listUser.clear()
        listUser.addAll(user)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Response: ItemsItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(Response.avatarUrl)
                    .into(imgItemPhoto)
                val newText =
                    context?.resources?.getString(R.string.userplaceholder, Response.login)
                tvItemName.text = newText
            }
        }

        fun onClickItem(Response: ItemsItem) {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_USERNAME, Response.login)
            context?.startActivity(moveWithObjectIntent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])

        holder.itemView.setOnClickListener {
            holder.onClickItem(listUser[position])
        }
    }

    override fun getItemCount() = listUser.size
}