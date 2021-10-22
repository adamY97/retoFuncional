package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoFuncionalApplication {
	
	private static List<String> aves = Arrays.asList("aguila", "gorrion", "paloma", "gaviota");
	private static List<Integer> numbers = Arrays.asList(6,7,2,9,2,1);
	private static List<Integer> nOrdenados = new ArrayList<Integer>();

	public static void main(String[] args) {
		SpringApplication.run(RetoFuncionalApplication.class, args);
		
		contieneAve("goRRion");
		sumatorioNumeros();
		sumatorioNumeros2();
		ordenarArray();
	}

	//Devuelve true si el ave introducida se encuentra dentro del array aves, coge mayusculas y minusculas 
	public static void contieneAve(String ave) {	
		System.out.println("Hay " + ave.toLowerCase() + " en el array aves? " + aves.contains(ave.toLowerCase()));
	}
	
	//Suma todos los valores numericos del array
	public static void sumatorioNumeros() {
		System.out.println(numbers.stream().mapToDouble(Integer::doubleValue).sum());
	}
	
	//Sumar todos los valores numeros del array (con reduce)
	public static void sumatorioNumeros2() {
		numbers.stream().reduce(Integer::sum).ifPresent(System.out::println);
	}
	
// Devuelve una lista ordenada de la lista pasada por parametro
	public static void ordenarArray() {
		nOrdenados = numbers.stream().sorted((o1, o2)->o1.
                compareTo(o2)).
                collect(Collectors.toList());
		System.out.println(nOrdenados);
//		numbers.stream().sorted().forEach(System.out::println);
		
	}
	
	
}
