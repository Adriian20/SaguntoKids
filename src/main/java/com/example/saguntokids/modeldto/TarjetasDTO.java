package com.example.saguntokids.modeldto;

import java.io.Serializable;

import com.example.saguntokids.repository.entity.TarjetasEntity;
import com.example.saguntokids.repository.entity.UsuarioEntity;

import lombok.Data;

@Data
public class TarjetasDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idtarjeta;
    private String titular;
    private String numero;
    private String caducidad;
    private int cvc;
    private int idUsuario;

    public static TarjetasDTO convertToDTO(TarjetasEntity tarjetasEntity, UsuarioDTO usuario){
        TarjetasDTO tarjetasDTO = new TarjetasDTO();
        tarjetasDTO.setIdtarjeta(tarjetasEntity.getIdtarjeta());
        tarjetasDTO.setTitular(tarjetasEntity.getTitular());
        tarjetasDTO.setNumero(tarjetasEntity.getNumero());
        tarjetasDTO.setCaducidad(tarjetasEntity.getCaducidad());
        tarjetasDTO.setCvc(tarjetasEntity.getCvc());
        tarjetasDTO.setIdUsuario(tarjetasEntity.getIdUsuario());

        return tarjetasDTO;
    }

    public static TarjetasEntity convertToEntity(TarjetasDTO tarjetasDTO){

        TarjetasEntity tarjetasEntity = new TarjetasEntity();
        tarjetasEntity.setIdtarjeta(tarjetasDTO.getIdtarjeta());
        tarjetasEntity.setTitular(tarjetasDTO.getTitular());
        tarjetasEntity.setNumero(tarjetasDTO.getNumero());
        tarjetasEntity.setCaducidad(tarjetasDTO.getCaducidad());
        tarjetasEntity.setCvc(tarjetasDTO.getCvc());
        tarjetasEntity.setIdUsuario(tarjetasDTO.getIdUsuario());
        return tarjetasEntity;
    }

    public TarjetasDTO(){
        super();
    }
}
