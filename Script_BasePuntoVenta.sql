
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `punto_venta` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema punto_venta
-- -----------------------------------------------------
USE `punto_venta` ;

-- -----------------------------------------------------
-- Table `punto_venta`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `id_cliente_UNIQUE` (`id_cliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Empleado` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(10) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `contraseña` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE INDEX `id_empleado_UNIQUE` (`id_empleado` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Venta` (
  `id_venta` INT NOT NULL AUTO_INCREMENT,
  `montoTotal` FLOAT NOT NULL,
  `fecha` DATE NOT NULL,
  `id_empleado` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `subtotal` FLOAT NOT NULL,
  `impuesto` FLOAT NOT NULL,
  PRIMARY KEY (`id_venta`),
  UNIQUE INDEX `id_venta_UNIQUE` (`id_venta` ASC),
  INDEX `venta_cliente_idx` (`id_cliente` ASC),
  INDEX `venta_empleado_idx` (`id_empleado` ASC),
  CONSTRAINT `venta_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `punto_venta`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `venta_empleado`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `punto_venta`.`Empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(65) NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Item_Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Item_Venta` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NOT NULL,
  `id_venta` INT NOT NULL,
  `total` FLOAT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`id_item`),
  UNIQUE INDEX `id_factura_UNIQUE` (`id_item` ASC),
  INDEX `Iten_Venta_Venta_idx` (`id_venta` ASC),
  INDEX `Item_Venta_Producto_idx` (`id_producto` ASC),
  CONSTRAINT `Item_Venta_Venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `punto_venta`.`Venta` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Item_Venta_Producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `punto_venta`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Ingrediente` (
  `id_ingrediente` INT NOT NULL AUTO_INCREMENT,
  `existencias` VARCHAR(45) NULL,
  PRIMARY KEY (`id_ingrediente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `punto_venta`.`Ingrediente_Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `punto_venta`.`Ingrediente_Producto` (
  `id_ingrediente` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `cantidad_requerida` INT NOT NULL,
  PRIMARY KEY (`id_ingrediente`, `id_producto`),
  INDEX `Ingrediente_Producto_Producto_idx` (`id_producto` ASC),
  CONSTRAINT `Ingrediente_Producto_Producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `punto_venta`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ingrediente_Producto_Ingrediente`
    FOREIGN KEY (`id_ingrediente`)
    REFERENCES `punto_venta`.`Ingrediente` (`id_ingrediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;