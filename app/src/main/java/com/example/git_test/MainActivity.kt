package com.example.git_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readSettings()
        initeMyView()


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

    private fun initeMyView() {
        findViewById<View>(R.id.button_recycl_view).setOnClickListener{
            addFragment(Fragment1firstRW());

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка РВ фрагмента вызвана", Toast.LENGTH_SHORT
            )
            toast.show()
        }
        findViewById<View>(R.id.button_fragment2).setOnClickListener{
            addFragment(BlankFragment());

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка второго фрагмента вызвана", Toast.LENGTH_SHORT
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


