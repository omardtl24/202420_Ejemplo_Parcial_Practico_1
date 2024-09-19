package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
@Entity
public class EspecialidadEntity extends BaseEntity{
    
    @PodamStringValue(length=10)
    String nombre;
    @PodamStringValue(length=20)
    String descripcion;

    @ManyToMany
    List<MedicoEntity> medicos = new ArrayList<>();
}
