package com.mhs.facebookimageprofile

import android.os.Bundle
import android.text.Editable
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ImageSpan
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.flexbox.AlignContent
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.AlignSelf
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.mhs.facebookimageprofile.databinding.ActivityRecyclerViewBinding
import com.mhs.facebookimageprofile.util.onActionDone


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class RecyclerViewActivity : AppCompatActivity() {


    private val OPEN_MEDIA_PICKER = 1
    private lateinit var binding : ActivityRecyclerViewBinding
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100 // Request code for read external storage



    private var SpannedLength = 0
    private var chipLength = 4

    private fun addNewChip(person: String, chipGroup: FlexboxLayout) {
        val chip = Chip(this)
        val chipDrawable = ChipDrawable.createFromResource(this, R.xml.standalone_chip)
        //chip.setLeftTopRightBottom(10,0,10,0)
        chip.setChipDrawable(chipDrawable)
        chip.text = person

  //      chip.chipIcon = ContextCompat.getDrawable(this, R.mipmap.ic_launcher_round)
   //     chip.isCloseIconEnabled = true
        chip.isClickable = true
        chip.isCheckable = false
        chip.isCloseIconVisible =true
      /*  chipGroup.alignItems = AlignItems.CENTER
        chipGroup.alignContent = AlignContent.SPACE_BETWEEN*/
        chipGroup.addView(chip as View, chipGroup.childCount - 1)
        chip.setOnCloseIconClickListener { chipGroup.removeView(chip as View) }
        binding.recipientInputET.text.clear()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.recipientInputET.doAfterTextChanged {
            if(it.toString().contains(",")){

            }
        }*/
        binding.recipientInputET.onActionDone {
            if (it == EditorInfo.IME_ACTION_DONE) {
                if(binding.recipientInputET.text.toString().trim().isNotEmpty())
                addNewChip(binding.recipientInputET.text.toString(),binding.recipientGroupFL)
            }
            false
        }
        binding.recipientInputET.doAfterTextChanged { s->
            if(s.toString().trim().isNotEmpty()){
                if(s.toString().contains(";") || s.toString().contains(" ")){
                    addNewChip(s.toString().substring(0,s.toString().length-1),binding.recipientGroupFL)
                }
            }
        }
    }

    private var start = 0
    private fun makeChip(toString: Editable?) {
        val chipDrawable = ChipDrawable.createFromResource(this, R.xml.standalone_chip)
        /*chipDrawable.setBounds(0, 0, chipDrawable.intrinsicWidth, chipDrawable.intrinsicHeight)
        val span = ImageSpan(chipDrawable)
        val txt = toString!!
        chipDrawable.text = toString.toString()
        txt.setSpan(span, txt.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)*/
        chipDrawable.setBounds(0, 0, chipDrawable.intrinsicWidth, chipDrawable.intrinsicHeight)
        val span = ImageSpan(chipDrawable)
        val text = toString!!
        chipDrawable.text = toString.toString().substring(start,text.length-1)
        text.setSpan(span, start, text.length-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        start = toString.length

    }

    /*  private fun permissionIfNeeded(): Boolean {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
              if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                  != PackageManager.PERMISSION_GRANTED) {
                  // Should we show an explanation?
                  if (shouldShowRequestPermissionRationale(
                          Manifest.permission.READ_EXTERNAL_STORAGE)) {
                      // Explain to the user why we need to read the contacts
                  }

                  requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                      MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
                  return true
              }
          }
          return false
      }
      @Deprecated("Deprecated in Java")
      override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
          super.onActivityResult(requestCode, resultCode, data)
          // Check which request we're responding to
          if (requestCode == OPEN_MEDIA_PICKER) {
              // Make sure the request was successful
              if (resultCode == Activity.RESULT_OK && data != null) {
                  val selectionResult = data.getStringArrayListExtra("result")
                  selectionResult?.forEach {
                      try {
                          Log.d("MyApp", "Image Path : " + it)
                          val uriFromPath = Uri.fromFile(File(it))
                          Log.d("MyApp", "Image URI : " + uriFromPath)
                          // Convert URI to Bitmap
                          val bm = BitmapFactory.decodeStream(
                              contentResolver.openInputStream(uriFromPath))
                          binding.imageS.setImageBitmap(bm)
                      } catch (e: FileNotFoundException) {
                          e.printStackTrace()
                      }
                  }
              }
          }
      }*/
}