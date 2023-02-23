package com.example.parking.api.model

import com.google.gson.annotations.SerializedName

data class TCMSV_001_Rs(
    @field:SerializedName("data") val data: TCMSV_002_Rs?,
) : BaseModel()

data class TCMSV_002_Rs(
    @field:SerializedName("UPDATETIME") val time: String?,
    @field:SerializedName("park") val park: List<TCMSV_003_Rs>?
) : BaseModel()

data class TCMSV_003_Rs(
    @field:SerializedName("id") val id: String? =  "001",
    @field:SerializedName("area") val area: String?,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("type") val type: String?,
    @field:SerializedName("type2") val type2: String?,
    @field:SerializedName("summary") val summary: String?,
    @field:SerializedName("address") val address: String?,
    @field:SerializedName("tel") val tel: String?,
    @field:SerializedName("payex") val payex: String?,
    @field:SerializedName("tw97x") val tw97x: String?,
    @field:SerializedName("tw97y") val tw97y: String?,
    @field:SerializedName("totalcar") val totalcar: String?,
    @field:SerializedName("totalmotor") val totalmotor: String?,
    @field:SerializedName("totalbike") val totalbike: String?,
    @field:SerializedName("totalbus") val totalbus: String?,
) : BaseModel()