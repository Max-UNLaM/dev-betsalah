package ar.edu.unlam.tallerweb1.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class SalahProperties extends Properties {
    private Properties properties;
    private InputStream inputStream;

    public static String FASE_DE_GRUPOS;
    public static String FASE_OCTAVOS_DE_FINAL;
    public static String FASE_CUARTOS_DE_FINAL;
    public static String FASE_SEMIFINAL;
    public static String FASE_TERCER_PUESTO;
    public static String FASE_FINAL;

    public static String GRUPO_A;
    public static String GRUPO_B;
    public static String GRUPO_C;
    public static String GRUPO_D;
    public static String GRUPO_E;
    public static String GRUPO_F;
    public static String GRUPO_G;
    public static String GRUPO_H;

    public static String OCTAVOS_1;
    public static String OCTAVOS_2;
    public static String OCTAVOS_3;
    public static String OCTAVOS_4;
    public static String OCTAVOS_5;
    public static String OCTAVOS_6;
    public static String OCTAVOS_7;
    public static String OCTAVOS_8;

    public static String CUARTOS_1;
    public static String CUARTOS_2;
    public static String CUARTOS_3;
    public static String CUARTOS_4;

    public static String SEMIFINAL_1;
    public static String SEMIFINAL_2;

    public static String TERCER_PUESTO;
    public static String FINAL;

    @PostConstruct
    private void setUp(){
        FASE_DE_GRUPOS = this.getProperty("fase.de.grupos.nombre");
        FASE_OCTAVOS_DE_FINAL = this.getProperty("fase.octavos.de.final.nombre");
        FASE_CUARTOS_DE_FINAL = this.getProperty("fase.cuartos.de.final.nombre");
        FASE_SEMIFINAL = this.getProperty("fase.semifinal.nombre");
        FASE_TERCER_PUESTO = this.getProperty("fase.tercer.puesto.nombre");
        FASE_FINAL = this.getProperty("fase.final.nombre");

        GRUPO_A = this.getProperty("grupo.a.nombre");
        GRUPO_B = this.getProperty("grupo.b.nombre");
        GRUPO_C = this.getProperty("grupo.c.nombre");
        GRUPO_D = this.getProperty("grupo.d.nombre");
        GRUPO_E = this.getProperty("grupo.e.nombre");
        GRUPO_F = this.getProperty("grupo.f.nombre");
        GRUPO_G = this.getProperty("grupo.g.nombre");
        GRUPO_H = this.getProperty("grupo.h.nombre");

        OCTAVOS_1 = this.getProperty("octavos.1");
        OCTAVOS_2 = this.getProperty("octavos.2");
        OCTAVOS_3 = this.getProperty("octavos.3");
        OCTAVOS_4 = this.getProperty("octavos.4");
        OCTAVOS_5 = this.getProperty("octavos.5");
        OCTAVOS_6 = this.getProperty("octavos.6");
        OCTAVOS_7 = this.getProperty("octavos.7");
        OCTAVOS_8 = this.getProperty("octavos.8");

        CUARTOS_1 = this.getProperty("cuartos.1");
        CUARTOS_2 = this.getProperty("cuartos.2");
        CUARTOS_3 = this.getProperty("cuartos.3");
        CUARTOS_4 = this.getProperty("cuartos.4");

        SEMIFINAL_1 = this.getProperty("semifinal.1");
        SEMIFINAL_2 = this.getProperty("semifinal.2");

        TERCER_PUESTO = this.getProperty("tercer.puesto");
        FINAL = this.getProperty("final");
    }

    public SalahProperties(){
        this.properties = new Properties();
        inputStream = this.getClass().getResourceAsStream("/salah.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String property){
        return this.properties.getProperty(property);
    }

}
