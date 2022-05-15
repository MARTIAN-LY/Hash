package com.example.hash.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hash.databinding.ItemRecyclerBlogBinding
import com.example.hash.home.models.BlogPost

class BlogRecyclerAdapter(private val items: List<BlogPost>) : RecyclerView.Adapter<BlogRecyclerAdapter.MyViewHolder>() {

    //内部类ViewHolder相当于单个Item的容器,传参知道Item里有什么东西
    inner class MyViewHolder(val binding : ItemRecyclerBlogBinding ) : RecyclerView.ViewHolder(binding.root)

    //创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogRecyclerAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBlogBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    //绑定数据
    override fun onBindViewHolder(holder: BlogRecyclerAdapter.MyViewHolder, position: Int) {
        holder.binding.apply {
            blogImage.setImageResource(items[position].image)
            blogAuthor.text = items[position].author
            blogTitle.text = items[position].title
        }
    }

    override fun getItemCount() = items.size

}