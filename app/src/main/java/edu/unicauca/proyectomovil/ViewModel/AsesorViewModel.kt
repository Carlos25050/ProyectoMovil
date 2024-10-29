import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.unicauca.proyectomovil.data.HorariosDisponibles
import edu.unicauca.proyectomovil.data.HorariosDisponiblesDao
import edu.unicauca.proyectomovil.data.Persona
import edu.unicauca.proyectomovil.data.PersonaDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AsesorViewModel(private val personaDao: PersonaDao, private val horariosDisponiblesDao: HorariosDisponiblesDao) : ViewModel() {

    private val _imageUri = MutableStateFlow<String?>(null)
    val imageUri: StateFlow<String?> = _imageUri

    private val _horariosList = MutableStateFlow<List<HorariosDisponibles>>(emptyList())
    val horariosList: StateFlow<List<HorariosDisponibles>> = _horariosList

    init {
        val persona: Flow<Persona> = personaDao.getPersona()
        // Inicializar los valores desde la base de datos cuando se crea el ViewModel
        viewModelScope.launch {
            personaDao.getPersona().collect { persona ->
                _lastSavedName.value = persona.name
                _lastSavedEmail.value = persona.email
                _lastSavedSpecialization.value = persona.specialization
                _lastSavedSubjects.value = persona.subjects
                _lastSavedLevels.value = persona.levels
                _lastSavedRate.value = persona.rate
            }
        }

        viewModelScope.launch {
            _horariosList.value = horariosDisponiblesDao.getAllHorarios()
        }

    }


    private val _lastSavedName = MutableStateFlow("")
    val lastSavedName: StateFlow<String> = _lastSavedName

    private val _lastSavedEmail = MutableStateFlow("")
    val lastSavedEmail: StateFlow<String> = _lastSavedEmail

    private val _lastSavedSpecialization = MutableStateFlow("")
    val lastSavedSpecialization: StateFlow<String> = _lastSavedSpecialization

    private val _lastSavedSubjects = MutableStateFlow("")
    val lastSavedSubjects: StateFlow<String> = _lastSavedSubjects

    private val _lastSavedLevels = MutableStateFlow("")
    val lastSavedLevels: StateFlow<String> = _lastSavedLevels

    private val _lastSavedRate = MutableStateFlow("")
    val lastSavedRate: StateFlow<String> = _lastSavedRate


    fun insertHorario(horario: HorariosDisponibles) {
        viewModelScope.launch(Dispatchers.IO) {
            horariosDisponiblesDao.insert(horario)
            // Actualizar la lista de horarios después de la inserción
            _horariosList.value = horariosDisponiblesDao.getAllHorarios()
        }
    }

    fun deleteAllHorarios() {
        viewModelScope.launch(Dispatchers.IO) {
            horariosDisponiblesDao.deleteAllHorarios()
            // Actualizar la lista de horarios después de eliminar todos
            _horariosList.value = emptyList()
        }
    }


    // Nueva función para eliminar un horario específico por su ID
    fun deleteHorarioById(horarioId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            horariosDisponiblesDao.deleteHorarioById(horarioId)
            _horariosList.value = horariosDisponiblesDao.getAllHorarios()
        }
    }




    fun addOrUpdatePersona(persona: Persona) {
        viewModelScope.launch {
            personaDao.insertPersona(persona) // Usar onConflict = REPLACE para actualizar si ya existe
            _lastSavedName.value = persona.name
            _lastSavedEmail.value = persona.email
            _lastSavedSpecialization.value = persona.specialization
            _lastSavedSubjects.value = persona.subjects
            _lastSavedLevels.value = persona.levels
            _lastSavedRate.value = persona.rate
        }
    }

    fun deleteAllPersonas() {
        viewModelScope.launch {
            personaDao.deleteAllPersonas()
        }
    }
}