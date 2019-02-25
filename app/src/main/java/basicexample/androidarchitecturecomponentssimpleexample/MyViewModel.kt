package basicexample.androidarchitecturecomponentssimpleexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * ViewModel processes the data (Int data), which resides in its property (count)
 * ViewModel has the LiveData object.
 * LiveData holds data (data of type Int here).
 * When you change the value of LiveData, whoever subscribed to it, will be notified (Activity here)
 */
class MyViewModel(private var count: Int = 0) : ViewModel() {
    val changeNotifier = MutableLiveData<Int>()

    // Processes and updates the data of LiveData object.
    fun increment() {
        changeNotifier.value = ++count
    }
}
