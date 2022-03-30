
package pe.com.serviciosrest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
//utilizamos lombk para los metodos y getter and setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Distrito")
//referencia a la relacion con bd
@Table(name = "t_distrito")
public class Distrito implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "coddis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomdis")
    private String nombre;
    @Column(name = "estdis")
    private boolean estado;
    
    
}
