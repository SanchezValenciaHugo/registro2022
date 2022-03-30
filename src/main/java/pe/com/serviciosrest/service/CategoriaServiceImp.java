package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciosrest.entity.Categoria;
import pe.com.serviciosrest.repository.CategoriaRepository;

//indica que esto es un servicio
@Service
public class CategoriaServiceImp  implements CategoriaService{
    @Autowired
    private CategoriaRepository categoryRepository;
    
    @Override
    public List<Categoria> findAll() {
        return categoryRepository.findAllCustom();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Categoria> findByName(String name) {
       return categoryRepository.findByName(name);
    }

    @Override
    public Categoria add(Categoria c) {
        return categoryRepository.save(c);
    }

    @Override
    public Categoria update(Categoria c) {
        Categoria objcategoria = categoryRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c,objcategoria);
        return categoryRepository.save(objcategoria);
    }

    @Override
    public Categoria delete(Categoria c) {
        Categoria objcategoria = categoryRepository.getById(c.getCodigo());
        objcategoria.setEstado(false);
        return categoryRepository.save(objcategoria);
    }
    
    
}
