package com.example.di_android2

import android.util.TimeUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.runners.model.TestTimedOutException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

//class LiveDataTestUtil (time:Long,timeUtils: TimeUnit, afterObserve: () -> Unit,){


    fun  <T> LiveData<T>.liveDataTestUtil (time:Long =2, timeUtils: TimeUnit=TimeUnit.SECONDS, afterObserve: () -> Unit ={})
            :T{
    val  latch = CountDownLatch(1)

    var data :T? =null
    val observer = object: Observer<T>{
        override fun onChanged(t: T?) {
            data=t
            latch.countDown()
            this@liveDataTestUtil.removeObserver(this)
        }

    }
          this.observeForever(observer)

        try{
            afterObserve.invoke()

            if(!latch.await(time,timeUtils)){
                throw TestTimedOutException("LiveData value was never set ")
            }
        }finally {
            this.removeObserver(observer)
        }

        @Suppress("UNCHECKED_CAST")
        return data as T
}

//}

