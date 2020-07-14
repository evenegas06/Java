/*
Navicat MySQL Data Transfer

Source Server         : nuevo
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : esperenme

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-11-29 11:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for compra
-- ----------------------------
DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `id_Usuario` int(11) DEFAULT NULL,
  `id_Servicio` int(11) DEFAULT NULL,
  `codigo` varchar(100) DEFAULT NULL,
  `fechaCompra` date DEFAULT NULL,
  `cantidad` double(4,3) DEFAULT NULL,
  `costoNeto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idUsuario_id_Usuario_idx` (`id_Usuario`),
  KEY `idServicio_id_Servicio_idx` (`id_Servicio`),
  CONSTRAINT `FK_Servicio_id_Servicio` FOREIGN KEY (`id_Servicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_usuario_id_Usuario` FOREIGN KEY (`id_Usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compra
-- ----------------------------
INSERT INTO `compra` VALUES ('1', '1', '1', '15', '2017-11-18', '2.000', '4');
INSERT INTO `compra` VALUES ('2', '11', '8', '5135897', '2017-11-20', '2.000', '8');
INSERT INTO `compra` VALUES ('4', '11', '5', '9236784', '2017-11-20', '1.000', '8');
INSERT INTO `compra` VALUES ('5', '11', '10', '3233188', '2017-11-20', '4.000', '28');
INSERT INTO `compra` VALUES ('6', '11', '10', '6585326', '2017-11-20', '4.000', '28');
INSERT INTO `compra` VALUES ('7', '11', '6', '2263518', '2017-11-20', '3.000', '21');
INSERT INTO `compra` VALUES ('8', '11', '1', '6313536', '2017-11-21', '1.000', '9');
INSERT INTO `compra` VALUES ('9', '11', '6', '4118149', '2017-11-21', '2.000', '14');
INSERT INTO `compra` VALUES ('10', '11', '1', '6669945', '2017-11-22', '1.000', '9');
INSERT INTO `compra` VALUES ('11', '12', '5', '9252783', '2017-11-22', '3.000', '24');
INSERT INTO `compra` VALUES ('12', '13', '5', '2884847', '2017-11-22', '7.000', '56');
INSERT INTO `compra` VALUES ('13', '13', '9', '1842821', '2017-11-22', '7.000', '63');
INSERT INTO `compra` VALUES ('14', '12', '5', '3872783', '2017-11-22', '4.000', '32');
INSERT INTO `compra` VALUES ('15', '21', '6', '7592558', '2017-11-22', '3.000', '21');
INSERT INTO `compra` VALUES ('16', '14', '10', '9443763', '2017-11-29', '4.000', '28');

-- ----------------------------
-- Table structure for servicio
-- ----------------------------
DROP TABLE IF EXISTS `servicio`;
CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `tarifa` double(4,3) DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servicio
-- ----------------------------
INSERT INTO `servicio` VALUES ('1', 'MetroBus_Normal', '9.000');
INSERT INTO `servicio` VALUES ('2', 'MetroBus_Estudiante', '7.000');
INSERT INTO `servicio` VALUES ('3', 'MetroBus_3eraEdad', '5.000');
INSERT INTO `servicio` VALUES ('4', 'MetroBus_Discapacitado', '3.000');
INSERT INTO `servicio` VALUES ('5', 'Metro_Normal', '8.000');
INSERT INTO `servicio` VALUES ('6', 'Metro_Estudiante', '7.000');
INSERT INTO `servicio` VALUES ('7', 'Metro_3eraEdad', '6.000');
INSERT INTO `servicio` VALUES ('8', 'Metro_Discapacitado', '3.000');
INSERT INTO `servicio` VALUES ('9', 'EcoBici_Normal', '9.000');
INSERT INTO `servicio` VALUES ('10', 'EcoBici_Estudiante', '7.000');
INSERT INTO `servicio` VALUES ('11', 'EcoBici_3eraEdad', '5.000');
INSERT INTO `servicio` VALUES ('12', 'EcoBici_Discapacitado', '4.000');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidoM` varchar(100) DEFAULT NULL,
  `apellidoP` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `tarjeta` varchar(100) DEFAULT NULL,
  `cv` varchar(100) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'Daniel', 'Niño', 'Ayala', '595112324', '2543', '3', 'contrasena', 'correo@vorreo.heotmail', 'A');
INSERT INTO `usuario` VALUES ('5', 'Lalo', 'LALA', 'LULU', '595112324', '2345665432456543', '345', 'contrasena', 'correo@vorreo.hotmaili', 'A');
INSERT INTO `usuario` VALUES ('6', 'xD', 'xD', 'Ayala', '595112324', '2543', '3', 'contrasena', 'correo@vorreo.hotmailh', 'A');
INSERT INTO `usuario` VALUES ('8', 'Gabriel', 'Luna', 'Snchez', '5959595', '95959595', '95', '123', 'hombremaquina.evr@gmail.comi', null);
INSERT INTO `usuario` VALUES ('9', 'oko', 'ok', 'ok', 'ok', 'ok', 'ok', '1616', 'hombremaquina.evr@gmail.comj', null);
INSERT INTO `usuario` VALUES ('10', '5454', '5454', '5454', '5454', '5454', '545', '5454', 'evr_gsl06@live.com.mxn', null);
INSERT INTO `usuario` VALUES ('11', 'Eduardo', 'Rivera', 'Venegas', '5951206922', '5555555', '3169', 'hola', 'evr_gsl06@live.com.mxn', null);
INSERT INTO `usuario` VALUES ('12', 'Juan', 'ZSzxZ', 'xYyx', '591162478', '2147852', '123', '123', 'ayalanio@myahoo.com.mx', null);
INSERT INTO `usuario` VALUES ('13', 'Pablito', 'Ortega', 'Ortega', '552121212', '123456789', '725', '1234', 'lll', null);
INSERT INTO `usuario` VALUES ('14', 'Lalo', 'Rivera', 'Venegas', '01589624', '14896214', '123', '123', 'sadfs@sadfghgff.com', '');
INSERT INTO `usuario` VALUES ('15', 'Gabriel ', 'Luna', 'Sanchez ', '1259', '2595', '123', '123', 'asdfgbe@esrdfgt.com', null);
INSERT INTO `usuario` VALUES ('16', 'sadfgh', 'sdfg', 'sadf', 'sadfg', 'sdfg', '123', '123', 'sdfgh', null);
INSERT INTO `usuario` VALUES ('17', 'SADF', 'SDFG', 'SDFG', '523', '55856385', '123', '123', 'SADFGHJKJHGFDS', 'A');
INSERT INTO `usuario` VALUES ('18', 'fghjkl', 'cfgvjhbkn', 'ghjk', 'vhbjkn', 'gvjhb', '123', '123', '1325465', null);
INSERT INTO `usuario` VALUES ('19', 'asadf', 'dfghgfd', 'dfgbngfd', '2134574', '545', '54', '123', 'kjnhgfghj', null);
INSERT INTO `usuario` VALUES ('20', 'ftgyuhij', 'cgvhbj', 'fghjk', 'cvghbj', 'cvhb', 'cvhb', '123', '1245', 'A');
INSERT INTO `usuario` VALUES ('21', 'Trirso ', 'Anaya', 'Bautista', '4598545', '4545', '123', '123', 'sdfghgfrsergh', null);
compracompra