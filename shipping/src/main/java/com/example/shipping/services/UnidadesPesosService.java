package com.example.shipping.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shipping.model.UnidadesPesos;
import com.example.shipping.repository.UnidadesPesosRepository;

import java.util.List;
@Service
public class UnidadesPesosService {
    @Autowired
    private UnidadesPesosRepository unidadesPesosRepository;


    public List<UnidadesPesos> getAllUnidadesPesos() {
        return unidadesPesosRepository.findAll();
    }

    public UnidadesPesos getUnidadesPesosById(Integer id) {
        return unidadesPesosRepository.findById(id).orElse(null);
    }

    public void addUnidadesPesos(UnidadesPesos unidadesPesos) {
        unidadesPesosRepository.save(unidadesPesos);
    }

    public void updateUnidadesPesos(Integer id, UnidadesPesos unidadesPesos) {
        unidadesPesosRepository.save(unidadesPesos);

    }

    public void deleteUnidadesPesos(Integer id) {
        unidadesPesosRepository.deleteById(id);
    }
}
