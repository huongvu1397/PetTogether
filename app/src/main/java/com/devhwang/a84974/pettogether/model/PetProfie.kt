package com.devhwang.a84974.pettogether.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "pets")
data class PetProfie(
    @PrimaryKey @ColumnInfo(name = "id") val petId: String,
    val name: String,
    val type: String,
    val imageUrl: String = "",
    val age: Long = 0
) {

    override fun toString(): String {
        return name
    }
}