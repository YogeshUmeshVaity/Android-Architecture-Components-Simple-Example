package basicexample.androidarchitecturecomponentssimpleexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        my_container.setOnClickListener { incrementCount() }
    }

    override fun onResume() {
        super.onResume()
        incrementCount()
    }

    private var count: Int = 0

    private fun incrementCount() {
        my_text.text = (++count).toString()
    }
}
