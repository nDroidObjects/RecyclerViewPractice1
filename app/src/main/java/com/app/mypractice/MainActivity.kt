package com.app.mypractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var adapter: MyAdapter

    private val items = (1..10).map {
        Item(it, "Item $it", "http://lorempixel.com/200/200/animals/$it/")
    }

    /*private val items: List<Item>
        get() = (1..10).map { Item(it, "Item $it", "http://lorempixel.com/200/200/animals/$it/") }*/


    fun generate(): List<Item> {
        val rand = Random(System.currentTimeMillis())
        return items.filter { rand.nextBoolean() }
    }

    private fun showToast(it: Item) {
        Toast.makeText(
            this,
            "${it.title} Clicked",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = GridLayoutManager(this, 2)



        adapter = MyAdapter(items) { it: Item ->
            Toast.makeText(
                this,
                "${it.title} Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

     //   adapter = MyAdapter(items) { showToast(it) }



        //adapter = MyAdapter(items, this::showToast)

       // adapter = MyAdapter(items = items) { showToast(it) }

        /* Explicit Lambda Signature*/
        /*adapter = MyAdapter(items) { it: Item ->
            Toast.makeText(this, "${it.title} Clicked", Toast.LENGTH_SHORT).show()
        }*/


        //Anonymous Function
        /* adapter = MyAdapter(items, fun(it: Item) {
             Toast.makeText(this, "${it.title} Clicked", Toast.LENGTH_SHORT).show()
         })*/


        //adapter = MyAdapter(generate(),this::showToast );



        recycler.adapter = adapter


    }
}
