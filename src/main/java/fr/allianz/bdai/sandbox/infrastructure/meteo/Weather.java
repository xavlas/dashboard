package fr.allianz.bdai.sandbox.infrastructure.meteo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
@Data
public class Weather {
    Coord CoordObject;
    ArrayList<Object> weather = new ArrayList<Object>();
    String base;
    Main main;
    private float visibility;
    Wind WindObject;
    Cloud CloudsObject;
    private float dt;
    Sys SysObject;
    private float timezone;
    private float id;
    private String name;
    private float cod;

}

