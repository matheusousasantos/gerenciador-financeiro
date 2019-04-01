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
	
//	1� - Intercepta todas as requisi��es, podem ser todas, ou uma lista ou uma s� requisi��o.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
//			6� Agora precisamos verificar se o usu�rios est� logado:
//		    req - Requisi��o = Todos os dados que vem da tela e do Http
		
			HttpServletRequest req = (HttpServletRequest) request;
			
//		7� Pegar o usu�rio na sess�o {
			HttpSession session = req.getSession();
//			Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
//			8� Isso vai funcionar se o usu�rio estiver logado na sess�o, sen�o... se retornar nulo:
//		}
			
//			22� Agora vamos usar um filtro gen�rico que ir� interceptar todas as p�ginas que est�o na pasta 'pages'
//			    Como vou fazer pra identificar qual p�gina que est� tentando ser acessada?
			System.out.println(req.getServletPath());//23� Pegando o caminho que est� querendo ser acessado.
			
			String urlParaAutenticar = req.getServletPath();
			
			Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
			
			if(usuarioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/pages/servletAutenticacao")) { // 9� Se o obj for nulo vamos dar um redirecionamento para outra p�gina
				
				System.out.println("entrou no IF");
				
//				11� � enviado pra p�gina de login p�s n�o est� logado...
				RequestDispatcher view = request.getRequestDispatcher("/autenticar.jsp?url=" + urlParaAutenticar);
				view.forward(request, response);
				
//				10� primeira coisa precisamos dar o return, n�o podemos deixar continuar:
				return;
	
			}//12� se n�o cair nesse bloco ^^ vai executar normal e o usu�rio est� logado ,sen�o ele retorna(sai).
		
			chain.doFilter(request, response); // 2� - Sempre devemos fazer essa chamada, repons�vel por fazer as a��es do request e response
			System.out.println("Continuou...");
			
	}

}
