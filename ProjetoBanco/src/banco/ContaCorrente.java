package banco;

import java.util.*; //trazer a classe Scanner ou qualquer outra necessária

public class ContaCorrente {

	int numeroconta;
	String titularconta;
	double saldo;
	int controlesaque; //contador que vai limitar a quantidade de saques
	
	Scanner entrada = new Scanner (System.in); 
	
	public ContaCorrente(String nometitular, double saldoinicial) {
		this.titularconta = nometitular;
		this.saldo = saldoinicial;
		this.controlesaque = 0;
		
		Random geradornumero = new Random(); // classe gerador randomico de números
		numeroconta = geradornumero.nextInt(1000);
		
	} //método construtor
	
	public void VerSaldo() {
		System.out.println("O número da sua conta é: " + this.numeroconta);
		System.out.println("Referente ao titular: " + this.titularconta);
		System.out.println("Saldo da conta: " + this.saldo);
	}
	
	public void Saque(double valorsaque) {
		if(this.saldo >= valorsaque) {
			this.saldo -= valorsaque; // saldo = saldo - valorsaque
			System.out.println("Seu saldo atual é: " + saldo);
			this.controlesaque++;
		}else {
			System.out.println("Saldo insuficiente para saque");
		}
	}
	
	public void Deposito(double valordeposito) {
		if (valordeposito <= 0) {
			System.out.println("Por favor, insira um valor maior que 0");
		}else {
			this.saldo += valordeposito;
			System.out.println("Seu saldo atual é: " + this.saldo);
		}
	}
	
	public void Iniciar() {
		int opcao;
		do {
			ExibirMenu();
			opcao = entrada.nextInt();
			EscolherOpcao(opcao);
		}while(opcao != 4);
	}

	
	public void ExibirMenu() {
		System.out.println("Bem-vindo a UXBank!");
		System.out.println("Escolha a operacao que deseja realizar: ");
		System.out.println("1 - Consultar saldo");
		System.out.println("2 - Saque");
		System.out.println("3 - Depositar");
		System.out.println("4 - Finalizar");
	}
	
	public void EscolherOpcao(int opcao) {
		double saque;
		double deposito;
		
		switch (opcao) {
		case 1: VerSaldo();
		break;
		
		case 2:
			if(this.controlesaque > 3) {
				System.out.println("Limite excedido de saques");
			}else {
				System.out.println("Insira o valor para saque: ");
				saque = entrada.nextDouble();
				Saque(saque);
			}
			break;
		
		case 3: System.out.println("Insira o valor que deseja depositar: ");
			deposito = entrada.nextDouble();
			Deposito(deposito);
			break;
			
		case 4: System.out.println("Estamos finalizando sua seção, até a próxima!");
		break;
		
		default: System.out.println("Opcao inválida");
		}
	}
	
}
