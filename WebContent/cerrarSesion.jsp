<%@ page session="true" %>
<%
	HttpSession s = request.getSession();
	s.removeAttribute("usuario");
	s.invalidate();
	response.sendRedirect("login.jsp");
%>
