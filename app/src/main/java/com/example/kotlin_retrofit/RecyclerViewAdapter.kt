package com.example.kotlin_retrofit


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_item.view.*


class RecyclerViewAdapter(private  val Constructor_Post: List<User>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val holder = ViewHolder(view)

        view.setOnClickListener {
            val intent = Intent(parent.context, User_Details::class.java)
            //intent.putExtra("description", Constructor_Post[holder.adapterPosition].email)
            intent.putExtra("username", Constructor_Post[holder.adapterPosition].name)
           // intent.putExtra("image", Constructor_Post[holder.adapterPosition].image)
            parent.context.startActivity(intent)

        }
        return holder
    }


    override fun getItemCount(): Int = Constructor_Post.size

//    fun submitList(blogList: List<User>) {
//        = blogList
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.username.text = Constructor_Post[position].name

        when(holder) {
            is ViewHolder -> {
                holder.bind(Constructor_Post.get(position))

            }
        }




    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val description: TextView = itemView.description_TextView
        val image: ImageView = itemView.imageView
        val username: TextView = itemView.username_TextView

        fun bind(constructor_post: User){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(requestOptions)
//                .load(constructor_post.image)
//                .into(image)
//            Glide.with(itemView.context)
//                .asBitmap()
//                .load(constructor_post.image)
//                .apply(RequestOptions()
//                    .fitCenter()
//                    .placeholder(R.drawable.abc_ab_share_pack_mtrl_alpha)
//                    .error(R.drawable.abc_ab_share_pack_mtrl_alpha))
//                .into(image)
//


          //  description.setText(constructor_post.description)
            username.setText(constructor_post.name)


        }



    }
}
