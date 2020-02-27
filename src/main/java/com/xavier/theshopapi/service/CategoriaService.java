package com.xavier.theshopapi.service;

import com.xavier.theshopapi.model.Categoria;
import com.xavier.theshopapi.repository.CategoriaRepository;
import com.xavier.theshopapi.service.exception.CategoriaExistException;
import com.xavier.theshopapi.service.exception.CategoriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(final Categoria categoria) {
        verifyIfCategoriaExist(categoria);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public void delete(String id) {
        verifyIfCategoriaNotExist(id);
        categoriaRepository.deleteById(id);
    }

    private void verifyIfCategoriaNotExist(String id) throws CategoriaNotFoundException {
        Optional<Categoria> foundCategoria = categoriaRepository.findById(id);
        if (!foundCategoria.isPresent()) {
            System.out.println("Not found =========>");
            throw new CategoriaNotFoundException();
        }
    }

    private void verifyIfCategoriaExist(Categoria categoria) throws CategoriaExistException {
        Optional<Categoria> foundCategoria = categoriaRepository.findByNomeIgnoreCase(categoria.getNome());
        if (foundCategoria.isPresent() && categoria.isNew()) {
            throw new CategoriaExistException();
        }
    }
}
