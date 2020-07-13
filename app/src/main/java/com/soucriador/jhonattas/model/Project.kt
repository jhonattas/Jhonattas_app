package com.soucriador.jhonattas.model

import java.util.*

data class Project(
    var id: Int,
    var mThumbnail: Int,
    var category: ArrayList<String>?,
    var description: String?,
    var link: String?,
    var resume: String?,
    var thumbnailUrl: String?,
    var title: String?
)