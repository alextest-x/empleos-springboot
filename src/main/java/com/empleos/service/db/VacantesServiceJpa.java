package com.empleos.service.db;

import com.empleos.model.Vacante;
import com.empleos.repository.VacantesRepository;
import com.empleos.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService {

    //para ir a la base de datos inyectamos una instancia de nuestro repositorio
    //VacantesRepository
    @Autowired
    private VacantesRepository vacantesRepo;


    @Override
    public List<Vacante> buscarTodas() {
        return vacantesRepo.findAll();
    }


    @Override
    public Vacante buscarPorId(Integer idVacante) {
      Optional<Vacante> optional =  vacantesRepo.findById(idVacante);
        if(optional.isPresent()){
            return optional.get();
        }
           return null;

    }


    @Override
    public void guardar(Vacante vacante) {
        vacantesRepo.save(vacante);

    }

    //buscar las vacantes que esten aprobadas y valor de desacatacado sea igual 1
    @Override
    public List<Vacante> buscarDestacadas() {
        return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");

    }

    @Override
    public void eliminar(Integer idVacante) {
        vacantesRepo.deleteById(idVacante);
    }


    @Override
    public List<Vacante> buscarByExample(Example<Vacante> example) {
        //recibe como parametro example que lo envia al HomeController
        return vacantesRepo.findAll(example);
    }
	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		return vacantesRepo.findAll(page);
	}
}
