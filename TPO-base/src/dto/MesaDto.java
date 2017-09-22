package dto;

import java.io.Serializable;
import java.rmi.Remote;

public class MesaDto implements Serializable {
	private String numero;
	private int capacidad;
	private boolean isEmpty;
}