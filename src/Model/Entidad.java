package Model;

import javax.persistence.*;

@MappedSuperclass
public class Entidad {

    @Id
    private int Id;

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }
}
