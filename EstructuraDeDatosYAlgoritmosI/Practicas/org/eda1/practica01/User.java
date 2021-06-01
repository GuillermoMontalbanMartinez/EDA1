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

		if (devs == null)
			return false;

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
		int index = this.devices.indexOf(dev);

		if (index == -1)
			return false;
		this.devices.get(index).sendMessage(msg);

		return true;
	}

	public boolean loadMessages(Device dev, String fileName) {

		Scanner scan = null;
		String line;
		int index = this.devices.indexOf(dev);

		if (index == -1)
			return false;

		if (!this.devices.contains(dev))
			return false;

		try {
			scan = new Scanner(new File(fileName));
		} catch (Exception e) {
			return false;
		}

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.isEmpty())
				continue;
			this.devices.get(index).sendMessage(line);
		}
		scan.close();
		return true;
	}

	public void substitute(String word1, String word2) {
		for (Device device : devices) {
			device.substitute(word1, word2);
		}

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

		String result = "";

		for (Device device : devices) {
			result += device.toString() + ": ";
			for (String word : device) {
				result += word.toString() + " ";
			}
			result += "\n";
		}
		return result;
	}

	public ArrayList<String> getOrderedWords() {
		ArrayList<String> result = new ArrayList<String>();
		for (Device device : devices) {
			for (String word : device) {
				if (result.contains(word))
					continue;
				result.add(word);
			}
		}

		result.sort(null);

		return result;
	}

	@Override
	public String toString() {
		return this.name;
	}
}