CREATE TABLE Proveedores(
	id int IDENTITY(1,1),
	PRIMARY KEY (id)
)

CREATE TABLE Direcciones(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE Clientes(
	id int IDENTITY(1,1),
	direccion_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (direccion_id) REFERENCES Direcciones(id)
)

CREATE TABLE ClientsRegulares(
	id int NOT NULL,
	cliente_id int NOT NULL,
	FOREIGN KEY (cliente_id) REFERENCES Clientes(id)
)

CREATE TABLE ClientsEventuales(
	cliente_id int NOT NULL,
	FOREIGN KEY (cliente_id) REFERENCES Clientes(id)
)

Create TABLE ReceptoresAutorizados(
	id int IDENTITY(1,1),
	firstName nvarchar(100) NOT NULL,
	lastName nvarchar(100) NOT NULL,
	identification nvarchar(11) UNIQUE,
	PRIMARY KEY (id),
)

CREATE TABLE Paquete(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE Sucursales(
	id int IDENTITY(1,1),
	direccion_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (direccion_id) REFERENCES Direcciones(id)
)


CREATE TABLE Empleados(
	id int IDENTITY(1,1),
	sucursal_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (sucursal_id) REFERENCES Sucursales(id)
)

CREATE TABLE Facturas(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE MapaDeRutas(
	id int IDENTITY(1,1),
	sucursalOrigin_id int,
	sucursalDestino_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (sucursalOrigin_id) REFERENCES Sucursales(id),
	FOREIGN KEY (sucursalDestino_id) REFERENCES Sucursales(id)
)

CREATE TABLE Manifiesto(
	id int IDENTITY(1,1),
	paquete_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (paquete_id) REFERENCES Paquete(id),
)

CREATE TABLE TipoServicios(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE ListaDePrecios(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE CompaniaDeSeguros(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
)

CREATE TABLE PriceLists_TipoServicion(
	id int IDENTITY(1,1),
	listoDePrecios_id int NOT NULL,
	tipoDeServicio_id int NOT NULL,
	companiaDeSeguro_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (listoDePrecios_id) REFERENCES ListaDePrecios(id),
	FOREIGN KEY (tipoDeServicio_id) REFERENCES TipoServicios(id),
	FOREIGN KEY (companiaDeSeguro_id) REFERENCES CompaniaDeSeguros(id),
)

CREATE TABLE Envios(
	id int IDENTITY(1,1),
	client_id int NOT NULL,
	mapaDeRuta_id int NOT NULL,
	manifiesto_id int NOT NULL,
	factura_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (client_id) REFERENCES Clientes(id),
	FOREIGN KEY (mapaDeRuta_id) REFERENCES MapaDeRutas(id),
	FOREIGN KEY (manifiesto_id) REFERENCES Manifiesto(id),
	FOREIGN KEY (factura_id) REFERENCES Facturas(id),
)

CREATE TABLE Envio_ReceptorAutorizado(
	id int IDENTITY(1,1),
	ReceptorAutorizado_id int NOT NULL,
	Envios_id int NOT NULL
	PRIMARY KEY (id),
	FOREIGN KEY (ReceptorAutorizado_id) REFERENCES ReceptoresAutorizados(id),
	FOREIGN KEY (Envios_id) REFERENCES Envios(id)	
)

CREATE TABLE DetallasDeEnvio(
	id int IDENTITY(1,1),
	envio_id int NOT NULL,
	sucursalOrigin_id int NOT NULL,
	sucursalDestino_id int NULL,
	direccionDomicilio_id int NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (sucursalOrigin_id) REFERENCES Sucursales(id),
	FOREIGN KEY (sucursalDestino_id) REFERENCES Sucursales(id),
	FOREIGN KEY (direccionDomicilio_id) REFERENCES Direcciones(id),
	FOREIGN KEY (envio_id) REFERENCES Envios(id),
)

CREATE TABLE Envio_DetallasDeEnvio(
	id int IDENTITY(1,1),
	envio_id int NOT NULL,
	detallesDeEnvio_id int NOT NULL
	PRIMARY KEY (id),
	FOREIGN KEY (envio_id) REFERENCES Envios(id),
	FOREIGN KEY (detallesDeEnvio_id) REFERENCES DetallasDeEnvio(id)
)

CREATE TABLE PlanesDeMantenimiento(
	id int IDENTITY(1,1),
	PRIMARY KEY (id)
)

CREATE TABLE Talleres(
	id int IDENTITY(1,1),
	direccion_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (direccion_id) REFERENCES Direcciones(id)
)

CREATE TABLE Tarea(
	id int IDENTITY(1,1),
	taller_id int NOT NULL,
	planDeMantenimiento_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (planDeMantenimiento_id) REFERENCES PlanesDeMantenimiento(id),
	FOREIGN KEY (taller_id) REFERENCES Talleres(id)
)

CREATE TABLE Vehiculos(
	id int IDENTITY(1,1),
	Sucursal_id int,
	PRIMARY KEY (id),
	FOREIGN KEY (Sucursal_id) REFERENCES Sucursales(id)
)


CREATE TABLE ExternalVehicles(
	id int IDENTITY(1,1),
	proveedor_id int NOT NULL,
	vehiculo_id int NOT NULL,
	FOREIGN KEY (proveedor_id) REFERENCES Proveedores(id),
	FOREIGN KEY (vehiculo_id) REFERENCES Vehiculos(id)
)

CREATE TABLE OwenedVehicles(
	id int IDENTITY(1,1),
	vehiculo_id int NOT NULL,
	planDeMantenimiento_id int,
	FOREIGN KEY (vehiculo_id) REFERENCES Vehiculos(id),
	FOREIGN KEY (planDeMantenimiento_id) REFERENCES PlanesDeMantenimiento(id)
)

CREATE TABLE VehicleTracking(
	id int IDENTITY(1,1),
	vehiculo_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (vehiculo_id) REFERENCES Vehiculos(id)
)

CREATE TABLE Cotizacion(
	id int IDENTITY(1,1),
	PRIMARY KEY (id),
	proveedor_id int NOT NULL,
	FOREIGN KEY (proveedor_id) REFERENCES Proveedores(id)
)

CREATE TABLE TipoServicio_Cotizacion(
	id int IDENTITY(1,1),
	tipoServicio_id int NOT NULL,
	cotizacion_id int NOT NULL
	PRIMARY KEY (id),
	FOREIGN KEY (tipoServicio_id) REFERENCES TipoServicios(id),
	FOREIGN KEY (cotizacion_id) REFERENCES Cotizacion(id)
)

CREATE TABLE REMITO(
	id int IDENTITY(1,1),
	cliente_id int NOT NULL,
	envio_id int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (cliente_id) REFERENCES Clientes(id),
	FOREIGN KEY (envio_id) REFERENCES Envios(id)
)

Create Table Test(
	id int IDENTITY(1,1),
	test nvarchar(100) NOT NULL,
	PRIMARY KEY (id)
)

select * from test;