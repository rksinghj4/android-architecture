package com.mvp.presenter

import com.mvp.common.Contract

//Better to avoid implementing api listeners i.e (Contract.Model.OnFinishListener) at class level
class Presenter(
    private var view: Contract.View?,
    private val model: Contract.Model
) : Contract.Presenter, Contract.Model.OnFinishListener {


    override fun fetchNextAlphabet() {
        view?.onShowProgress()
        //Arther than passing the entire Presenter. Better to pass the call back here
        model.getNextAlphabet(this)
        //model.getNextAlphabet { result -> } : Better to pass lambda
    }

    //Note we pass this as lambda in getNextAlphabet({result -> })
    override fun onFinished(result: String) {
        view?.onHideProgress()//Null check is must on view
        view?.setData(result)
    }

    override fun onDestroy() {
        view = null//To break the reference link to object. GC can freely collect
    }
}