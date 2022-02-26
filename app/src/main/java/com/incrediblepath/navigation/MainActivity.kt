package com.incrediblepath.navigation

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    // we will get reference of our navigation controller object
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get the references of views from our layout file
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        //NavController is the controller which is assosciated with our Navigation Host View or the Container View
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        navController = navHostFragment!!.findNavController()
        //create navigationcontroller and setup with Navcontroller
        navigationView.setupWithNavController(navController)


        //if you want to listen to events inside drawer menu use below code
        navigationView.setNavigationItemSelectedListener{
            if(it.itemId == R.id.first_item){
                Toast.makeText(this,"show some action",Toast.LENGTH_LONG).show()
                //startActivity(Intent(this,BottomNavigationActivity::class.java))
                startActivity(Intent(this,BottomNavigationActivity::class.java))
                drawerLayout.closeDrawer(GravityCompat.START,false)
            }
            true
        }

        //Creating custom AppBar Configuration with drawer menu
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        //for listening events on destination changes add a listner similar to on click listner

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            if(navDestination.id == R.id.firstFragment){
                Toast.makeText(this,"navigated to first",Toast.LENGTH_SHORT).show()
            }else if(navDestination.id == R.id.secondFragment){
                Toast.makeText(this,"navigated to second",Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }




    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}