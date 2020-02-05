package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

/*Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e salario) de
N funcion�rios. N�o deve haver repeti��o de id.
Em seguida, efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
Para isso, o programa deve ler um id e o valor X. Se o id informado n�o existir, mostrar uma
mensagem e abortar a opera��o. Ao final, mostrar a listagem atualizada dos funcion�rios,
conforme exemplos.
Lembre-se de aplicar a t�cnica de encapsulamento para n�o permitir que o sal�rio possa
ser mudado livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
aumento por porcentagem dada.*/

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	   List<Employee> list = new ArrayList<>();
	   
	   //Parte 1 - Leitura de dados.
	   
	   System.out.println("Digite a quantidade de funcionario a ser cadastrado:");
	   int n = sc.nextInt();
	   
	   for (int i = 0; i < n ; i++) {
		   System.out.println();
		   System.out.println("Employee #" + i + ": ");
		   System.out.println("Id: ");
		   int id = sc.nextInt();
		   System.out.println("Name: ");
		   sc.nextLine();
           String name = sc.nextLine();
           System.out.println("Salary: ");
           double salary = sc.nextDouble();
           
           list.add(new Employee(id,name,salary));
	}
	   
	   //Parte 2 atualiza��odo salario de empregado.
	      
	   System.out.println();
	   System.out.println("Entre com o ID do funcionario que recebera o aumento:");
	   int id = sc.nextInt();
	   
	   Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null){
			System.out.println("o id n�o existe: ");
		}
		else {
			System.out.println("entre com a porcentagem: " );
			double porc = sc.nextDouble();
			emp.increaseSalary(porc);
		}
		
		// Parte 3 Lista de funcionario
		
		System.out.println();
		System.out.println("lista de funcionario");
		
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
