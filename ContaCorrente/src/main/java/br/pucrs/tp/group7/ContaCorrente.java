package br.pucrs.tp.group7;

public class ContaCorrente{

    public int numeroConta;
    public String nomeCorrentista;
    public double saldo;
    public String categoria;


    public ContaCorrente(){
        this.saldo = 0;
        this.categoria = "Silver";
    }

    public String getNumeroConta(){
        return "Numero Conta: " + numeroConta;
    }
    public String getNomeCorrentista(){
        return nomeCorrentista;
    }
    public double getSaldo(){
        return saldo;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String s){
        this.categoria = s;
    }
    public void verificaCategoriaDeposito(){
        String cat = this.getCategoria();
        if(cat.equals("Silver")){
            if(saldo >= 50000.00){
                this.setCategoria("Gold");
            }
        }else if(cat.equals("Gold")){
            if(saldo >= 2000000.00){
                this.setCategoria("Platinum");
            }
        }
    }
    public void verificaCategoriaRetirada(){
        String cat = this.getCategoria();
        if(cat.equals("Gold")){
            if(saldo < 25000.00){
                this.setCategoria("");
            }
        }else if(cat.equals("Platinum")){
            if(saldo < 1000000.00){
                this.setCategoria("Gold");
            }
        }
    }
    public boolean deposito(double valor){
        if(this.getCategoria().equals("Gold")){
            valor += valor*0.01;
            this.saldo += valor;
        }else if(this.getCategoria().equals("Platinum")){
            valor += valor*0.025;
            this.saldo += valor;
        }else 
            this.saldo += valor;
        this.verificaCategoriaDeposito();
        return true;
    }
    public boolean retirada(double valor){
        if((saldo-valor) <0){
            return false;
        }else {
            this.saldo -= valor;
            this.verificaCategoriaRetirada();
            return true;
        }
        
    }


}