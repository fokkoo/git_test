package com.example.git_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.git_test.databinding.ActivityMainBinding
import com.example.git_test.model.DetailFragment
import com.example.git_test.model.DetailViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        readSettings()
        initeMyView()

        //  binding.textView.text = "binding text"
        //    binding.button3.text = "binding text"

        //    FrameLayout layout = new FrameLayout(this);
        //    layout.setLayoutParms(new ViewGroup)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idHistory -> {
                supportFragmentManager.apply {
                    beginTransaction().add(R.id.fragment_container, HistoryFragment())
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.historyItemIdCard->{
                supportFragmentManager.apply {
                    beginTransaction()
                            .replace(R.id.fragment_container,HistoryFragment())
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                }
                true
            }
           else -> super onOptionsItemSelected(item)

        }

       // return super.onOptionsItemSelected(item)
    }
*/
    private fun readSettings() {
        /*   FragmentSettings.radioButtonAddConstant =
                   getSharedPreferences(FragmentSettings.SETTINGS, MODE_PRIVATE).getBoolean(
                           FragmentSettings.RADIO_BUTTON_ADD_FRAGMENT,
                           false
                   )*/
    }


    //R.id.button_recycl_view
    //binding.buttonRecyclView.id
    private fun initeMyView() {


        binding.ButtonHistory.setOnClickListener() {

            addFragment(HistoryFragment())

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка Button_History вызвана", Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show()


        }



        findViewById<View>(R.id.button_recycl_view).setOnClickListener {
            //  addFragment(Fragment1firstRW())


            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка РВ фрагмента вызвана", Toast.LENGTH_SHORT
            )
            toast.show()
        }
        findViewById<View>(R.id.button_fragment2).setOnClickListener {


            addFragment(HistoryFragment())

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка второго фрагмента вызвана", Toast.LENGTH_SHORT
            )
            toast.show()
        }

        /*  findViewById<View>(R.id.Button_History).setOnClickListener {

          }
          */
        findViewById<View>(R.id.button_detail_fragment).setOnClickListener {
            addFragment(DetailFragment())

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка Button_DetailFragment вызвана", Toast.LENGTH_SHORT
            )
            toast.show()
        }


    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fragment_container, fragment)

        transaction.commit()
    }
}