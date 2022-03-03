
CREATE TABLE `usuario` (
  `pkusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkusuario`),
  UNIQUE KEY `UKpm3f4m4fqv89oeeeac4tbe2f4` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `permissao` (
  `pkpermissao` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkpermissao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `usuario_permissao` (
  `id` int(11) NOT NULL,
  `codigo_permissao` int(11) NOT NULL,
  KEY `FK5tjrvuwlx1yp72mrf8t8vj93e` (`codigo_permissao`),
  KEY `FKeedull6y4tfwfgw5m8e8mtmcu` (`id`),
  CONSTRAINT `FK5tjrvuwlx1yp72mrf8t8vj93e` FOREIGN KEY (`codigo_permissao`) REFERENCES `permissao` (`pkpermissao`),
  CONSTRAINT `FKeedull6y4tfwfgw5m8e8mtmcu` FOREIGN KEY (`id`) REFERENCES `usuario` (`pkusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;