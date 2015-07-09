SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rutas` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `rutas` ;

-- -----------------------------------------------------
-- Table `rutas`.`concejo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`concejo` (
  `concejoid` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`concejoid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutas`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`usuarios` (
  `usuariosid` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usuariosid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutas`.`rutas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`rutas` (
  `rutasid` INT NOT NULL AUTO_INCREMENT,
  `itinerario` VARCHAR(45) NOT NULL,
  `distancia` INT NOT NULL,
  `duracion` INT NOT NULL,
  `dificultad` VARCHAR(45) NOT NULL,
  `desnivel` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `ubicacion` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `discriminador` VARCHAR(45) NOT NULL,
  `concejo_concejoid` INT NOT NULL,
  `usuarios_usuariosid` INT NOT NULL,
  PRIMARY KEY (`rutasid`),
  INDEX `fk_rutas_concejo1_idx` (`concejo_concejoid` ASC),
  INDEX `fk_rutas_usuarios1_idx` (`usuarios_usuariosid` ASC),
  CONSTRAINT `fk_rutas_concejo1`
    FOREIGN KEY (`concejo_concejoid`)
    REFERENCES `rutas`.`concejo` (`concejoid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutas_usuarios1`
    FOREIGN KEY (`usuarios_usuariosid`)
    REFERENCES `rutas`.`usuarios` (`usuariosid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutas`.`rutasCaminado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`rutasCaminado` (
  `idrutasCaminado` INT NOT NULL AUTO_INCREMENT,
  `tipoCalzado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrutasCaminado`),
  CONSTRAINT `fk_rutasCaminado_rutas`
    FOREIGN KEY (`idrutasCaminado`)
    REFERENCES `rutas`.`rutas` (`rutasid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutas`.`rutasCosteras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`rutasCosteras` (
  `idrutasCosteras` INT NOT NULL AUTO_INCREMENT,
  `tipoCalzado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrutasCosteras`),
  CONSTRAINT `fk_rutasCosteras_rutas1`
    FOREIGN KEY (`idrutasCosteras`)
    REFERENCES `rutas`.`rutas` (`rutasid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutas`.`rutasTrail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas`.`rutasTrail` (
  `idrutasTrail` INT NOT NULL AUTO_INCREMENT,
  `tipoCalzado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrutasTrail`),
  CONSTRAINT `fk_rutasTrail_rutas1`
    FOREIGN KEY (`idrutasTrail`)
    REFERENCES `rutas`.`rutas` (`rutasid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
