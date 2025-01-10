package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Ingrediente")
@Check(constraints = "qtd_ingrediente > 0")
public class Ingrediente {

    @Id
    @Column(name = "id_ingrediente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int idIngrediente;

    @Column(name = "nome", length = 100, unique = true)
    @NotNull
    private String nome;

    @Column(name = "qtd_ingrediente")
    @NotNull
    private int quantidadeIngrediente;

    public Ingrediente() {
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeIngrediente() {
        return quantidadeIngrediente;
    }

    public void setQuantidadeIngrediente(int quantidadeIngrediente) {
        this.quantidadeIngrediente = quantidadeIngrediente;
    }

}
