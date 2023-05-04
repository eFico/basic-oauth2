package com.security.ssresource.domain;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {
	
	private Integer idEmpresa;
	
    private String ruc;
    private String razonSocial;
    private String direccion;
    private Integer estado;//0:Inactivo 1:Activo

    private LocalDateTime fechaRegistro;
}