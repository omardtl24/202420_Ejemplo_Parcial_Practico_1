package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    @Transactional MedicoEntity createMedicos(MedicoEntity medico) throws IllegalOperationException{
        String registro = medico.getRegistroMedico();
        if (registro == null) 
            throw new IllegalOperationException("El registro medico debe iniciar por RM");
        
        if (registro.length()<2) 
            throw new IllegalOperationException("El registro medico debe iniciar por RM");

        if (!registro.startsWith("RM")) 
            throw new IllegalOperationException("El registro medico debe iniciar por RM");

        return medicoRepository.save(medico);
    }
}
