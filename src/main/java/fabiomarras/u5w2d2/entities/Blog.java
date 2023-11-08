package fabiomarras.u5w2d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Blog {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCover() {
        return cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }
}
