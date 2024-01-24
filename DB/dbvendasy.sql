-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09/11/2023 às 05:42
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbvendasy`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_cliente`
--

CREATE TABLE `tbl_cliente` (
  `pk_id_cliente` bigint(20) UNSIGNED NOT NULL,
  `cli_nome` varchar(300) NOT NULL,
  `cli_endereco` varchar(350) NOT NULL,
  `cli_bairro` varchar(300) NOT NULL,
  `cli_cidade` varchar(200) NOT NULL,
  `cli_uf` varchar(2) NOT NULL,
  `cli_cep` varchar(9) NOT NULL,
  `cli_telefone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `tbl_cliente`
--

INSERT INTO `tbl_cliente` (`pk_id_cliente`, `cli_nome`, `cli_endereco`, `cli_bairro`, `cli_cidade`, `cli_uf`, `cli_cep`, `cli_telefone`) VALUES
(1, 'José Lucas', 'Rua teste', 'Eldorado', 'Contagem', 'MG', '32301-522', '(31)97358-1714'),
(2, 'Cristiano Ronaldo da Silva', 'Rua Portugal', 'Eldorado', 'Contagem', 'MG', '32310-535', '(37)97777-7777');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_produto`
--

CREATE TABLE `tbl_produto` (
  `pk_id_produto` bigint(20) UNSIGNED NOT NULL,
  `pro_nome` varchar(300) NOT NULL,
  `pro_valor` double NOT NULL,
  `pro_estoque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `tbl_produto`
--

INSERT INTO `tbl_produto` (`pk_id_produto`, `pro_nome`, `pro_valor`, `pro_estoque`) VALUES
(1, ' Agua S/ gás', 2.5, 96),
(2, ' Agua C/ gás', 3.5, 95),
(3, ' Heineken', 18, 500);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `pk_id_usuario` bigint(20) UNSIGNED NOT NULL,
  `usu_nome` varchar(300) NOT NULL,
  `usu_login` varchar(350) NOT NULL,
  `usu_senha` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Despejando dados para a tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`pk_id_usuario`, `usu_nome`, `usu_login`, `usu_senha`) VALUES
(1, 'José Lucas de Gouveia Júnior', 'jose.gouveia.est@samarco.com', '181094');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_vendas`
--

CREATE TABLE `tbl_vendas` (
  `pk_id_vendas` bigint(20) UNSIGNED NOT NULL,
  `fk_cliente` bigint(20) UNSIGNED NOT NULL,
  `ven_data_venda` date NOT NULL,
  `ven_valor_liquido` double NOT NULL,
  `ven_valor_bruto` double NOT NULL,
  `ven_desconto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbl_vendas_produtos`
--

CREATE TABLE `tbl_vendas_produtos` (
  `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_produto` bigint(20) UNSIGNED NOT NULL,
  `fk_vendas` bigint(20) UNSIGNED NOT NULL,
  `ven_pro_valor` double NOT NULL,
  `ven_pro_quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`pk_id_cliente`),
  ADD UNIQUE KEY `id_cliente` (`pk_id_cliente`);

--
-- Índices de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  ADD PRIMARY KEY (`pk_id_produto`),
  ADD UNIQUE KEY `pk_id_produto` (`pk_id_produto`);

--
-- Índices de tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`pk_id_usuario`),
  ADD UNIQUE KEY `pk_id_usuario` (`pk_id_usuario`);

--
-- Índices de tabela `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  ADD PRIMARY KEY (`pk_id_vendas`),
  ADD KEY `fkcliente` (`fk_cliente`);

--
-- Índices de tabela `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  ADD PRIMARY KEY (`pk_id_venda_produto`),
  ADD KEY `fkprodutos` (`fk_produto`),
  ADD KEY `fkvendas` (`fk_vendas`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  MODIFY `pk_id_cliente` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbl_produto`
--
ALTER TABLE `tbl_produto`
  MODIFY `pk_id_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `pk_id_usuario` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  MODIFY `pk_id_vendas` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  MODIFY `pk_id_venda_produto` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tbl_vendas`
--
ALTER TABLE `tbl_vendas`
  ADD CONSTRAINT `1` FOREIGN KEY (`fk_cliente`) REFERENCES `tbl_cliente` (`pk_id_cliente`);

--
-- Restrições para tabelas `tbl_vendas_produtos`
--
ALTER TABLE `tbl_vendas_produtos`
  ADD CONSTRAINT `2` FOREIGN KEY (`fk_produto`) REFERENCES `tbl_produto` (`pk_id_produto`),
  ADD CONSTRAINT `3` FOREIGN KEY (`fk_vendas`) REFERENCES `tbl_vendas` (`pk_id_vendas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
