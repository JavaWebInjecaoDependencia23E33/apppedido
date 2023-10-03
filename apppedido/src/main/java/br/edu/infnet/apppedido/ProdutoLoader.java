package br.edu.infnet.apppedido;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.apppedido.model.domain.Bebida;
import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ProdutoService;

@Order(3)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/produto.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";"); 
			
			switch (campos[7]) {
			case "B":
				Bebida bebida = new Bebida(
						campos[0], 
						Float.valueOf(campos[1]), 
						Integer.valueOf(campos[2]), 
						Boolean.valueOf(campos[3]), 
						Float.valueOf(campos[4]), 
						campos[5]
					);	
				
				bebida.setUsuario(new Usuario(Integer.valueOf(campos[6])));

				produtoService.incluir(bebida);				
				break;

			case "C":
				Comida comida = new Comida(
						campos[0], 
						Float.valueOf(campos[1]), 
						Integer.valueOf(campos[2]), 
						Float.valueOf(campos[3]), 
						Boolean.valueOf(campos[4]), 
						campos[5]
					);
				
				comida.setUsuario(new Usuario(Integer.valueOf(campos[6])));

				produtoService.incluir(comida);
				break;

			case "S":
				Sobremesa sobremesa = new Sobremesa(
						campos[0], 
						Float.valueOf(campos[1]), 
						Integer.valueOf(campos[2]), 
						Float.valueOf(campos[3]), 
						Boolean.valueOf(campos[4]), 
						campos[5]
					);
				
				sobremesa.setUsuario(new Usuario(Integer.valueOf(campos[6])));

				produtoService.incluir(sobremesa);
				break;
			
			default:
				break;
			}
			
			linha = leitura.readLine();
		}

		leitura.close();		
	}
}