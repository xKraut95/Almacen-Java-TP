package test;

import modelo.Articulo;
import modelo.ItemCarrito;



public class TestAlmacen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Articulo art1=new Articulo(1,"Fideos","7791234567898",36.50);
		Articulo art2=new Articulo(2,"Harina","7792413123459",75.25);
		Articulo art3=new Articulo(3,"Azucar","7791324467537",40);
		Articulo art4=new Articulo(4,"Yerba","7793142136424",84.75);
		Articulo art5=new Articulo(5,"Arroz","7794332635213",35);
		
		System.out.println(art1);
		System.out.println(art2);
		System.out.println(art3);
		System.out.println(art4);
		System.out.println(art5);
		
		//Instancias de ItemCarrito
		ItemCarrito item=new ItemCarrito(art1,6);
		System.out.println(item);
		
		
		
		
		

	}

}
