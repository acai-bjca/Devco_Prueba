CREATE TABLE EMPLEADOS (
    EMPLEADO_ID NUMBER(8,0) NOT NULL,
    NOMBRE VARCHAR(20) NOT NULL,
    APELLIDO VARCHAR(20) NOT NULL
);

ALTER TABLE EMPLEADOS
ADD CONSTRAINT PK_EMPLEADO PRIMARY KEY (EMPLEADO_ID);


CREATE TABLE ASIGNACIONES (
    ASIGNACION_ID NUMBER(8,0) NOT NULL,
    EMPLEADO_ID NUMBER(8,0) NOT NULL,
    DISPOSITIVO_ID VARCHAR(20) NOT NULL,
    FECHA_INICIO DATE NOT NULL,
    FECHA_FIN DATE
);



ALTER TABLE ASIGNACIONES
ADD CONSTRAINT PK_ASIGNACION PRIMARY KEY (ASIGNACION_ID);

ALTER TABLE ASIGNACIONES ADD CONSTRAINT FK_ASIG_EMPLEADO FOREIGN KEY (EMPLEADO_ID)
REFERENCES EMPLEADOS (EMPLEADO_ID);


CREATE SEQUENCE SEQ_ASIGNACIONES
  START WITH 1
  INCREMENT BY 1
  MAXVALUE 99999
  MINVALUE 1;
  
  
INSERT INTO EMPLEADOS 
VALUES (1, 'Carlos', 'Torres');

INSERT INTO ASIGNACIONES (ASIGNACION_ID,EMPLEADO_ID,  DISPOSITIVO_ID, FECHA_INICIO, FECHA_FIN)
VALUES (1, 1, '314709542', '01/01/2022', NULL);

INSERT INTO ASIGNACIONES (ASIGNACION_ID,EMPLEADO_ID,  DISPOSITIVO_ID, FECHA_INICIO, FECHA_FIN)
VALUES (2, 1, '314709542', '01/12/2021', '20/12/2021');

SELECT asig.ASIGNACION_ID, MAX(asig.FECHA_INICIO), asig.FECHA_FIN 
FROM ASIGNACIONES asig, EMPLEADOS emp WHERE asig.DISPOSITIVO_ID = 458488 AND asig.EMPLEADO_ID = 1;


SELECT asig.ASIGNACION_ID, max(asig.FECHA_INICIO), asig.FECHA_FIN
FROM ASIGNACIONES asig, EMPLEADOS emp 
WHERE asig.DISPOSITIVO_ID = 314709542 AND asig.EMPLEADO_ID = 1
GROUP BY asig.DISPOSITIVO_ID


SELECT  max(asig.FECHA_INICIO), asig.FECHA_FIN
FROM ASIGNACIONES asig
WHERE asig.DISPOSITIVO_ID = 458488 AND asig.EMPLEADO_ID = 1 
AND asig.FECHA_INICIO=(SELECT MAX(a.FECHA_INICIO) FROM ASIGNACIONES a WHERE a.DISPOSITIVO_ID = 458488 AND a.EMPLEADO_ID = 1 )



select top (1) with ties *
from ASIGNACIONES asig
WHERE asig.DISPOSITIVO_ID = 458488 AND asig.EMPLEADO_ID = 1 
order by asig.FECHA_INICIO DESC;

SELECT *
FROM ASIGNACIONES asig
order by asig.FECHA_INICIO DESC
