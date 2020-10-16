package com.jspAssignment;


public class Book {
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getSales() {
		return sales;
	}


	public void setSales(int sales) {
		this.sales = sales;
	}


	private int id;
	private String title ;
	private String author ;
	private int cost ;
	private int sales ;
	
	public Book(String title, String author, int cost, int sales) {
		super();
		this.title = title;
		this.author = author;
		this.cost = cost;
		this.sales = sales;
	}


	public Book(int id, String title, String author, int cost, int sales) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.cost = cost;
		this.sales = sales;
	}


}
