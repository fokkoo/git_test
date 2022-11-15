package com.example.git_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.git_test.model.DetailViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    //  private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   binding = ActivityMainBinding.inflate(layoutInflater)
        //   setContentView(binding.root)
        setContentView(R.layout.activity_main)

        readSettings()
        initeMyView()

        //   binding.textView.text = "binding text"
        //    binding.button3.text = "binding text"

        //    FrameLayout layout = new FrameLayout(this);
        //    layout.setLayoutParms(new ViewGroup)

    }

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
        findViewById<View>(R.id.button_recycl_view).setOnClickListener {
        //    addFragment(Fragment1firstRW())

            val weather: Weather = Weather(
                    getDefaultCity(), 0, 0
            )




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
        findViewById<View>(R.id.Button_History).setOnClickListener {
            addFragment(HistoryFragment())

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка Button_History вызвана", Toast.LENGTH_SHORT
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