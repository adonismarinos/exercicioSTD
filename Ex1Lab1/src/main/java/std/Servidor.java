package std;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
/* by adonis
*
*
* */
/**
 * Servidor que espera por uma mensagem do cliente (String em UTF) e depois
 * envia uma String de resposta, tambem em UTF
 *
 * 2014-08-24
 * @author Emerson Ribeiro de Mello
 */
public class Servidor {

    public static void main(String[] args) throws IOException {

        HashMap<String, ArrayList<String>> memoria = new HashMap<String, ArrayList<String>>();

        /* Registra servico na porta 1234 e aguarda por conexoes */
        ServerSocket servidor = new ServerSocket(1234);

        System.out.println("Aguardando por conexoes");

        while (true) {

            Socket conexao = servidor.accept();
            System.out.println("Cliente conectou " + conexao);
            /*********************************************************/
            /* Estabelece fluxos de entrada e saida */
            DataInputStream fluxoEntrada = new DataInputStream(
                    new BufferedInputStream(conexao.getInputStream()));
            DataOutputStream fluxoSaida = new DataOutputStream(conexao.getOutputStream());
            /*********************************************************/
            /* inicia a comunicacao */
            String mensagem = fluxoEntrada.readUTF();
            System.out.println("Cliente> " + mensagem);
            String com = new String();
            String arg1 = new String();
            String arg2 = new String();

            if (com == "criar") {
                if (memoria.containsKey(arg1) == false) {
                    memoria.put(arg1, new ArrayList<String>());
                }
            }
            fluxoSaida.writeUTF("Oi, eu sou o servidor!");
            /*********************************************************/

            /* Fecha fluxos e socket */
            fluxoEntrada.close();
            fluxoSaida.close();
            conexao.close();
        }
        servidor.close();
    }

}