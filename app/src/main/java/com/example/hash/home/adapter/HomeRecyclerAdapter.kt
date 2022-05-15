package com.example.hash.home.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hash.databinding.ItemRecyclerBinding


/** 主构造函数用来接收数据源,
 *  父类泛型用内部类ViewHolder,
 *
 *  练习用,APP中无用
 * */
class HomeRecyclerAdapter(private val items: List<HomeRecyclerItem>) :
    RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>() {

    //ViewHolder相当于单个item的容器,父类传入根布局
    inner class MyViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    //创建ViewHolder,每个ViewHolder里的布局是 item_recycler.xml 的布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    //绑定数据,指定位置
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            itemText.text = items[position].title
            itemCheck.isChecked = items[position].isChecked
        }
    }

    //计数
    override fun getItemCount() = items.size

}