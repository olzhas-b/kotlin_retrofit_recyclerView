package com.example.kotlin_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var recyclerAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

//        for(i in 0..100){
//            users.add(User("Daniel","Malone","dan"))
//        }

        //initRecyclerView()
//        addDataSet()


    }
    private fun showData(user: List<User>){
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.apply {

            adapter = RecyclerViewAdapter(user)
        }
    }

//sdafsavvdsvsdbfdbzsvzdssvs    private fun addDataSet(){
//        val data = DataSource.createDataSet()
//        recyclerAdapter.submitList(data)
//    }

//    private fun initRecyclerView(){
//        val data = DataSource.createDataSet()
//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            //recyclerAdapter = RecyclerViewAdapter(data)
//            adapter = recyclerAdapter(users)
//        }
//    }

}

