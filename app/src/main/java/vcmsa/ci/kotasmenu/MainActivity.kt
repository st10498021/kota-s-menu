package vcmsa.ci.kotasmenu

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    private var editTextText: EditText? = null
    private var txtmenu: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editTextText = findViewById(R.id.editTextText)
        txtmenu = findViewById(R.id.txtmenu)


        val enterBtn = findViewById<Button>(R.id.enterBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)

        enterBtn.setOnClickListener {
            enter()
        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        clearBtn.setOnClickListener {
            editTextText?.text?.clear()
            txtmenu?.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    @SuppressLint("SetTextI18n")
    private fun enter() {

        when (editTextText?.text.toString().trim()) {

            "Morning" -> txtmenu?.text = "2 fried eggs, 3 bacon rashers, grilled onions and toast" +
                    "oatmeal with orange juice and some yogurt on the side" +
                    "chicken livers with toast on the side" +
                    "avocadoes smash to the sandwich with some cheese and chill"

                    "Mid morning" -> txtmenu?.text = "grapes with apples" +
                    "noodles with beans" +
                    "beef burger with a milkshake"

                "Afternoon"-> txtmenu?.text = "Pap with spinach and coselaw on the side" +
                "Bunny chow filled  with coselaw, meat and cheese" +
                "Chill with my own secret recipe" +
                "BBQ ribs with chips on the side"

            "Mid-Afternoon" -> txtmenu?.text = "T-bone steak with a salad and chips on the side" +
                    "king size burger with a coke, Creamdog with a milkshake and some ice cream"

                "Dinner"  -> txtmenu?.text = "Chicken samoosas with dunked wing and onion rings" +
                "nacho chips with a lava of cheese and ribs" +
                "Rib Bone and some chips with a touch of cheese"

            else ->
                txtmenu?.text = "Invalid time of the day, enter what is provided in the example above"




            }
        }
    }





