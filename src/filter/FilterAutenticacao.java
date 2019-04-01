package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.Usuario;

@WebFilter(urlPatterns= {"/pages/*"})
public class FilterAutenticacao implements Filter{
	
//	1° - Intercepta todas as requisições, podem ser todas, ou uma lista ou uma só requisição.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
//			6° Agora precisamos verificar se o usuários está logado:
//		    req - Requisição = Todos os dados que vem da tela e do Http
		
			HttpServletRequest req = (HttpServletRequest) request;
			
//		7° Pegar o usuário na sessão {
			HttpSession session = req.getSession();
//			Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
//			8° Isso vai funcionar se o usuário estiver logado na sessão, senão... se retornar nulo:
//		}
			
//			22° Agora vamos usar um filtro genérico que irá interceptar todas as páginas que estão na pasta 'pages'
//			    Como vou fazer pra identificar qual página que está tentando ser acessada?
			System.out.println(req.getServletPath());//23° Pegando o caminho que está querendo ser acessado.
			
			String urlParaAutenticar = req.getServletPath();
			
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
			
			if(usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/servletAutenticacao")) { // 9° Se o obj for nulo vamos dar um redirecionamento para outra página
				
				System.out.println("entrou no IF");
				
//				11° É enviado pra página de login pôs não está logado...
				RequestDispatcher view = request.getRequestDispatcher("/autenticar.jsp?url=" + urlParaAutenticar);
				view.forward(request, response);
				
//				10° primeira coisa precisamos dar o return, não podemos deixar continuar:
				return;
	
			}//12° se não cair nesse bloco ^^ vai executar normal e o usuário está logado ,senão ele retorna(sai).
		
			chain.doFilter(request, response); // 2° - Sempre devemos fazer essa chamada, reponsável por fazer as ações do request e response
			System.out.println("Continuou...");
			
	}

}
