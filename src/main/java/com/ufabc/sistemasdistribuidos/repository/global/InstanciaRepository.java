package com.ufabc.sistemasdistribuidos.repository.global;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ufabc.sistemasdistribuidos.dto.global.Instancia;

public interface InstanciaRepository extends JpaRepository<Instancia, Long> {
	@Query("select i from Instancia i where i.time < :time or i.time is null")
	List<Instancia> findInactives(@Param("time") Date time);
	
	@Query("select i from Instancia i where i.host = :host")
	List<Instancia> findByHost(@Param("host") String host);
	
	@Query("select i from Instancia i where i.host = :host and port = :port")
	List<Instancia> findByHostAndPort(@Param("host") String host, @Param("port") int port);
}
