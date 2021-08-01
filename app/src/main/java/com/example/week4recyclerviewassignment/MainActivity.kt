package com.example.week4recyclerviewassignment


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), OnContactClickListener {

    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {

//        val navView: NavigationView? = findViewById(R.id.nav_view)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout:DrawerLayout = findViewById(R.id.drawerLayout)
       val toolbar:androidx.appcompat.widget.Toolbar? = findViewById(R.id.nav_tool_bar_title)
        toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)

            var contactAdapter = ContactAdapter(Datas.listOfData,this)
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.adapter = ContactAdapter(Datas.listOfData,this)
        rv.layoutManager = LinearLayoutManager(this)
        contactAdapter.notifyDataSetChanged()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun OnContactItemClicked(position: Int) {
        val intent = Intent(this,DetailsContact::class.java)
        intent.putExtra("info",Datas.listOfData[position])
        startActivity(intent)

    }
}