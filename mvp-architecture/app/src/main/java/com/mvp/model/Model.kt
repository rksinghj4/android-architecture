package com.mvp.model

import com.mvp.common.Contract
import kotlin.random.Random

class Model : Contract.Model {

    private val alphabets =
        listOf<String>("AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK")

    /**
     *  When user click on Next Button on UI, we call clickListener method of presenter which intern
     *  invoke getNextAlphabet method of model
     */
    override fun getNextAlphabet(listener: Contract.Model.OnFinishListener) {

        android.os.Handler().post(Runnable {
            Thread.sleep(1000)
            //simulate the Api call and inform the presenter about completion of network call
            listener.onFinished(result = alphabets[Random.nextInt(alphabets.size)])
        })
    }
}