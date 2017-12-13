package view;

import java.io.Serializable;

public class SectorWeb implements Serializable {

	private static final long serialVersionUID = 1L;
		private Integer idSector;
		private String descripcion;
		
		public SectorWeb(){}

		public Integer getIdSector() {
			return idSector;
		}

		public void setIdSector(Integer idSector) {
			this.idSector = idSector;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}


}
