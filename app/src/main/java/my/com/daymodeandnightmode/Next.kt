package my.com.daymodeandnightmode

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class Next : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        //SharedPreferences နဲ့ theme change တာပါ။

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
        setContentView(R.layout.activity_next)
        //TextView မှာ စာသား ထည့်တာ
        textView.setText(R.string.next_text)
    }
}
