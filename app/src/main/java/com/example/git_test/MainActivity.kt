package com.example.git_test

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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


      //  val v = inflater.inflate(R.layout.fragment_train, container, false)

       /*
        val recyclerView: RecyclerView = findViewById(R.id.ProgramTrainRecycleView)
        val adapter = ItemAdapterProgram(
            arrayOf(
                "1",
                "2"
            )
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idHistory -> {


                Log.d("TAG", "idHistory is pressed")

                supportFragmentManager.apply {
                    beginTransaction().replace(R.id.fragment_container, HistoryFragment())
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                }
                true
            }
            R.id.idBarGraf -> {
                supportFragmentManager.apply {
                    beginTransaction().replace(R.id.fragment_container, FragmentBar())
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                }
                true
            }
            R.id.idJavaFragment -> {
                supportFragmentManager.apply {
                    beginTransaction().replace(R.id.fragment_container, TrainFragment())
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


        val firstStart = true

    if ( firstStart == true) {
        supportFragmentManager.apply {
            beginTransaction().replace(R.id.fragment_container, StartMenuFragment())
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
        firstStart == false
    }


        binding.ButtonHistory.setOnClickListener() {
            //
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.fragment_container, StartMenuFragment())
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }




            //true


/*
            val KEY_MSG_1 = "FRAGMENT1_MSG"
            val TAG_1 = "FRAGMENT_1"
            val fragment: HistoryFragment = myFragmentManager
                .findFragmentByTag(TAG_1) as MyFragment1

            val bundle = Bundle()
            bundle.putString(KEY_MSG_1, "Заменили на первый фрагмент")
            HistoryFragment.setArguments(bundle)

            val fragmentTransaction: FragmentTransaction = myFragmentManager
                .beginTransaction()
            fragmentTransaction.replace(
                R.id.fragment_container, HistoryFragment,
                TAG_1
            )
            fragmentTransaction.commit()

*/



            //
         /*   addFragment(HistoryFragment())

            val toast = Toast.makeText(
                    applicationContext,
                    "Кнопка Button_History вызвана", Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show()
*/

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

        transaction.replace(R.id.fragment_container, fragment)

        transaction.commit()
    }


    private fun addFragment2(fragment: Fragment) {
/*
        //Получить менеджер фрагментов
        val fragmentManager = supportFragmentManager

        // Открыть транзакцию
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Удалить видимый фрагмент
        if (Settings.isDeleteBeforeAdd) {
            val fragmentToRemove = getVisibleFragment(fragmentManager)
            if (fragmentToRemove != null) {
                fragmentTransaction.remove(fragmentToRemove)
            }
        }

        // Добавить фрагмент
        if (Settings.isAddFragment) {
            fragmentTransaction.add(R.id.fragment_container, fragment)
        } else {
            fragmentTransaction.replace(R.id.fragment_container, fragment)
        }

        // Добавить транзакцию в бэкстек
        if (Settings.isBackStack) {
            fragmentTransaction.addToBackStack(null)
        }

        // Закрыть транзакцию
        fragmentTransaction.commit()*/
    }
}