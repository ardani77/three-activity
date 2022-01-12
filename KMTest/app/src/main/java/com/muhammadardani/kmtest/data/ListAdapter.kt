package com.muhammadardani.kmtest.data

import android.app.Activity
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.muhammadardani.kmtest.R
import com.muhammadardani.kmtest.data.response.Data
import com.muhammadardani.kmtest.data.response.SelectedName
import com.squareup.picasso.Picasso

class ListAdapter(var nameList: List<Data>, var context: Activity) : ArrayAdapter<Data>(context, R.layout.list_item, nameList){//    override fun getItem(position: Int): Any {
//        return standingList.get(position)
//    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return nameList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //val view: View = View.inflate(context ,R.layout.item_card,null)
        val layoutInflayer : LayoutInflater = LayoutInflater.from(context)
        val view : View = layoutInflayer.inflate(R.layout.list_item, null)
        val first_name: TextView = view.findViewById(R.id.firstName)
        val last_name: TextView = view.findViewById(R.id.lastName)
        val mail_name: TextView = view.findViewById(R.id.mailName)
        val image_profil: ImageView = view.findViewById(R.id.imageProfil)

        val konten = nameList.get(position)
        first_name.text = konten.first_name
        last_name.text = konten.last_name
        mail_name.text = konten.email
        Picasso.get().load(konten.avatar).into(image_profil)
//        val bitmap = BitmapFactory.decodeFile(konten.avatar)
//        image_profil.setImageBitmap(bitmap)
//        image_profil.setImageURI(konten.avatar)
        println(konten.email)

        return view
    }
}