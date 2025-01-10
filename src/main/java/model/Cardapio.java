package model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Check;

import java.lang.String;
import java.math.BigDecimal;

@Entity
@Table(name="Cardapio")
@Check (constraints = "preco > 0")
public class Cardapio {


    @Id
    @Column(name = "id_prato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id_prato;

    @Column(name = "nome_prato", length = 100, nullable = false)
    @NotNull
    private String nome_prato;

    @Column(name = "preco", columnDefinition = "NUMERIC", nullable = false)
    @NotNull
    private BigDecimal preco_prato;

    public void setNome_prato (String nome_prato) {
        this.nome_prato = nome_prato;
    }
    public String getNome_prato() {
        return nome_prato;
    }
    public void setPreco_prato (BigDecimal preco_prato) {
        this.preco_prato = preco_prato;
    }
    public BigDecimal getPreco_prato() {
        return preco_prato;
    }
    public int getId_prato() {
        return id_prato;
    }



}
