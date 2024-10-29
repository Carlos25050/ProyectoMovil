//package edu.unicauca.proyectomovil.data
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface FotoPerfilDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertOrUpdateFotoPerfil(fotoPerfil: FotoPerfil)
//
//    @Query("SELECT * FROM foto_perfil WHERE userId = 1 LIMIT 1")
//    suspend fun getFotoPerfil(): FotoPerfil?
//
//    @Query("DELETE FROM foto_perfil WHERE userId = 1")
//    suspend fun deleteFotoPerfil()
//}
