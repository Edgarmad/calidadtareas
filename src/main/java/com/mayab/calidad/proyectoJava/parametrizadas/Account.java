package com.mayab.calidad.proyectoJava.parametrizadas;

public class Account {
    
    int balance, zone;
    float comission;
    String holder;
    AlertListener alerts;

    public Account(String holder, int initialBalance, int zone){
        this.holder = holder;
        this.balance = initialBalance;
        this.zone = zone;
        this.alerts = new AlertListener();
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }
    
    public int getZone() {
    	return this.zone;
    }
    public float getComission() {
    	this.comission = (this.zone/100);
    	return this.comission;
    }

    void debit(int balance) //Retirar dinero
    {
        this.balance -= (balance-this.getComission());
        if(this.balance < 100){
            this.alerts.alert(this.holder+", your account balance is below 100");
        }
    }

    void credit (int balance) //depositar dinero
    {
        this.balance += (balance+this.getComission());
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
}