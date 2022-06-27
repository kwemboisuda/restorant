package com.intellectitech.restaurant_menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var listOfFoods = ArrayList<Foods>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Load foods
        listOfFoods.add(Foods("Coffee","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.coffee_pot))
        listOfFoods.add(Foods("blackTea","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.espresso))
        listOfFoods.add(Foods("KFC","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.french_fries))
        listOfFoods.add(Foods("Honey","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.honey))
        listOfFoods.add(Foods("Ice cream","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Foods("Sugar","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds ",R.drawable.sugar_cubes))
        listOfFoods.add(Foods("Chicken","Chicken is deep flied ",R.drawable.chicken))
        listOfFoods.add(Foods("Rolex","Rolex made from chapati and flied eggs ",R.drawable.rollex))


        adapter =FoodAdapter(this,listOfFoods)
        //Assign our list to the gridview id
        findViewById<GridView>(R.id.gvfoodlist).adapter=adapter

    }
    class FoodAdapter: BaseAdapter {
        var listOfFoods =ArrayList<Foods>()
        var context: Context? =null
        constructor(context: Context, listOfFoods:ArrayList<Foods>):super(){
            this.context=context
            this.listOfFoods=listOfFoods
        }

        override fun getCount(): Int {
            return listOfFoods.size
        }

        override fun getItem(p0: Int): Any {
            return listOfFoods [p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food =this.listOfFoods[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView =inflator.inflate(R.layout.food_ticket,null)
            foodView.findViewById<ImageView>(R.id.ticketimage).setImageResource(food.image!!)
            foodView.setOnClickListener{
                val intent = Intent(context,fooddetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)


            }
            foodView.findViewById<TextView>(R.id.tvfoodticket).text = food.name!!
            return foodView
        }


    }

}