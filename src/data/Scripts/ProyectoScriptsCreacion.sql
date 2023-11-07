CREATE TABLE tipos_producto (
	id_tipo INTEGER NOT NULL PRIMARY KEY,
	nombre_tipo VARCHAR(50)
);

CREATE TABLE marcas (
	id_marca INTEGER NOT NULL PRIMARY KEY,
	nombre_marca VARCHAR(50)
);

CREATE TABLE productos (
	id_producto INTEGER NOT NULL PRIMARY KEY,
	id_tipo INTEGER NOT NULL,
	id_marca INTEGER NOT NULL,
	nombre_producto VARCHAR(100),
	precio INTEGER NOT NULL,
	cantidad INTEGER NOT NULL,
	FOREIGN KEY (id_tipo) REFERENCES tipos_producto (id_tipo),
	FOREIGN KEY (id_marca) REFERENCES marcas (id_marca)
);

CREATE TABLE facturas (
	id_facturas INTEGER NOT NULL PRIMARY KEY,
	fecha_factura DATE NOT NULL,
	valor_factura FLOAT NOT NULL
);

CREATE TABLE facturas_ventas_producto (
	id_producto INTEGER NOT NULL,
	id_factura INTEGER NOT NULL,
	cantidad_factura_producto INTEGER NOT NULL,
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
	FOREIGN KEY (id_factura) REFERENCES facturas (id_facturas)
);

CREATE TABLE productos_marca (
	id_producto INTEGER NOT NULL,
	id_marca INTEGER NOT NULL,
	PRIMARY KEY(id_producto, id_marca),
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
	FOREIGN KEY (id_marca) REFERENCES marcas (id_marca)
);
