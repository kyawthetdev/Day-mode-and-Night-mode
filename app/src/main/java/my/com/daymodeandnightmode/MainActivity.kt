package my.com.daymodeandnightmode

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //SharedPreferences နဲ့ theme change တာပါ။
        /**
         * style.xml ထဲမှာ theme (၂)မျိုးထည့်ထားဖို့ လို ပါတယ်။
         * example theme
         * <style name="DayTheme" parent="Theme.AppCompat.Light"/>
         * <style name="NightTheme" parent="Theme.AppCompat"/>
         *
         * AndroidManifest.xml က
         * android:theme="@style/AppTheme" ကို ဖျက်ထားပေးဖို့လိုပါတယ်။
         */



        /**********************************************************/

        val theme = getSharedPreferences("Theme", Context.MODE_PRIVATE)
        val currentTheme = theme.getString("themeListener", "DAY_THEME")

        if (currentTheme.equals("DAY_THEME")) {
            setTheme(R.style.DayTheme)
        } else if (currentTheme.equals("NIGHT_THEME")) {
            setTheme(R.style.NightTheme)
        }

        /**********************************************************/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        day.setOnClickListener {

            //အောက် က saveTheme Method ကို ခေါ် သုံးတာ ဖြစ်ပါတယ်။
            saveTheme("DAY_THEME")

            //Activity ကို recreate ပြန်လုပ်တာဖြစ်ပါတယ်။
            recreate()
        }

        night.setOnClickListener {

            //အောက် က saveTheme Method ကို ခေါ် သုံးတာ ဖြစ်ပါတယ်။
            saveTheme("NIGHT_THEME")

            //Activity ကို recreate ပြန်လုပ်တာဖြစ်ပါတယ်။
            recreate()
        }

        next.setOnClickListener {

            val intentNext = Intent(this@MainActivity, Next::class.java)
            startActivity(intentNext)

        }

    }

    /**********************************************************/
    private fun saveTheme(theme: String) {

        val chooserTheme = getSharedPreferences("Theme", Context.MODE_PRIVATE)
        val themeEditor = chooserTheme.edit()
        themeEditor.putString("themeListener", theme)
        themeEditor.apply()

    }
    /**********************************************************/

}
