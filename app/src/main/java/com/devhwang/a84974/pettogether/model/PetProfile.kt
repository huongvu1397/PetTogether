package com.devhwang.a84974.pettogether.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "pets")
 data class PetProfile(
    @PrimaryKey(autoGenerate = true)  @ColumnInfo(name = "id") var petId: Int?,
    var name: String,
    var type: String,
    var imageUrl: String = "",
    var age: Long = 0
) {

    constructor( ) : this(null,"","","",0)


    override fun toString(): String {
        return name
    }
}