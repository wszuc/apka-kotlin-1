package com.example.zad_wykl_1

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView

enum class Layouts {
    main, rower, programowanie, szachy, o_mnie
}

class MainActivity : AppCompatActivity() {

    var current_layout = Layouts.main
    var sound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        refreshLayout()
    }

    private fun refreshLayout() {
        if(current_layout == Layouts.main){
            setContentView(R.layout.activity_main)
            val o_mnie: Button = findViewById(R.id.o_mnie)
            val rower: Button = findViewById(R.id.rower)
            val programowanie: Button = findViewById(R.id.programowanie)
            val szachy: Button = findViewById(R.id.szachy)

            findViewById<TextView>(R.id.header).text = "Moje zainteresowania:"
            o_mnie.text = "O mnie"
            rower.text = "Rower 🚲"
            programowanie.text = "Programowanie ⌨"
            szachy.text = "Koty 😺"

            rower.setOnClickListener{
                current_layout = Layouts.rower
                refreshLayout()
            }
            programowanie.setOnClickListener{
                current_layout = Layouts.programowanie

                refreshLayout()
            }
            szachy.setOnClickListener{
                current_layout = Layouts.szachy

                refreshLayout()
            }
            o_mnie.setOnClickListener{
                current_layout = Layouts.o_mnie

                refreshLayout()
            }
        }
        else if(current_layout == Layouts.rower) {
            setContentView(R.layout.rower)
            findViewById<TextView>(R.id.header_rower).text = "🚲\nJazda na rowerze to moja pasja!"
            findViewById<TextView>(R.id.quiz_rower).text =
                "Poniżej znajduje się zdjęcie mojego roweru. Zgadnij, jaki typ roweru to jest:"

            val buttonMTB :RadioButton = findViewById(R.id.radio_mtb)
            val buttonKolarz :RadioButton = findViewById(R.id.radio_kolarzówka)
            val buttonMiejski :RadioButton = findViewById(R.id.radio_miejski)

            buttonMTB.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    buttonMTB.setTextColor(Color.GREEN)
                } else {
                    buttonMTB.setTextColor(Color.BLACK)
                }
            }
            buttonMiejski.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    buttonMiejski.setTextColor(Color.RED)
                } else {
                    buttonMiejski.setTextColor(Color.BLACK)
                }
            }
            buttonKolarz.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    buttonKolarz.setTextColor(Color.RED)
                } else {
                    buttonKolarz.setTextColor(Color.BLACK)
                }
            }
            findViewById<Button>(R.id.backButton).setOnClickListener{
                current_layout = Layouts.main
                refreshLayout()
            }
        }
        else if(current_layout == Layouts.programowanie){
            setContentView(R.layout.programowanie)
            val buttonJS :ImageButton = findViewById(R.id.jsButton)
            val buttonCpp :ImageButton = findViewById(R.id.cppButton)
            val cppText = findViewById<TextView>(R.id.cppText)
            val jsText = findViewById<TextView>(R.id.jsText)
            cppText.visibility = View.INVISIBLE
            jsText.visibility = View.INVISIBLE
            buttonJS.setOnClickListener{
                jsText.visibility = View.VISIBLE
            }
            buttonCpp.setOnClickListener{
                cppText.visibility = View.VISIBLE
            }
            findViewById<Button>(R.id.backButton).setOnClickListener{
                current_layout = Layouts.main
                refreshLayout()
            }
        }
        else if(current_layout == Layouts.szachy){
            setContentView(R.layout.szachy)
            val buttonFrania :ImageButton = findViewById(R.id.buttonFrania)
            buttonFrania.setOnClickListener{
                if (sound == null) {
                    sound = MediaPlayer.create(this, R.raw.catmoo)
                    sound!!.start()
                } else sound!!.start()
            }
            findViewById<Button>(R.id.backButton).setOnClickListener{
                current_layout = Layouts.main
                refreshLayout()
            }
        }
        else if(current_layout == Layouts.o_mnie){
            setContentView(R.layout.o_mnie)
            findViewById<Button>(R.id.backButton).setOnClickListener{
                current_layout = Layouts.main
                refreshLayout()
            }
        }
    }
}