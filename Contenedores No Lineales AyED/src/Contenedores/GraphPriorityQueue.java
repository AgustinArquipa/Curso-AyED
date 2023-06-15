package Contenedores;

import Recursos.Conexion;

public class GraphPriorityQueue extends PriopertyQueu{

    @Override
    public boolean equals(Object element1, Object element2) {
        Conexion objA = (Conexion)element1;
        Conexion objB = (Conexion)element2;
        return objA.getCostoConexion() == objB.getCostoConexion();
    }

    @Override
    public boolean isOlder(Object element1, Object element2) {
        Conexion objA = (Conexion)element1;
        Conexion objB = (Conexion)element2;
        return objA.getCostoConexion() > objB.getCostoConexion();
    }

    @Override
    public boolean isLess(Object element1, Object element2) {
        Conexion objA = (Conexion)element1;
        Conexion objB = (Conexion)element2;
        return objA.getCostoConexion() < objB.getCostoConexion();
    }
    
}
