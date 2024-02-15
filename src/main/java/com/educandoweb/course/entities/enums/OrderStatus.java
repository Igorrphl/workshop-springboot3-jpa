package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	//cOLOCANDO VALORES NA FRENTE PARA FACILITAR UMA POSSÍVEL MANUNTEÇÃO NO FUTURO
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	//Código do tipo enumerado
	private int code;
	
	//Construtor do tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//método público para acessar o código acima
	public int getCode() {
		return code;
	}
	
	//Convertando um valor numérico para otipo enumerado
	//Ou seja vou passar um código (ex: '1') e ele vai me retornar WAITING_PAYMENT
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
