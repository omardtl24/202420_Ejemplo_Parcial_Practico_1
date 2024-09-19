package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
@Entity
public class MedicoEntity extends BaseEntity{
    
    @PodamStringValue(length=10)
    String nombre;
    @PodamStringValue(length=10)
    String apellido;
    @PodamStringValue(length=10)
    String registroMedico;

    @ManyToMany
    List<EspecialidadEntity> especialidades = new ArrayList<>();
}
