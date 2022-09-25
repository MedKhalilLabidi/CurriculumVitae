package com.example.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.fullname)
        val age = findViewById<EditText>(R.id.Age)
        val email = findViewById<EditText>(R.id.Email)
        val skills = mapOf("Android" to R.id.Android,"IOS" to R.id.IOS, "Flutter" to R.id.Flutter)
        findViewById<SeekBar>(R.id.IOS).setMax(100)
        findViewById<SeekBar>(R.id.Android).setMax(100)
        findViewById<SeekBar>(R.id.Flutter).setMax(100)
        val submitButton = findViewById<Button>(R.id.next)
        val resetButton =findViewById<Button>(R.id.reset)
        val HB=findViewById<RadioButton>(R.id.hommeRb)


        submitButton.setOnClickListener {
            if( (TextUtils.isEmpty(email.text.toString())) || (TextUtils.isEmpty(name.text.toString())) || (TextUtils.isEmpty(age.text.toString()))) {

                Toast.makeText(this,"Check Input!!",Toast.LENGTH_LONG).show()


            }

           else if(!EMAIL_ADDRESS.matcher(email.text).matches()) {

                Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
            }
            else {

                checkskills(skills)

            }
        }

        resetButton.setOnClickListener{
            name.getText().clear()
            age.getText().clear()
            email.getText().clear()
             HB.setChecked(true)
            findViewById<SeekBar>(R.id.IOS).setProgress(0)
            findViewById<SeekBar>(R.id.Android).setProgress(0)
            findViewById<SeekBar>(R.id.Flutter).setProgress(0)


        }




    }

    fun checkskills(seekbars: Map<String,Int>)
    { var counter=0
        var i=0
        seekbars.forEach(){ entry ->
            if (findViewById<SeekBar>(entry.value).progress > 80 )
            {
                Toast.makeText(this, "vous etes excellent en ${entry.key} ", Toast.LENGTH_SHORT).show()
i++
            }

            else if(findViewById<SeekBar>(entry.value).progress <=30 )
            {
                counter++

            }

        }
        if(counter==3)   { Toast.makeText(this, "Vous devez travailler vos skills ", Toast.LENGTH_SHORT).show()
            i++}
if(i==0){ Toast.makeText(this, "Vous Avez de bons skills! ", Toast.LENGTH_SHORT).show()

}
    }
}
