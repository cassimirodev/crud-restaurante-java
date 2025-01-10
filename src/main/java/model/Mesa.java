package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Mesa")
@Check(constraints = "status IN ('Disponível', 'Reservada', 'Ocupada')")
public class Mesa {

    @Id
    @Column(name = "id_mesa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int idMesa;

    @Column(name = "numero_da_mesa", unique = true)
    @NotNull
    private int numeroMesa;

    @Column(name = "qtd_cadeiras")
    @NotNull
    private int qtdCadeiras;

    @Column(name = "status", length = 20)
    @NotNull
    private String status;

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getQtdCadeiras() {
        return qtdCadeiras;
    }

    public void setQtdCadeiras(int qtdCadeiras) {
        this.qtdCadeiras = qtdCadeiras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
