package Arbol;

import Recursos.NodoArbolBinario;

//Binary search tree (Arbol binario de busqueda)
public abstract class TBS extends TreeBinary{
    //methods abstracts that class
    public abstract boolean equals(Object nodoA, Object nodoB);
    public abstract boolean isLess(Object nodoA, Object nodoB);
    public abstract boolean isOlder(Object nodoA, Object nodoB);

    public void meter(Object nodoInfo){
        NodoArbolBinario temp, ant;
        NodoArbolBinario nodo = new NodoArbolBinario(nodoInfo);

        if(estaVacio()){
            this.root = nodo;
        }else {
            temp = this.root;
            ant = null;
            while (temp != null){
                ant = temp;
                if (isOlder(temp.getNodoElement(), nodoInfo)){
                    temp = temp.getHijoIzq();
                }else {
                    temp = temp.getHijoDer();
                }
            }
            if (isLess(ant.getNodoElement(), nodoInfo) || equals(ant.getNodoElement(), nodoInfo)){
                ant.setHijoDer(nodo);
            }else {
                ant.setHijoIzq(nodo);
            }
        }
    }

    //metodo privado que nos devuelve el nodo
    private NodoArbolBinario devuelveNodo(Object nodoInfo){
        NodoArbolBinario nodo = null;
        boolean response = false;

        nodo = this.root;

        while (nodo != null && !response){
            if(equals(nodo.getNodoElement(), nodoInfo)){
                response = true;
            }else {
                if (isLess(nodo.getNodoElement(), nodoInfo)){
                    nodo = nodo.getHijoDer();
                }else {
                    nodo = nodo.getHijoIzq();
                }
            }
        }
        return nodo;
    }

    public boolean esta(Object nodoInfo){
        NodoArbolBinario nodo;
        boolean response = false;
        if (!estaVacio()){
            nodo = devuelveNodo(nodoInfo);
            if (nodo != null){
                response = true;
            }
        }else {
            System.out.println("Error... Arbol Vacio!");
        }
        return response;
    }

    public NodoArbolBinario devuelve(Object nodoInfo){
        NodoArbolBinario nodo = null;

        if(!estaVacio()){
            nodo = devuelveNodo(nodoInfo);
            if (nodo == null){
                System.out.println("Error al devolver... Nodo nulo!");
            }
        }else {
            System.out.println("Error al devolver... Arbol Vacio!");
        }
        return nodo;
    }

    public void sacar(Object nodoInfo){
        //Este metodo sirve para eliminar sea una hoja, o eliminar una raiz
        NodoArbolBinario temp, antr, aux;
        boolean response = false;

        if(!estaVacio()){
            if(esta(nodoInfo)){
                antr = null; //anterior en nodos
                temp = this.root;

                while (temp != null && !response){
                    if(equals(temp.getNodoElement(), nodoInfo)){
                        response = true;
                    }else {
                        antr = temp;
                        if(isLess(temp.getNodoElement(), nodoInfo)){
                            temp = temp.getHijoDer();
                        }else {
                            temp = temp.getHijoIzq();
                        }
                    }
                }

                if(temp.getHijoIzq() == null && temp.getHijoDer() == null){
                    //El nodo a eliminar es hoja
                    if(antr == null){
                        limpiar();
                    }else {
                        if(antr.getHijoIzq() == temp){
                            antr.setHijoIzq(null);
                        }else {
                            antr.setHijoDer(null);
                        }
                    }
                }else {
                    if(temp.getHijoIzq() != null && temp.getHijoDer() != null){
                        //el nodo a eliminar tiene dos hijos, o dos hojas
                        antr = temp;
                        aux = temp.getHijoIzq(); 
                        //Para eliminar una raiz, hay que buscar a los mayores
                        while(aux.getHijoDer() != null){
                            antr = aux;
                            aux = aux.getHijoDer();
                        }
                        temp.setNodoElement(aux.getNodoElement());
                        //Ahora el nodo a eliminar, toma el valor mayor de los menores
                        if (antr == temp){
                            antr.setHijoIzq(aux.getHijoIzq());
                        }else {
                            antr.setHijoDer(aux.getHijoIzq());
                        }
                    }else {
                        //el nodo a eliminar tiene un hijo derecho o  izquierdo
                        if(temp.getHijoDer() != null){
                            if (antr == null){
                                this.root = temp.getHijoDer();
                            }else {
                                if(antr.getHijoDer() == temp){
                                    antr.setHijoDer(temp.getHijoDer());
                                }else {
                                    antr.setHijoIzq(temp.getHijoDer());
                                }
                            }
                        }else {
                            //parte del hijo izquierdo
                            if (antr == null){
                                this.root = temp.getHijoIzq();
                            }else {
                                if (antr.getHijoDer() == temp){
                                    antr.setHijoDer(temp.getHijoIzq());
                                }else {
                                    antr.setHijoIzq(temp.getHijoIzq());
                                }
                            }
                        }
                    }
                }
            }else {
                System.out.println("Error al eliminar... No esta el elemento!");
            }
        }else {
            System.out.println("Error al eliminar... Arbol Vacio!");
        }
    }
}
