package com.pieterventer.quotemeonthis.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun inflateView(@LayoutRes layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View =
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, attachToRoot)