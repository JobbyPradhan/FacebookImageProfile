package com.mhs.facebookimageprofile


import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mhs.facebookimageprofile.Assymetric.AGVRecyclerViewAdapter
import com.mhs.facebookimageprofile.Assymetric.AsymmetricItem
import com.mhs.facebookimageprofile.databinding.AdapterItemBinding
import com.mhs.facebookimageprofile.model.ItemImage


class ChildAdapter(
    val itemList:ArrayList<ItemImage>,
    val mDisplay :Int,
    val mTotal: Int
) : AGVRecyclerViewAdapter<ChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(
        private val binding: AdapterItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(item: ItemImage,position: Int) {
            Log.d("TASDFASDFAS", "bind: $position")

            Glide.with(binding.root).load(item.imagePath).into(binding.mImageView)
          /*  ImageLoader.getInstance()
                .displayImage(item.imagePath, binding.mImageView)*/
            binding.tvCount.text ="+${mTotal-mDisplay}"
            Log.d("TASDFASDFA", "bind: $mTotal $mDisplay $adapterPosition")
            if (mTotal > mDisplay) {
                if (position == mDisplay - 1) {
                    binding.tvCount.visibility = View.VISIBLE
                    binding.mImageView.alpha = 0.5f
                } else {
                    binding.tvCount.visibility = View.INVISIBLE
                    binding.mImageView.alpha = 1f
                }
            } else {
                binding.mImageView.alpha = 1f
                binding.tvCount.visibility = View.INVISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(
            AdapterItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val items =  itemList[position]
        holder.bind(items,position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): AsymmetricItem {
        return itemList[position]
    }
    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 1 else 0
    }
}