-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2022 a las 19:21:56
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `id17923601_tecnoshop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id_compra` varchar(20) NOT NULL,
  `producto` varchar(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` varchar(20) NOT NULL,
  `categoría` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `categoría`) VALUES
('CT001', 'Computo'),
('CT002', 'Redes'),
('CT003', 'Electronica'),
('CT004', 'Gamer'),
('CT005', 'Hardware'),
('CT006', 'Movil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `id_comentario` varchar(20) NOT NULL,
  `producto` varchar(20) NOT NULL,
  `comentario` varchar(500) NOT NULL,
  `id_usuario` varchar(200) NOT NULL,
  `puntuacion` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`id_comentario`, `producto`, `comentario`, `id_usuario`, `puntuacion`) VALUES
('CM001', 'PD010', 'Muy buen producto', 'US001', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fabricante`
--

CREATE TABLE `fabricante` (
  `id_fabricante` varchar(20) NOT NULL,
  `nombre_fabricante` varchar(200) NOT NULL,
  `informacion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `fabricante`
--

INSERT INTO `fabricante` (`id_fabricante`, `nombre_fabricante`, `informacion`) VALUES
('FB001', 'ADATA', 'El futuro es nuestro para definirlo. Creemos que nuestra actitud y visión pueden determinar lo avanzado que será el futuro. Para nosotros, el futuro no es una evolución, sino una transformación.'),
('FB002', 'Kingston Technology’s', 'Nuestro lema «Kingston está con usted» representa nuestra cultura corporativa y la filosofía de nuestra marca. Nuestro hardware alimenta la tecnología que el mundo utiliza hoy'),
('FB003', 'ASUS', 'ASUS es uno de los tres fabricantes de PC portátiles de consumo líder a nivel global y creador de las motherboards más vendidas y premiadas mundialmente.'),
('FB004', 'SEAGATE', 'Seagate Technology es un importante fabricante estadounidense de discos duros, fundado en 1979 y con sede en Scotts Valley, California. La compañía está registrada en las Islas Caimán.'),
('FB005', 'AMD', 'Advanced Micro Devices, Inc. es una compañía estadounidense de semiconductores con sede en Santa Clara, California, que desarrolla procesadores de computación.'),
('FB006', 'ACER', 'Acer, Inc., conocida simplemente como Acer —pronunciado en inglés «/ˈeɪsər/»—, es una empresa taiwanesa fabricante de computadoras y productos informáticos.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` varchar(20) NOT NULL,
  `nombre_producto` varchar(200) NOT NULL,
  `precio` float NOT NULL,
  `fabricante` varchar(20) NOT NULL,
  `categoria` varchar(20) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_producto` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `precio`, `fabricante`, `categoria`, `stock`, `img_producto`) VALUES
('PD001', 'DISCO DURO EXTERNO ADATA 1TB HV300 BLACK', 65, 'FB001', 'CT001', 100, 'https://www.zonadigitalsv.com/product/4713218464972/image'),
('PD002', 'MEMORIA RAM DDR5 ADATA 8GB 4800MHz AD5U48008G-S', 89, 'FB001', 'CT005', 100, 'https://www.zonadigitalsv.com/product/4711085936417/image'),
('PD003', 'MEMORIA RAM DDR5 ADATA 16GB 4800MHz AD5U480016G-S', 165, 'FB001', 'CT005', 50, 'https://www.zonadigitalsv.com/product/4711085936448/image'),
('PD004', 'DISCO DE ESTADO SOLIDO SSD ADATA SU650 256GB ASU650SS-256GT-R', 45, 'FB001', 'CT005', 60, 'https://www.zonadigitalsv.com/product/4711085931511/image'),
('PD005', 'MEMORIA RAM DDR4 KINGSTON FURY BEAST 8GB 3200MHz KF432C16BBA/8 PC RGB', 69.95, 'FB002', 'CT005', 70, 'https://www.zonadigitalsv.com/product/images/1076'),
('PD006', 'DISCO SOLIDO SSD KINGSTON 240GB A400 SA400S37/240G', 39.95, 'FB002', 'CT001', 50, 'https://www.zonadigitalsv.com/product/740617261219/image'),
('PD007', 'CARGADOR PARA CARRO REMAX 2.4A RCC220 SILVER', 4.95, 'FB002', 'CT003', 50, 'https://www.zonadigitalsv.com/product/6954851298236/image'),
('PD008', 'LAPTOP ASUS TUF FX516PM PROC. INTEL CORE i7 11370H RAM 16GB ALMACENAMIENTO SSD 1TB RTX3060 6GB WIFI+BT W11 PANTALLA FHD 15.6P GRAY	', 2099, 'FB003', 'CT001', 50, 'https://www.zonadigitalsv.com/product/195553562430/image'),
('PD009', 'MOTHERBOARD ASUS PRIME Z590-P LGA1200 11TH GEN 90MB16I0', 275, 'FB003', 'CT001', 25, 'https://www.zonadigitalsv.com/product/195553101547/image'),
('PD010', 'TARJETA DE VIDEO ASUS DUAL RTX2060 6GB GDDR6 90YV0CH2', 649, 'FB003', 'CT001', 15, 'https://www.zonadigitalsv.com/product/192876273838/image'),
('PD011', 'ENFRIAMIENTO LIQUIDO ASUS TUF LC 240MM RGB PARA INTEL Y AMD 90RC0091', 179, 'FB003', 'CT001', 25, 'https://www.zonadigitalsv.com/product/192876745205/image'),
('PD012', 'TARJETA DE VIDEO ASUS ROG STRIX RX6600XT 8GB GDDR6 90YV0GN0', 929, 'FB003', 'CT001', 15, 'https://www.zonadigitalsv.com/product/195553332781/image'),
('PD013', 'DISCO DURO DE LAPTOP SEAGATE 500GB ST500LM030 2.5', 59.95, 'FB004', 'CT005', 20, 'https://www.zonadigitalsv.com/product/ST500LM030/image'),
('PD014', 'DISCO DURO SEAGATE DE LAPTOP 1TB ST1000LM048', 59, 'FB004', 'CT005', 25, 'https://www.zonadigitalsv.com/product/ST1000LM048/image'),
('PD015', 'DISCO DURO EXTERNO SEAGATE 2TB USB3.0 STGD2000107 MAVEL AVENGERS CAPTAIN AMERICA', 109, 'FB004', 'CT005', 30, 'https://www.zonadigitalsv.com/product/763649148280/image'),
('PD016', 'DISCO DURO EXTERNO SEAGATE 4TB STKM4000400 USB 3.0', 139.95, 'FB004', 'CT005', 35, 'https://www.zonadigitalsv.com/product/763649160480/image'),
('PD017', 'PROCESADOR AMD RYZEN 5 3600 3.6GHz 6C/12T 35MB REQUIERE GPU', 299, 'FB005', 'CT001', 35, 'https://www.zonadigitalsv.com/product/730143309936/image'),
('PD018', 'PROCESADOR AMD RYZEN 7 5800X 3.8GHz-4.7GHz 8C/16T 36MB REQUIERE GPU', 559, 'FB005', 'CT001', 55, 'https://www.zonadigitalsv.com/product/730143312714/image'),
('PD019', 'PROCESADOR AMD RYZEN 9 5900X 3.7GHz-4.8GHz 12C/24T 70MB REQUIERE GPU', 799, 'FB005', 'CT001', 10, 'https://www.zonadigitalsv.com/product/730143312738/image'),
('PD020', 'LAPTOP ACER PREDATOR HELIOS 300 PROC. INTEL CORE i7 11800H RAM 16GB', 1999, 'FB006', 'CT001', 10, 'https://www.zonadigitalsv.com/product/195133116251/image'),
('PD021', 'LAPTOP ACER ASPIRE 5 A514-54-501Z PROC. INTEL CORE i5 1135G7', 799, 'FB006', 'CT001', 10, 'https://www.zonadigitalsv.com/product/195133106771/image'),
('PD022', 'LAPTOP ACER ASPIRE 5 A515-56-36UT INTEL CORE i3 1115G4', 599, 'FB006', 'CT001', 10, 'https://www.zonadigitalsv.com/product/195133111720/image');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD KEY `producto_carrito` (`producto`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `producto_comentarios` (`producto`);

--
-- Indices de la tabla `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`id_fabricante`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `categoria_producto` (`categoria`),
  ADD KEY `fabricante_producto` (`fabricante`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `producto_carrito` FOREIGN KEY (`producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `producto_comentarios` FOREIGN KEY (`producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `categoria_producto` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id_categoria`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fabricante_producto` FOREIGN KEY (`fabricante`) REFERENCES `fabricante` (`id_fabricante`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
