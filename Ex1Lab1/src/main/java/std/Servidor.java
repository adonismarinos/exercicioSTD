package std;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Cliente
Lista
        ServidorServidor {

    public static void main(String[] args) throws IOException {

        Lista memoria = new Lista();
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
            String[] aux = mensagem.split(",");
            if(aux[0].equals("criar")){
                memoria.criarLista(aux[1]);
            }
            else if(aux[0].equals("add")){
                memoria.addNaLista(aux[1],aux[2]);
            }
            else if(aux[0].equals("del")){
                String msg = memoria.delNaLista(aux[1]);
                fluxoSaida.writeUTF(msg);
            }
            else{
                System.out.println("Comando invalido");
            }
            /* Fecha fluxos e socket */
            fluxoEntrada.close();
            fluxoSaida.close();
            conexao.close();
        }
    }

}