package com.example.hash.message.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hash.databinding.ItemViewPagerBinding

/** 主构造函数用来接收数据,
 * 父类泛型使用内部类,
 *
 * 构造函数里变量加 val,var
 * */

class ViewPagerAdapter(
    val images: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {

    //ViewHolder相当于单个Item的容器,父类构造函数传入根布局
    inner class MyViewHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    //创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }

    //绑定数据
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.testImage.setImageResource(images[position])
    }

    //计数
    override fun getItemCount() = images.size

}