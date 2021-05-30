package org.eda1.practica01;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	private String name;
	private ArrayList<Device> devices;

	public User(String name) {
		if (name == null) {
			throw new RuntimeException("El atributo name no puede ser nulo");
		}

		this.name = name.trim();
		devices = new ArrayList<Device>();

	}

	public void clear() {
		for (Device device : devices) {
			device.clear();
		}

		this.devices.clear();
	}

	public boolean addDevices(Device... devs) {
		// Device... equivale, internamente, a Device[] --> un array de dispositivos
		// insertaremos los dispositivos en la estructura devices siempre y cuando no
		// existan ya (no elementos repetidos)
		for (Device dev : devs) {
			if (!this.devices.contains(dev)) {
				this.devices.add(dev);
			}

		}
		return true;
	}

	public int getNumDevices() {
		return this.devices.size();
	}

	public boolean sendMessage(Device dev, String msg) {
		// Una vez que comprobemos que dev existe (indexOf()) llamaremos al metodo
		// sendMessage(msg) del Dispositivo
		// ...
		return true;
	}

	public boolean loadMessages(Device dev, String fileName) {
		// insertamos las palabras contenidas en el archivo especificado en fileName en
		// el dispositivo dev especificado
		// como parametro de entrada
		// La estructura de codigo para cargar datos de un archivo de texto es siempre
		// la misma;
		// Habra que hacer los cambios necesarios para adaptarnos a la naturaleza de los
		// datos que contiene cada archivo
		// El dispositivo dev debera ser un dispositivo que exista en la estructura
		// devices

		Scanner scan = null;
		String line;
		// ...
		try {
			scan = new Scanner(new File(fileName)); // Lanzara una excepcion si el archivo especificado no existe
		} catch (Exception e) {
			return false;
		}

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.isEmpty())
				continue; // Ignoramos las posibles lineas vacias
			// ...
		}
		scan.close();
		return true;
	}

	public void substitute(String word1, String word2) {
		// Sustituimos todas las ocurrencias de word1 por word2 en todos los
		// dispositivos del usuario
		// Si word2 == null --> eliminamos word1
		// haremos uso del metodo substitute(word1, word2) definido en Device

		// ...

	}

	public boolean contains(String word) {
		// Comprobamos, dispositivo por dispositivo, si contien la palabra especificada
		// En el momento en el que se se cuentre la palabra, el metodo debe devolver
		// true inmediatamente
		// ...
		for (Device dev : devices) {
			if (dev.contains(word)) {
				return true;
			}
		}

		return false;
	}

	public String getWords() {
		// Nos devuelve el conjunto de palabras asociado a cada dispositivo
		// Formato idDevice.- name: word1 word2 ... wordn \n
		// 2 for()
		String result = "";
		// ...
		return result;
	}

	public ArrayList<String> getOrderedWords() {
		// En este caso devuelve el conjunto completo de palabras, independientemente
		// del dispositivo
		// Haremos uso del metodo sort() para ordenar las palabras
		// 2 for()
		ArrayList<String> result = new ArrayList<String>();
		// ...

		return result;
	}

	@Override
	public String toString() {
		return this.name;
	}
}