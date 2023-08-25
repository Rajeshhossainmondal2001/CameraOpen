package com.example.cameraopen

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    // Define the button and image type variable

    lateinit var cameraOpenId: Button
    lateinit var clickImageId: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cameraOpenId = findViewById(R.id.camera_button)
        clickImageId = findViewById(R.id.click_image)

        cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, pic_id)
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Match the request pic id with requestcode
        if (requestCode == pic_id) {
            // Bitmap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // set the image in imageview for display
            clickImageId.setImageBitmap(photo)

        }
    }

    companion object{
        //Define the pic id
        private const val pic_id =123
    }
}