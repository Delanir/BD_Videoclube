/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import outros.Consts;
import outros.Utils;

import bd.DBHandler;
import outros.EmailSender;

public class GestorClientes
{
	public static void main(String[] args) {
		
	}
	/**
	 * Adiciona um novo cliente se o BI passado como argumento n�o existir.
	 * Actualiza os dados se j� existir.
	 */
	public String actualizaCliente(String nome, String bi, String password, String morada, String email, String telefone) {
		if (DBHandler.biClienteExiste(bi)) {
			DBHandler.adicionaCliente(nome, bi, password, morada, email, telefone);
			return "Novo cliente adicionado.";
		} else {
			DBHandler.actualizaCliente(nome, bi, password, morada, email, telefone);
			return "Cliente actualizado.";
		}
	}
	
	/**
	 * Devolve informa��es relativas ao cliente em questão
	 */
	public String[] procuraCliente(String id) {
		return DBHandler.getCliente(id);
	}
	
	public String[] procuraClienteBI(String bi) {
                if(Utils.isNumber(bi)){
                
                    return DBHandler.getClienteBI(bi);
                }
                return null;
	}

	/**
	 * Procura clientes com as informa��es nos campos n�o nulos passados.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] procuraClientes(String nome, String morada, String email, String telefone) {
		Vector<String[]> vec = DBHandler.procuraClientes(nome, morada, email, telefone);
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1});
	}

	/**
	 * Lista clientes activos no sistema.
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] verListaClientes() {
		Vector<String[]> vec = DBHandler.getClientes();
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1});
	}

	public String invalidaCliente(String id) {
		DBHandler.invalidaCliente(id);
		Utils.dbg("O cliente com o ID " + id + " foi invalidado.");
		return "O cliente foi invalidado.";
	}

	public String invalidaClienteBI(String bi) {
		DBHandler.invalidaClienteBI(bi);
		Utils.dbg("O cliente com o BI " + bi + " foi invalidado.");
		return "O cliente foi invalidado.";
	}

	/**
	 * devolve uma lista com os clientes que têm pagamentos em atraso
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public String[] getClientesComEntregasPorFazer() {
		Vector<String[]> vec = DBHandler.getClientesComEntregasPorFazer();
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1});
	}

	/**
	 * Strings devolvidas no formato "id : [BI] nome"
	 */
	public static String[] getClientesComEntregasForaDePrazo() {
		Vector<String[]> vec = DBHandler.getClientesComEntregasForaDePrazo();
		return Utils.formattedFromVector(vec, "%s : [%s] %s", new int[]{0, 2, 1});
	}

	/**
	 * envia um email a um cliente
	 */
	public void notificarCliente(String id, String mensagem) {
        String[] out;
		if (id != null && id.isEmpty()) {
			// procura dados do cliente (cont�m e-mail)
            out=DBHandler.getClienteBI(id);
			// envia email
            if(out != null && out.length != 0 && out[5] != null){
                try {
                    EmailSender.send(Consts.EMAIL_SMTP_HOST, Consts.EMAIL_SMTP_PORT, Consts.EMAIL_VIDEOCLUBE, out[5], "Notifica��o", mensagem);
                } catch (AddressException ex) {

                } catch (MessagingException ex) {
                    
                }
            }
		}
	}
}
