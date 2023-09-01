/* TABELA ESG */
CREATE TABLE Esg (
    cod_esg NUMBER CONSTRAINT esg_cod_esg_pk PRIMARY KEY,
    nome VARCHAR(100) CONSTRAINT esg_nome_nn NOT NULL
);

/* TABELA CONSUMIDOR */
CREATE TABLE Consumidor (
    cod_usuario NUMBER CONSTRAINT con_cod_usuario_pk PRIMARY KEY,
    nome_usuario VARCHAR(100) CONSTRAINT con_nome_usuario_nn NOT NULL,
    origem_contato VARCHAR(100) CONSTRAINT con_origem_contato_nn NOT NULL
);

/* TABELA FEEDBACK */
CREATE TABLE Feedback (
    cod_feedback NUMBER CONSTRAINT feed_cod_feed_pk PRIMARY KEY,
    mensagem VARCHAR(450) CONSTRAINT feed_mensagem_nn NOT NULL,
    data_entrada DATE CONSTRAINT feed_data_entrada_nn NOT NULL,
    data_conclusao DATE,
    cod_usuario NUMBER CONSTRAINT feed_cod_usuario_nn NOT NULL,
    cod_tipo NUMBER CONSTRAINT feed_cod_tipo_nn NOT NULL,
    cod_esg NUMBER CONSTRAINT feed_cod_esg_nn NOT NULL
);

/* TABELA TIPO FEEDBACK */
CREATE TABLE TipoFeedback (
    cod_tipo NUMBER CONSTRAINT tipo_cod_tipo_pk PRIMARY KEY,
    nome VARCHAR(100) CONSTRAINT tipo_nome_nn NOT NULL
);

/* TABELA ACAO */
CREATE TABLE Acao (
    cod_acao NUMBER CONSTRAINT acao_cod_acao_pk PRIMARY KEY,
    descricao VARCHAR(450) CONSTRAINT acao_descricao_nn NOT NULL,
    plano VARCHAR(450) CONSTRAINT acao_plano_nn NOT NULL,
    prioridade VARCHAR(50) CONSTRAINT acao_prioridade_nn NOT NULL,
    data_entrada DATE CONSTRAINT acao_data_entrada_nn NOT NULL,
    data_prevista DATE,
    data_conclusao DATE,
    cod_esg NUMBER CONSTRAINT acao_cod_esg_nn NOT NULL,
    cod_feedback NUMBER,
    cod_funcionario NUMBER CONSTRAINT acao_cod_funcionario_nn NOT NULL
);

/* TABELA RISCO */
CREATE TABLE Risco (
    cod_risco NUMBER CONSTRAINT risco_cod_risco_pk PRIMARY KEY,
    descricao VARCHAR(450) CONSTRAINT risco_descricao_nn NOT NULL,
    impacto VARCHAR(450) CONSTRAINT risco_impacto_nn NOT NULL,
    urgencia VARCHAR(50) CONSTRAINT risco_urgencia_nn NOT NULL  
);

/* TABELA FUNCIONARIO */
CREATE TABLE Funcionario (
    cod_funcionario NUMBER CONSTRAINT func_cod_func_pk PRIMARY KEY,
    cpf NUMBER CONSTRAINT func_cpf_uk UNIQUE CONSTRAINT func_cpf_nn NOT NULL,
    nome VARCHAR(100) CONSTRAINT func_nome_nn NOT NULL,
    sobrenome VARCHAR(100) CONSTRAINT func_sobrenome_nn NOT NULL,
    telefone VARCHAR(11) CONSTRAINT func_telefone_nn NOT NULL,
    email VARCHAR(100) CONSTRAINT func_email_nn NOT NULL,
    cor VARCHAR(100) CONSTRAINT func_cor_nn NOT NULL,
    estado_civil VARCHAR(100) CONSTRAINT func_est_civil_nn NOT NULL,
    genero VARCHAR(100),
    sexualidade VARCHAR(100)
);

/* TABELA META */
CREATE TABLE Meta (
    cod_meta NUMBER CONSTRAINT meta_cod_meta_pk PRIMARY KEY,
    descricao VARCHAR(450) CONSTRAINT meta_descricao_nn NOT NULL,
    data_entrada DATE CONSTRAINT meta_data_entrada_nn NOT NULL,
    data_prevista DATE,
    data_conclusao DATE,
    cod_esg NUMBER CONSTRAINT meta_cod_esg_nn NOT NULL,
    cod_funcionario NUMBER CONSTRAINT meta_cod_funcionario_nn NOT NULL
);

/* TABELA CONSUMO */
CREATE TABLE Consumo (
    cod_consumo NUMBER CONSTRAINT consumo_cod_cons_pk PRIMARY KEY,
    quantidade NUMBER CONSTRAINT consumo_qtd CHECK(quantidade > 0) CONSTRAINT consumo_qtd_nn NOT NULL,
    valor NUMBER CONSTRAINT consumo_valor CHECK(valor > 0) CONSTRAINT consumo_valor_nn NOT NULL,
    mes CHAR(2) CONSTRAINT consumo_mes_nn NOT NULL,
    ano CHAR(4) CONSTRAINT consumo_ano_nn NOT NULL,
    cod_esg NUMBER CONSTRAINT consumo_cod_esg_nn NOT NULL,
    cod_unidade NUMBER CONSTRAINT consumo_cod_unidade_nn NOT NULL
);

/* TABELA UNIDADE CONSUMO */
CREATE TABLE UnidadeConsumo (
    cod_unidade NUMBER CONSTRAINT uni_cod_uni_pk PRIMARY KEY,
    unidade VARCHAR(50) CONSTRAINT uni_unidade_nn NOT NULL  
);

/* CHAVES ESTRANGEIRAS FEEDBACK*/
ALTER TABLE FEEDBACK 
ADD CONSTRAINT feed_cod_usuario_fk 
FOREIGN KEY (cod_usuario) REFERENCES CONSUMIDOR;

ALTER TABLE FEEDBACK 
ADD CONSTRAINT feed_cod_tipo_fk 
FOREIGN KEY (cod_tipo) REFERENCES TIPOFEEDBACK;

ALTER TABLE FEEDBACK 
ADD CONSTRAINT feed_cod_esg_fk 
FOREIGN KEY (cod_esg) REFERENCES ESG;

/* CHAVES ESTRANGEIRAS ACAO */
ALTER TABLE ACAO 
ADD CONSTRAINT acao_cod_esg_fk 
FOREIGN KEY (cod_esg) REFERENCES ESG;

ALTER TABLE ACAO 
ADD CONSTRAINT acao_cod_feedback_fk 
FOREIGN KEY (cod_feedback) REFERENCES FEEDBACK;

ALTER TABLE ACAO 
ADD CONSTRAINT acao_cod_funcionario_fk 
FOREIGN KEY (cod_funcionario) REFERENCES FUNCIONARIO;

/* CHAVES ESTRANGEIRAS META*/
ALTER TABLE META 
ADD CONSTRAINT meta_cod_esg_fk 
FOREIGN KEY (cod_esg) REFERENCES ESG;

ALTER TABLE META 
ADD CONSTRAINT meta_cod_funcionario_fk 
FOREIGN KEY (cod_funcionario) REFERENCES FUNCIONARIO;

/* CHAVES ESTRANGEIRAS CONSUMO*/
ALTER TABLE CONSUMO 
ADD CONSTRAINT consumo_cod_esg_fk 
FOREIGN KEY (cod_esg) REFERENCES ESG;

ALTER TABLE CONSUMO 
ADD CONSTRAINT consumo_cod_unidade_fk 
FOREIGN KEY (cod_unidade) REFERENCES UNIDADECONSUMO;

/* TABELA RISCO ACAO */
CREATE TABLE RiscoAcao(
    cod_risco NUMBER CONSTRAINT risAcao_cod_risco_nn NOT NULL,
    cod_acao NUMBER CONSTRAINT risAcao_cod_acao_nn NOT NULL,
    cod_esg NUMBER CONSTRAINT risAcao_cod_esg_nn NOT NULL
);

/* CHAVES ESTRANGEIRAS RISCO ACAO*/
ALTER TABLE RISCOACAO
ADD CONSTRAINT risAcao_cod_risco_fk
FOREIGN KEY (cod_risco) REFERENCES RISCO;

ALTER TABLE RISCOACAO
ADD CONSTRAINT risAcao_cod_acao_fk
FOREIGN KEY (cod_acao) REFERENCES ACAO;

ALTER TABLE RISCOACAO
ADD CONSTRAINT risAcao_cod_esg_fk
FOREIGN KEY (cod_esg) REFERENCES ACAO;

















