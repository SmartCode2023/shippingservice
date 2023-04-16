package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.DepartamentosEstados;
import com.example.shipping.repository.DepartamentosEstadosRepository;

import java.util.List;
@Service
public class DepartamentosEstadosService {
    @Autowired
    private DepartamentosEstadosRepository departamentosEstadosRepository;


    public List<DepartamentosEstados> getAllDepartamentosEstados() {
        return departamentosEstadosRepository.findAll();
    }

    public DepartamentosEstados getDepartamentosEstadosById(Integer id) {
        return departamentosEstadosRepository.findById(id).orElse(null);
    }

    public void addDepartamentosEstados(DepartamentosEstados departamentosEstados) {
        departamentosEstadosRepository.save(departamentosEstados);
    }

    public void updateDepartamentosEstados(Integer id, DepartamentosEstados departamentosEstados) {
        departamentosEstadosRepository.save(departamentosEstados);

    }

    public void deleteDepartamentosEstados(Integer id) {
        departamentosEstadosRepository.deleteById(id);
    }
}
