
package br.edu.ifpb.praticas.projeto.commands;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edilva
 */
public interface Command {
    
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
