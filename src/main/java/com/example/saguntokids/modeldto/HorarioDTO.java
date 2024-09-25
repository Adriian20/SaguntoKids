/*package com.example.saguntokids.modeldto;

import com.example.saguntokids.repository.entity.HorarioEntity;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Data
public class HorarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idHorario;
    private String horaInicio;
    private String horaFin;
    private int idDiaSemana;
    @ToString.Exclude
    @JsonManagedReference
    private Long perfilesDTO;


    public static HorarioDTO convertToDTO(HorarioEntity horario) {
        HorarioDTO horarioDTO = new HorarioDTO();
        horarioDTO.setIdHorario(horario.getIdHorario());
        horarioDTO.setHoraInicio(horario.getHoraInicio());
        horarioDTO.setHoraFin(horario.getHoraFin());
        horarioDTO.setIdDiaSemana(horario.getIdDiaSemana());


        return horarioDTO;

    }

    public static HorarioEntity convertToEntity(HorarioDTO horarioDTO) {
        HorarioEntity horario = new HorarioEntity();
        horario.setIdHorario(horarioDTO.getIdHorario());
        horario.setHoraInicio(horarioDTO.getHoraInicio());
        horario.setHoraFin(horarioDTO.getHoraFin());
        horario.setIdDiaSemana(horarioDTO.getIdDiaSemana());


        return horario;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioDTO that = (HorarioDTO) o;
        return Objects.equals(idHorario, that.idHorario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHorario);
    }

    public HorarioDTO (){
        super ();
    }
}
*/





