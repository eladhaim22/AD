package dominio;

import javax.persistence.*;

@MappedSuperclass
@Entity
@Table(name="area")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Area {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer areaId;

}
