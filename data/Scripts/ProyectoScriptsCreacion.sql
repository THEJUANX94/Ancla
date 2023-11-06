CREATE TABLE proveedores (
	id_proveedor INTEGER NOT NULL PRIMARY KEY,
	nombre_proveedor VARCHAR(100) NOT NULL,
	telefono_proveedor VARCHAR(20) NOT NULL,
	correo_proveedor VARCHAR(50)
);

CREATE TABLE tipos_producto (
	id_tipo INTEGER NOT NULL PRIMARY KEY,
	nombre_tipo VARCHAR(50)
);

CREATE TABLE descuentos (
	id_descuentos INTEGER NOT NULL PRIMARY KEY,
	descuento FLOAT NOT NULL CHECK (descuento > 0)
);

CREATE TABLE marcas (
	id_marca INTEGER NOT NULL PRIMARY KEY,
	id_proveedor INTEGER NOT NULL,
	nombre_marca VARCHAR(50),
	FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
);

CREATE TABLE productos (
	id_producto INTEGER NOT NULL PRIMARY KEY,
	id_tipo INTEGER NOT NULL,
	nombre_producto VARCHAR(100),
	FOREIGN KEY (id_tipo) REFERENCES tipos_producto (id_tipo)
);

CREATE TABLE precios (
	id_precio INTEGER NOT NULL PRIMARY KEY,
	id_producto INTEGER,
	fecha_inicio_precio DATE NOT NULL,
	fecha_fin_precio DATE NOT NULL,
	precio FLOAT NOT NULL CHECK (precio > 0),
	impuesto_precio DECIMAL NOT NULL CHECK (impuesto_precio > 0),
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto)
);

CREATE TABLE facturas (
	id_facturas INTEGER NOT NULL PRIMARY KEY,
	id_proveedor INTEGER,
	fecha_factura DATE NOT NULL,
	valor_factura FLOAT NOT NULL,
	tipo_factura CHAR(1)  CHECK (tipo_factura IN ('V', 'C')),
	FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
);

CREATE TABLE descuentos_producto (
	id_producto INTEGER NOT NULL,
	id_descuento INTEGER NOT NULL,
	fecha_inicio_descuento DATE NOT NULL,
	fecha_fin_descuento DATE NOT NULL,
	PRIMARY KEY (id_producto, id_descuento),
	FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
	FOREIGN KEY (id_descuento) REFERENCES descuentos (id_descuentos)
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
