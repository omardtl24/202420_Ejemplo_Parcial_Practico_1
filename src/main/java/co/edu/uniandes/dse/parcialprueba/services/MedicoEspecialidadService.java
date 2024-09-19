package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoEspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional EspecialidadEntity addEspecialidad(Long medicoId, Long especialidadId) throws EntityNotFoundException{
        log.info("Inicia proceso de asociarle una especialidad a un medico con id = {0}", medicoId);
		Optional<MedicoEntity> medicoEntity = medicoRepository.findById(medicoId);
		Optional<EspecialidadEntity> especialidadEntity = especialidadRepository.findById(especialidadId);

		if (medicoEntity.isEmpty())
			throw new EntityNotFoundException("El medico con el id dado no se encontro");

		if (especialidadEntity.isEmpty())
			throw new EntityNotFoundException("La especialidad con el id dado no se encontro");

		especialidadEntity.get().getMedicos().add(medicoEntity.get());
		log.info("Termina proceso de asociarle una especialidad a un medico con id = {0}", medicoId);
		return especialidadEntity.get();
    }
}
