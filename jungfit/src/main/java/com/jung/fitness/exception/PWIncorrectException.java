package com.jung.fitness.exception;

public class PWIncorrectException extends Exception{
	public PWIncorrectException() {
		super("비밀번호가 틀립니다.");
	}
}
