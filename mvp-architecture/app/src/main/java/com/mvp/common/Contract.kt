package com.mvp.common

interface Contract {
    //Have M V P interfaces inside Contract
    interface Model {
        fun interface OnFinishListener {
            //Write all callback methods here in Model's Listener interface
            // so that presenter can listen all scenarios like Success or failure/error
            fun onFinished(result: String)
        }

        //Write all functions for any api call in Model, so that presenter can call them as needed
        fun getNextAlphabet(listener: OnFinishListener)
    }

    interface Presenter {
        //view will call presenter's onButtonClick method(better name fetchNextData() method)
        fun fetchNextAlphabet()

        //Clear the view object in side presenter
        fun onDestroy()
    }

    interface View {

        //Hide progress when firing the api
        fun onHideProgress()

        //Show progress when firing the api
        fun onShowProgress()

        fun setData(result: String)
    }
}