-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `punto_venta` DEFAULT CHARACTER SET latin1 ;
USE `punto_venta` ;

-- -----------------------------------------------------
-- Table `punto_venta`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `id_cliente_UNIQUE` (`id_cliente` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`empleado` (
  `id_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(10) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL,
  `usuario` VARCHAR(45) NULL DEFAULT NULL,
  `contraseña` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE INDEX `id_empleado_UNIQUE` (`id_empleado` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`ingrediente` (
  `id_ingrediente` INT(11) NOT NULL AUTO_INCREMENT,
  `existencias` INT(11) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_ingrediente`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(65) NOT NULL,
  `precio` FLOAT NOT NULL,
  `existencias` INT(11) NULL DEFAULT NULL,
  `preparacion` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`ingrediente_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`ingrediente_producto` (
  `id_ingrediente` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad_requerida` INT(11) NOT NULL,
  PRIMARY KEY (`id_ingrediente`, `id_producto`),
  INDEX `Ingrediente_Producto_Producto_idx` (`id_producto` ASC),
  CONSTRAINT `Ingrediente_Producto_Ingrediente`
    FOREIGN KEY (`id_ingrediente`)
    REFERENCES `punto_venta`.`ingrediente` (`id_ingrediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ingrediente_Producto_Producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `punto_venta`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`venta` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `montoTotal` FLOAT NOT NULL,
  `fecha` DATE NOT NULL,
  `id_empleado` INT(11) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  `subtotal` FLOAT NOT NULL,
  `impuesto` FLOAT NOT NULL,
  PRIMARY KEY (`id_venta`),
  UNIQUE INDEX `id_venta_UNIQUE` (`id_venta` ASC),
  INDEX `venta_cliente_idx` (`id_cliente` ASC),
  INDEX `venta_empleado_idx` (`id_empleado` ASC),
  CONSTRAINT `venta_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `punto_venta`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `venta_empleado`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `punto_venta`.`empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `punto_venta`.`item_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`item_venta` (
  `id_item` INT(11) NOT NULL AUTO_INCREMENT,
  `id_producto` INT(11) NOT NULL,
  `id_venta` INT(11) NOT NULL,
  `total` FLOAT NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`id_item`),
  UNIQUE INDEX `id_factura_UNIQUE` (`id_item` ASC),
  INDEX `Iten_Venta_Venta_idx` (`id_venta` ASC),
  INDEX `Item_Venta_Producto_idx` (`id_producto` ASC),
  CONSTRAINT `Item_Venta_Producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `punto_venta`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Item_Venta_Venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `punto_venta`.`venta` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
