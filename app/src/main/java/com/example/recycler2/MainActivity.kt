package com.example.recycler2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycler2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUp()
    }

    private fun setUp(){

        val name = getString(R.string.product_name)
        val productList = mutableListOf<Product>(
            Product(OutfitType.PARTY,120,name) ,
            Product(OutfitType.BEACH,120,name),
            Product(OutfitType.RENDOM,120,name),
            Product(OutfitType.CAMPING,120,name)
        )

        giveListFiltered(productList,OutfitType.ALL)

        bindingAllViews(productList)
    }

    private fun bindingAllViews(productList: MutableList<Product>){

        binding.apply{

            allBtn.setOnClickListener {
                giveListFiltered(productList,OutfitType.ALL)
            }

            partyBtn.setOnClickListener {
                giveListFiltered(productList,OutfitType.PARTY)
            }

            campingBtn.setOnClickListener {
                giveListFiltered(productList,OutfitType.CAMPING)
            }

            beachBtn.setOnClickListener {
                giveListFiltered(productList,OutfitType.BEACH)
            }
        }



    }

    private fun giveListFiltered(productList:MutableList<Product>, typeOfOutfit : OutfitType){

        val numberOfColumns = 2

        var listToCast = mutableListOf<Product>()

        if(typeOfOutfit == OutfitType.ALL) listToCast = productList
        else{
            productList.forEach {
                if(it.outfitType == typeOfOutfit) listToCast.add(it)
            }
        }

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, numberOfColumns)
            adapter = ListAdapter1(listToCast)
        }
    }
}