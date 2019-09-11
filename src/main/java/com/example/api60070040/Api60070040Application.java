package com.example.api60070040;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@RestController
public class Api60070040Application {
	cafeName name = cafeName.getInstance();
	private static List<Cake> allCake = new ArrayList<Cake>();
	{
		File file = new File("ListAllCake.txt");
		if(file.exists()){
			this.readFile();
		}
		else {
			allCake.add(CakeFactory.createCake(1, "Red Velvet", 120, "Cakebasic"));
			allCake.add(CakeFactory.createCake(2, "Blueberry", 80, "Cheesecake"));
			allCake.add(CakeFactory.createCake(3, "Cookie and cream", 99, "Icecreamecake"));
			allCake.add(CakeFactory.createCake(4, "Vanila", 99, "Icecreamecake"));
			this.createFile();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Api60070040Application.class, args);
	}
@RequestMapping("/")
	String index(){
		if (name.getYourCafe() == null){
			return "Please go to ' /setCafeName/-edit name here!- ' for create your CafeName";
		}
		else {
			return "Welcome to "+ name.getYourCafe() +"'cafe";
		}
}
@RequestMapping("/allcake")
public List<Cake> getCake(){
		return this.allCake;
//		CakeFactory.createCake()
//		return Arrays.asList(
//				new Cake(1,"Redvelvet",120),
//				new Cake(2,"Chocolate",128),
//				new Cake(3,"Cheesecake",120)
//		);
}
@RequestMapping("/searchid/{id}")
public List<Cake> getCakeId(@PathVariable int id){
		List<Cake> chosen = new ArrayList<Cake>();
	for(Cake item: getCake()){
		if (item.getId() == id){
			chosen.add(item);
		}
	}
	return chosen;
}
	@RequestMapping("/searchtype/{type}")
	public List<Cake> getCakeType(@PathVariable String type){
		List<Cake> chosen = new ArrayList<Cake>();
		for(Cake item: getCake()){
			if (item.getType().toLowerCase().equals(type)){
				chosen.add(item);
			}
		}
		return chosen;
	}
	public void readFile(){
		try {
			FileInputStream read = new FileInputStream("ListAllCake.txt");
			ObjectInputStream ois = new ObjectInputStream(read);
			allCake = (List<Cake>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public void createFile(){
		try {
			FileOutputStream create = new FileOutputStream("ListAllCake.txt");
			ObjectOutputStream oos = new ObjectOutputStream(create);
			oos.writeObject(allCake);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@RequestMapping(value = "/setCafeName/{Cafename}",method = RequestMethod.GET)
	public String setCafeName(@PathVariable String Cafename){
		name.setYourCafe(Cafename);
		return "Welcome to "+ name.getYourCafe() +"'cafe";
	}
}

