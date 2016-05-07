package com.GameChes.logic.coordinates;
import java.util.ArrayList;
import java.util.List;

/**
 * Переводит координаты из различных форматов в объект Point для удобства.
 */
public class CoordinatePars {
    /**
     * Из форматы String в Point.
     * @param coord строка вида "x"+separator+"y".
     * @param separator разделитель x и y.
     * @return спасенный Point. null если спарить не получилось.
     */
    public static Coordinate parsPoint(String coord,String separator){
        String[] split = coord.split(separator);
        if(split.length!=2) return null;
        return new Coordinate(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }

    /**
     * Из форматы String в Point разделителем по умолчанию является ",".
     * @param coord строка вида "x,y".
     * @return спасенный Point. null если спарить не получилось.
     */
    public static Coordinate parsPoint(String coord){
        return parsPoint(coord,",");
    }

    /**
     * Из форматы String в Point.
     * @param coordList строка вида "x,y".
     * @return спасенный Point. null если спарить не получилось.
     */
    public static List<Coordinate> parsListPoint(List<String> coordList, String separator){
        List<Coordinate> points = new ArrayList<>();
        for (String s : coordList) {
            points.add(CoordinatePars.parsPoint(s,separator));
        }
        return points;
    }

    /**
     * Из форматы String в Point разделителем по умолчанию является ",".
     * @param coordList строка вида "x,y".
     * @return спасенный Point. null если спарить не получилось.
     */
    public static List<Coordinate> parsListPoint(List<String> coordList){
        return parsListPoint(coordList,",");
    }
}
