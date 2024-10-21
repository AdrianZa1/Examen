import com.example.examen.data.DIRECCION.AppDatabase
import com.example.examen.data.DIRECCION.Direcion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DirecionRepository(private val db: AppDatabase) {

    // Devuelve directamente el Flow<List<Direcion>> desde el DAO
    fun getAllDirecciones(): Flow<List<Direcion>> {
        return db.direccionDao().getAllDirecion()
            .flowOn(Dispatchers.IO) // Asegurarse de que se ejecute en IO thread
    }

    suspend fun insertDireccion(direccion: Direcion) {
        db.direccionDao().insertDireccion(direccion)
    }

    suspend fun getDireccionById(id: Int): Direcion? {
        return db.direccionDao().getDireccionById(id)
    }

    suspend fun deleteDireccionById(id: Int) {
        db.direccionDao().deleteDireccionById(id)
    }
}
