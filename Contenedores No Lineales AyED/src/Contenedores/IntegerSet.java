package Contenedores;

public class IntegerSet extends HashSets{

    @Override
    public boolean equals(Object element1, Object element2) {
        int valueA, valueB;
        valueA = (int)element1;
        valueB = (int)element2;
        return valueA == valueB;
    }
    
}
