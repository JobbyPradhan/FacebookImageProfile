package com.mhs.facebookimageprofile

import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mhs.facebookimageprofile.Assymetric.AsymmetricRecyclerViewAdapter
import com.mhs.facebookimageprofile.Assymetric.Utils
import com.mhs.facebookimageprofile.databinding.ParentItemBinding
import com.mhs.facebookimageprofile.model.ItemList
import com.mhs.facebookimageprofile.util.SpacesItemDecoration

class ParentAdapter(
    val itemList :ArrayList<ItemList>,
    val mDisplay:Int,
    val mTotal :Int
) : RecyclerView.Adapter<ParentAdapter.MyViewHolder>() {

    @Suppress("DEPRECATION")
    inner class MyViewHolder(
        private val binding:ParentItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(item: ItemList) {
            val title= itemView.context.getString(R.string.title,item.ItemName,"$mTotal")
            binding.tvTitle.text = Html.fromHtml(title)
            /* ChildAdapter adapter = new ChildAdapter(item.getImages(),mDisplay,mTotal);
        holder.recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(mCon,holder.recyclerView, adapter));
   */
            Log.d("TASDFASDFAIMAG", "bind: ${item.Images.size} $mTotal")
            val adapter = ChildAdapter(item.Images,mDisplay,mTotal)
           // binding.recyclerView.setRequestedColumnCount(1)
            if(item.Images.size == 2){
                binding.recyclerView.setRequestedColumnCount(2)
            }else if(item.Images.size >2) binding.recyclerView.setRequestedColumnCount(3)
             else binding.recyclerView.setRequestedColumnCount(1)
            //binding.recyclerView.setRequestedColumnCount(3)
            binding.recyclerView.isDebugging = true
            binding.recyclerView.requestedHorizontalSpacing = Utils.dpToPx(itemView.context, 3.0f)
            binding.recyclerView.addItemDecoration(
                SpacesItemDecoration(itemView.context.resources.getDimensionPixelSize(R.dimen.recycler_padding))
            )

            binding.recyclerView.adapter = AsymmetricRecyclerViewAdapter(itemView.context,binding.recyclerView,adapter)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ParentItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //  ItemList item = mItemList.get(position);
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}