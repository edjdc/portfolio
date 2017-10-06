CREATE SEQUENCE membro_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE membro_id_seq
  OWNER TO postgres;
  
CREATE SEQUENCE projeto_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE projeto_id_seq
  OWNER TO postgres;
  
CREATE TABLE membro
(
  id bigint NOT NULL,
  cargo character varying(100) NOT NULL,
  nome character varying(100) NOT NULL,
  CONSTRAINT membro_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE membro
  OWNER TO postgres;
  

CREATE TABLE projeto
(
  id bigint NOT NULL,
  classificacao character varying(255),
  data_inicio date NOT NULL,
  data_real_termino date,
  descricao character varying(2000) NOT NULL,
  gerente_responsavel character varying(255),
  nome character varying(100) NOT NULL,
  orcamento_total numeric(19,2),
  previsao_termino date,
  status character varying(255),
  CONSTRAINT projeto_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE projeto
  OWNER TO postgres;
  