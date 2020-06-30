package com.example.di_android2

import android.util.TimeUtils
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.runners.model.TestTimedOutException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


//  object LiveDataTestUtil{
@VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun  <T> LiveData<T>.getorAwaitValue (time:Long =2, timeUtils: TimeUnit=TimeUnit.SECONDS, afterObserve: () -> Unit ={}):T{

    val  latch = CountDownLatch(1)
    var data :T? =null
    val observer = object: Observer<T>{
        override fun onChanged(t: T?) {
            data=t
            latch.countDown()
            this@getorAwaitValue.removeObserver(this)
        }

    }
          this.observeForever(observer)

        try{
            afterObserve.invoke()

            if(!latch.await(time,timeUtils)){
                throw TimeoutException("LiveData value was never set ")
            }
        }finally {
            this.removeObserver(observer)
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
}

//}



/*
object LiveDataTestUtil {

    */
/**
     * Get the value from a LiveData object. We're waiting for LiveData to emit, for 2 seconds.
     * Once we got a notification via onChanged, we stop observing.
     *//*

    fun <T> getValue(liveData: LiveData<T>): T {
        val data = arrayOfNulls<Any>(1)
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data[0] = o
                latch.countDown()
                liveData.removeObserver(this)
            }
        }
        liveData.observeForever(observer)
        latch.await(2, TimeUnit.SECONDS)

        @Suppress("UNCHECKED_CAST")
        return data[0] as T
    }
}

*/

