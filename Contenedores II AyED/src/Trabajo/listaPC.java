package Trabajo;

import Contenedores.Lista1DEnlz;

public class listaPC extends Lista1DEnlz{

	@Override
	public boolean iguals(Object element1, Object element2) {
		PC pc1 = (PC)element1;
		PC pc2 = (PC)element2;
		return pc1.getIDPc() == pc2.getIDPc();
	}
	
}
