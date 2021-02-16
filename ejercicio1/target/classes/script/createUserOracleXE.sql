--Script de creación de esquema en OracleXE
--Cambiar NUEVO_USUARIO por nombre de usuario
--Cambiar superman por la clave
alter session set "_ORACLE_SCRIPT" = true;
        -- USER SQL
        CREATE USER "NUEVO_USUARIO" IDENTIFIED BY "superman"
        DEFAULT TABLESPACE "USERS"
        TEMPORARY TABLESPACE "TEMP";

        -- QUOTAS
        ALTER USER "NUEVO_USUARIO" QUOTA UNLIMITED ON "USERS";

        -- ROLES
        GRANT "CONNECT" TO "NUEVO_USUARIO" ;
        GRANT "RESOURCE" TO "NUEVO_USUARIO" ;