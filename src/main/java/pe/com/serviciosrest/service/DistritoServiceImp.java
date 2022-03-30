
package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciosrest.entity.Distrito;
import pe.com.serviciosrest.repository.DistritoRepository;

@Service
public class DistritoServiceImp implements DistritoService{
    @Autowired
    public DistritoRepository distritoRepository;
    
    @Override
    public List<Distrito> findAll() {
        return distritoRepository.findAllCustom();
    }

    @Override
    public Optional<Distrito> findById(Long id) {
        return distritoRepository.findById(id);
    }

    @Override
    public List<Distrito> findByName(String name) {
        return null;
    }

    @Override
    public Distrito add(Distrito d) {
        return distritoRepository.save(d);
        
    }

    @Override
    public Distrito update(Distrito d) {
        Distrito objdistrito = distritoRepository.getById(d.getCodigo());
        BeanUtils.copyProperties(d,objdistrito);
        return distritoRepository.save(objdistrito);
    }

    @Override
    public Distrito delete(Distrito d) {
        Distrito objdistrito = distritoRepository.getById(d.getCodigo());
        objdistrito.setEstado(false);
        return distritoRepository.save(objdistrito);
    }
    
}
