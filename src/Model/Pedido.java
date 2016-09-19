package Model;

import javax.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Pedido extends Entidad{

    @Column(name="code")
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
