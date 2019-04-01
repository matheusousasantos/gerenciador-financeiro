package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Usuario;

@WebServlet("/pages/servletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletAutenticacao() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		System.out.println(login);
		System.out.println(senha);
		
//		15° neste momento já podiamos fazer a validação no banco de dados.
		if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
			
			
//			19° Mais antes precisamos colocar nosso usuário na sessão:
			Usuario usuario = new Usuario();//Inserindo as informações
			
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
//			20° Agora vamos pegar a session e setar o atributo:
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
//			21° Agora eu seto os atributos:
			session.setAttribute("usuario", usuario); //chave = "usuario", sessão = usuario
			
			
//			18° pra onde será redirecionado:
			RequestDispatcher view = request.getRequestDispatcher(url);
			view.forward(request, response);
			
			
//			16° Se os atributos estiverem certos vai liberar o acesso, senão:
		} else {
//			17° redireciona para login novamente:
			RequestDispatcher view = request.getRequestDispatcher("/autenticar.jsp");
			view.forward(request, response);
		}
		
	}

}
