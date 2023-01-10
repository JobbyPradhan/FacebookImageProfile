package com.mhs.facebookimageprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mhs.facebookimageprofile.databinding.ActivityMainBinding
import com.mhs.facebookimageprofile.model.ItemImage
import com.mhs.facebookimageprofile.model.ItemList
import com.mhs.facebookimageprofile.util.SpacesItemDecoration

class MainActivity : AppCompatActivity() {
    private var Image1 =
        "https://aws-mhsimages-bucket.s3.ap-southeast-1.amazonaws.com/sit/Shuya/images/PopUpBanner/shuya_popup.jpg"
    private var Image2 =
        "https://aws-mhsimages-bucket.s3.ap-southeast-1.amazonaws.com/sit/Shuya/images/PopUpBanner/shuya_popup.jpg"
    private var Image3 =
        "https://aws-mhsimages-bucket.s3.ap-southeast-1.amazonaws.com/sit/Shuya/images/PopUpBanner/shuya_popup.jpg"
    private var Image4 =
        "https://aws-mhsimages-bucket.s3.ap-southeast-1.amazonaws.com/sit/Shuya/images/PopUpBanner/shuya_popup.jpg"

    var currentOffset = 0
    var mMaxDisplay_Size = 4
    var mTotal_Size = 0

    var pathItems: ArrayList<ItemImage> = ArrayList<ItemImage>()
    private val mItemList: ArrayList<ItemList> = ArrayList<ItemList>()
    private var mAdapter: ParentAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* Random r = new Random();
        mMaxDisplay_Size = r.nextInt(7 - 6) + 6;*/
        /* for (k in 0..1) {
             prepareMovieData(k)
         }*/
        setData()
        setData1()
        setData2()
        setData3()
        setData4()
        mTotal_Size = 5//pathItems.size
        mAdapter = ParentAdapter(mItemList as ArrayList<ItemList>, mMaxDisplay_Size, mTotal_Size)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = mLayoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        /*    binding.recyclerView.setRequestedColumnCount(3)
            binding.recyclerView.setDebugging(true)
            binding.recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3))*/

        binding.recyclerView.adapter = mAdapter
    }

    private fun setData() {
        var Pathitems = java.util.ArrayList<ItemImage>()
        var isCol2Avail = false
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(2, Image2, Image2))
        Pathitems.add(ItemImage(3, Image3, Image3))
        Pathitems.add(ItemImage(4, Image4, Image4))
        /*Pathitems.add(ItemImage(5, Image1, Image1))
        Pathitems.add(ItemImage(6, Image3, Image3))
        Pathitems.add(ItemImage(7, Image2, Image2))
        Pathitems.add(ItemImage(8, Image4, Image4))
        Pathitems.add(ItemImage(9, Image4, Image4))
        Pathitems.add(ItemImage(10, Image3, Image3))
        Pathitems.add(ItemImage(11, Image2, Image2))
        Pathitems.add(ItemImage(12, Image1, Image1))
        Pathitems.add(ItemImage(13, Image1, Image1))
        Pathitems.add(ItemImage(14, Image4, Image4))*/
        var mCount = 0
        mCount = if (Pathitems.size > mMaxDisplay_Size) {
            mMaxDisplay_Size
        } else {
            Pathitems.size
        }
        for (k in 0 until 1) {
            var colSpan = if (Math.random() < 0.2f) 2 else 1
            if (colSpan == 2 && !isCol2Avail) {
                isCol2Avail = true
            } else if (colSpan == 2 && isCol2Avail) {
                colSpan = 1
            }
            val rowSpan = colSpan
            var item = ItemList(k, "Item #$k", Pathitems)


            if (Pathitems.size == 3) {
                Pathitems[0].columnSpan = 2
                Pathitems[0].rowSpan = 3f
                //   Pathitems[1].columnSpan = 2
                Pathitems[1].rowSpan = 1.5f
                //  Pathitems[2].columnSpan = 2
                Pathitems[2].rowSpan = 1.5f
                Pathitems[0].setPosition(currentOffset + k)
                Pathitems[1].setPosition(currentOffset + k)
                Pathitems[2].setPosition(currentOffset + k)
            } else if (Pathitems.size == 2) {
                /*  Pathitems[0].columnSpan = 1
                  Pathitems[0].rowSpan = 1*/
                Pathitems[0].columnSpan = 1
                Pathitems[1].columnSpan = 1
                Pathitems[1].rowSpan = 2f
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else if (Pathitems.size == 4) {
                Pathitems[0].columnSpan = 3
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else {
                Pathitems[0].columnSpan = 1
                Pathitems[0].rowSpan = 1f
                Pathitems[0].setPosition(currentOffset + k)
            }

            mItemList.add(item)

        }
        currentOffset += Pathitems.size
    }

    private fun setData1() {
        var Pathitems = java.util.ArrayList<ItemImage>()
        var isCol2Avail = false
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(2, Image2, Image2))
        Pathitems.add(ItemImage(3, Image3, Image3))
        var mCount = 0
        mCount = if (Pathitems.size > mMaxDisplay_Size) {
            mMaxDisplay_Size
        } else {
            Pathitems.size
        }
        for (k in 0 until 1) {
            var colSpan = if (Math.random() < 0.2f) 2 else 1
            if (colSpan == 2 && !isCol2Avail) {
                isCol2Avail = true
            } else if (colSpan == 2 && isCol2Avail) {
                colSpan = 1
            }
            val rowSpan = colSpan
            var item = ItemList(k, "Item #$k", Pathitems)


            if (Pathitems.size == 3) {
                Pathitems[0].columnSpan = 2
                Pathitems[0].rowSpan = 3f
                //   Pathitems[1].columnSpan = 2
                Pathitems[1].rowSpan = 1.5f
                //  Pathitems[2].columnSpan = 2
                Pathitems[2].rowSpan = 1.5f
                Pathitems[0].setPosition(currentOffset + k)
                Pathitems[1].setPosition(currentOffset + k)
                Pathitems[2].setPosition(currentOffset + k)
            } else if (Pathitems.size == 2) {
                /*  Pathitems[0].columnSpan = 1
                  Pathitems[0].rowSpan = 1*/
                Pathitems[0].columnSpan = 1
                Pathitems[1].columnSpan = 1
                Pathitems[1].rowSpan = 2f
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else if (Pathitems.size == 4) {
                Pathitems[0].columnSpan = 3
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else {
                Pathitems[0].columnSpan = 1
                Pathitems[0].rowSpan = 1f
                Pathitems[0].setPosition(currentOffset + k)
            }

            mItemList.add(item)

        }
        currentOffset += Pathitems.size
    }

    private fun setData2() {
        var Pathitems = java.util.ArrayList<ItemImage>()
        var isCol2Avail = false
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(2, Image2, Image2))
        // Pathitems.add(ItemImage(3, Image3, Image3))
        var mCount = 0
        mCount = if (Pathitems.size > mMaxDisplay_Size) {
            mMaxDisplay_Size
        } else {
            Pathitems.size
        }
        for (k in 0 until 1) {
            var colSpan = if (Math.random() < 0.2f) 2 else 1
            if (colSpan == 2 && !isCol2Avail) {
                isCol2Avail = true
            } else if (colSpan == 2 && isCol2Avail) {
                colSpan = 1
            }
            val rowSpan = colSpan
            var item = ItemList(k, "Item #$k", Pathitems)


            if (Pathitems.size == 3) {
                Pathitems[0].columnSpan = 2
                Pathitems[0].rowSpan = 3f
                //   Pathitems[1].columnSpan = 2
                Pathitems[1].rowSpan = 1.5f
                //  Pathitems[2].columnSpan = 2
                Pathitems[2].rowSpan = 1.5f
                Pathitems[0].setPosition(currentOffset + k)
                Pathitems[1].setPosition(currentOffset + k)
                Pathitems[2].setPosition(currentOffset + k)
            } else if (Pathitems.size == 2) {
                /*  Pathitems[0].columnSpan = 1
                  Pathitems[0].rowSpan = 1*/
                Pathitems[0].columnSpan = 1
                Pathitems[1].columnSpan = 1
                Pathitems[1].rowSpan = 2f
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else if (Pathitems.size == 4) {
                Pathitems[0].columnSpan = 3
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else {
                Pathitems[0].columnSpan = 1
                Pathitems[0].rowSpan = 1f
                Pathitems[0].setPosition(currentOffset + k)
            }

            mItemList.add(item)

        }
        currentOffset += Pathitems.size
    }

    private fun setData3() {
        var Pathitems = java.util.ArrayList<ItemImage>()
        var isCol2Avail = false
        Pathitems.add(ItemImage(1, Image1, Image1))
        var mCount = 0
        mCount = if (Pathitems.size > mMaxDisplay_Size) {
            mMaxDisplay_Size
        } else {
            Pathitems.size
        }
        for (k in 0 until 1) {
            var colSpan = if (Math.random() < 0.2f) 2 else 1
            if (colSpan == 2 && !isCol2Avail) {
                isCol2Avail = true
            } else if (colSpan == 2 && isCol2Avail) {
                colSpan = 1
            }
            val rowSpan = colSpan
            var item = ItemList(k, "Item #$k", Pathitems)


            Pathitems[0].columnSpan = 1
            Pathitems[0].rowSpan = 1.5f
            Pathitems[0].setPosition(currentOffset + k)


            mItemList.add(item)

        }
        currentOffset += Pathitems.size
    }

    private fun setData4() {
        var Pathitems = java.util.ArrayList<ItemImage>()
        var isCol2Avail = false
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(1, Image1, Image1))
        Pathitems.add(ItemImage(1, Image1, Image1))
        var mCount = 0
        mCount = if (Pathitems.size > mMaxDisplay_Size) {
            mMaxDisplay_Size
        } else {
            Pathitems.size
        }
        for (k in 0 until 1) {
            var colSpan = if (Math.random() < 0.2f) 2 else 1
            if (colSpan == 2 && !isCol2Avail) {
                isCol2Avail = true
            } else if (colSpan == 2 && isCol2Avail) {
                colSpan = 1
            }
            val rowSpan = colSpan
            var item = ItemList(k, "Item #$k", Pathitems)


            if (Pathitems.size == 3) {
                Pathitems[0].columnSpan = 2
                Pathitems[0].rowSpan = 3f
                //   Pathitems[1].columnSpan = 2
                Pathitems[1].rowSpan = 1.5f
                //  Pathitems[2].columnSpan = 2
                Pathitems[2].rowSpan = 1.5f
                Pathitems[0].setPosition(currentOffset + k)
                Pathitems[1].setPosition(currentOffset + k)
                Pathitems[2].setPosition(currentOffset + k)
            } else if (Pathitems.size == 2) {
                /*  Pathitems[0].columnSpan = 1
                  Pathitems[0].rowSpan = 1*/
                Pathitems[0].columnSpan = 1
                Pathitems[1].columnSpan = 1
                Pathitems[1].rowSpan = 2f
                Pathitems[0].rowSpan = 2f
                Pathitems[0].setPosition(currentOffset + k)
            } else if (Pathitems.size == 4) {
                Pathitems[0].columnSpan = 1
                Pathitems[0].rowSpan = 4f
                Pathitems[1].columnSpan = 1
                Pathitems[1].rowSpan = 4f
                Pathitems[2].columnSpan = 1
                Pathitems[2].rowSpan = 4f
                Pathitems[3].columnSpan = 1
                Pathitems[3].rowSpan = 4f
                Pathitems[0].setPosition(currentOffset + k)
            } else {
                Pathitems[0].columnSpan = 1
                Pathitems[0].rowSpan = 1f
                Pathitems[0].setPosition(currentOffset + k)
            }

            mItemList.add(item)

        }
        currentOffset += Pathitems.size
    }

}