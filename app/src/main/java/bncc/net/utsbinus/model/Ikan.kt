package bncc.net.utsbinus.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ikan(
        val nama : String,
        val image: String
) : Parcelable
