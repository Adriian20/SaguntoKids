package com.example.saguntokids.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController{

    @GetMapping("/SaguntoKids")
    public String mostrarIndex(Model model) {
        return "index"; // Esto se traduce a "src/main/resources/templates/index.html"
    }

    @GetMapping("/indexT")
    public String indexMigue(Model model) {
        return "MigueIndex";
    }

    // CONTRALADORES INFO
    @GetMapping("/paginaPrincipal")
    public String paginaPrincipal() {
        return "index";
    }

    @GetMapping("/infoSag")
    public String infoSag() {
        return "Legal/info_SobreSaguntoKids";
    }

    @GetMapping("/infoPrograma")
    public String infoPrograma() {
        return "Legal/info_InformacionPrograma";
    }

    @GetMapping("/infoPreg")
    public String infoPreguntasFrecuentes() {
        return "Legal/info_PreguntasFrecuentes";
    }

    @GetMapping("/infoPago")
    public String infoPagos() {
        return "Legal/info_Pago";
    }

    @GetMapping("/infoTermCond")
    public String infoTerminosCondiciones() {
        return "Legal/info_Terminosycondiciones";
    }

    @GetMapping("/infoProtec")
    public String infoProteccion() {
        return "Legal/info_ProteccionDatos";
    }

    // Controladores empresa
    @GetMapping("/registroComo")
    public String entrarComo() {
        return "Usuarios/entrar-como";
    }

    @GetMapping("/empresas/recuContrEmpresa")
    public String recuperarContr() {
        return "Empresa/recuContrEmpresa";
    }

    @GetMapping("/empresas/inicioSesionEmpresa")
    public String iniciarSesionEmpresa() {
        return "Empresa/inicioSesionEmpresa";
    }

    @GetMapping("/empresas/registroEmpresa")
    public String registroEmpr() {
        return "Empresa/registroEmpresa";
    }

    @GetMapping("/empresas/zonaPrivEmpresa/{id}")
    public String zonaPrivadaEmpr() {
        return "Empresa/zonaPrivadaEmpresa";
    }

    @GetMapping("/actividades/crearActividad")
    public String crearCurso() {
        return "Empresa/crearActividad";
    }

    @GetMapping("/actividades/editarActividad/{id}")
    public String editarCurso() {
        return "Empresa/crearActividad";
    }

    @GetMapping("/actividades/verActividad/{id}")
    public String verActividad() {
        return "ActividadesMatricula/3info_actividad";
    }

    // CONTROLADORES ACTIVIDADES
    @GetMapping("/actDep")
    public String actDep() {
        return "ActividadesMatricula/1Act_Deportiva";
    }

    @GetMapping("/actFor")
    public String actFor() {
        return "ActividadesMatricula/2Act_Formatia";
    }

    @GetMapping("/infAct")
    public String infAct() {
        return "ActividadesMatricula/3info_actividad";
    }

    @GetMapping("/quiMat")
    public String quiMat() {
        return "ActividadesMatricula/4quien_matricula";
    }

    @GetMapping("/mat")
    public String mat() {
        return "ActividadesMatricula/5matricula";
    }

    @GetMapping("/matPag")
    public String matPag() {
        return "ActividadesMatricula/6matricula_pago";
    }

    @GetMapping("/otrPag")
    public String otrPag() {
        return "ActividadesMatricula/7matricula_otropago";
    }

    @GetMapping("/matAvi")
    public String matAvi() {
        return "ActividadesMatricula/8matricula_aviso";
    }

    // Controlador - Crear perfil
    @GetMapping("/creaPerf")
    public String creaPerf() {
        return "/Usuarios/crear-perfil";
    }

    // Controlador - Registro de usuario
    @GetMapping("/registroUsu")
    public String registroUsu() {
        return "/Usuarios/registro-usuario";
    }

    // Controlador - Zona privada
    @GetMapping("/usuarios/zonaP/{id}")
    public String zonaPriv() {
        return "/Usuarios/zona-privada";
    }

    // Controlador - Entrar como usuario o empresa
    @GetMapping("/entrar")
    public String entrar() {
        return "/Usuarios/entrar-como";
    }

    // Controlador - Terminos y condiciones registro usuario
    @GetMapping("/terminos")
    public String terms() {
        return "/Legal/terminos-condiciones";
    }

    // Controlador - Verificacion en 2 pasos registro empresa
    @GetMapping("/dosPasos")
    public String verf2P() {
        return "/Legal/verificacion-dos-pasos";
    }

}