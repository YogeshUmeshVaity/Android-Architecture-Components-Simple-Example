package basicexample.androidarchitecturecomponentssimpleexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    // Provide ViewModel to the Activity
    private val viewModel: MyViewModel by lazy {
        ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    // Define what to with the value once we are notified of the change.
    // We are updating the text of TextView with the provided Int value.
    // TODO: Use SAM constructor
    // What this Observer does (its behaviour) is provided through its constructor function.
    private val changeObserver = Observer<Int>(fun(intValue: Int?) {
        if (intValue != null) {
            updateTextView(intValue)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register/subscribe the Observer with the ViewModel
        // observe() documentation has useful info
        viewModel.changeNotifier.observe(this, changeObserver)

        // User changes the data through Activity
        // Activity updates the data through ViewModel object reference
        // Activity can also send any data to ViewModel through this function
        my_container.setOnClickListener { incrementValue() }
    }

    override fun onResume() {
        super.onResume()
        incrementValue()
    }

    private fun incrementValue() {
        viewModel.increment()
    }

    private fun updateTextView(intValue: Int) {
        my_text.text = intValue.toString()
    }
}
