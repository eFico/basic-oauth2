package com.security.ssresource.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.security.ssresource.domain.Empresa;



@Service
public class EmpresaService {
	private Integer indexConunt = 1;
	//List<Empresa> db = new Arrar
	ArrayList<Empresa> db = new ArrayList<>( Arrays.asList(
			Empresa.builder()
			.idEmpresa(1)
			.ruc("2544545411970")
			.razonSocial("Empresa A")
			.direccion("24 de Mayo")
			.estado(1)
			.fechaRegistro(LocalDateTime.now())
			.build()
			
			) );
	
    public Stream<Empresa> readAll() {
        return db.stream();
    }
    
    public Empresa create(Empresa input) {
    	this.indexConunt++;
    	input.setIdEmpresa(this.indexConunt);
    	input.setFechaRegistro(LocalDateTime.now());
    	
    	db.add(input);
    	
    	return input;
    }
    
    public List<Empresa> readLast3() {
        return db.stream().skip(Math.max(0, db.size() - 3))
                .limit(3)
                .collect(Collectors.toList());
    }

}
