package com.milestone.fitnesspersonaltrainer.listener

/**
 * Created by ThinkPad on 2017/11/2.
 */
interface OnBaseNetworkListener {
    fun onFailure(errorMsg: String?)
    fun onSuccess(any: Any)
}