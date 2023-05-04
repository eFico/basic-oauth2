package com.security.ssresource.api;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.ssresource.domain.Empresa;
import com.security.ssresource.service.EmpresaService;



@RestController
@RequestMapping("/api/v1" + EmpresaApi.EMPRESA)
public class EmpresaApi {
    public static final String EMPRESA = "/empresas";
    public static final String ULTIMOS = "/last";
    
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping
    public Stream<Empresa> readAll() {
        return this.empresaService.readAll();
    }
    
    @GetMapping(value = ULTIMOS)
    public List<Empresa> readAllLast3() {
        return this.empresaService.readLast3();
    }
    
    @PostMapping
    public Empresa create(@RequestBody Empresa newRegistry) {

        return this.empresaService.create(newRegistry);
    }
}
