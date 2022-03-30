
package pe.com.serviciosrest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.serviciosrest.entity.Producto;
import pe.com.serviciosrest.rest.rquest.ProductoRequest;
import pe.com.serviciosrest.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService objproducto;
    
    @GetMapping
    public List<Producto> findAll(){
        return objproducto.findAll();
    }
    @PostMapping
    public Producto add(@RequestBody Producto p){
        return objproducto.add(p);
    }
    @GetMapping("by-name")
    public List<Producto> findbyname(@RequestBody ProductoRequest productoRequest){
        
        return objproducto.findByName(productoRequest.getNombre());
    }
    @GetMapping("/{id}")
    public Optional<Producto> finbyid(@PathVariable long id){
        return objproducto.findById(id);
    }
    @PutMapping("/{id}")
    public Producto update(@PathVariable long id,@RequestBody Producto p){
        p.setCodigo(id);
        return objproducto.update(p);
    }
    //eliminar
    @DeleteMapping("/{id}")
    public Producto delete(@PathVariable long id){
        Producto objpro = new Producto();
        objpro.setCodigo(id);
        return objproducto.delete(Producto.builder().codigo(id).build());
    }
}
