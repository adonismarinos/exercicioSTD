package std;

import java.util.ArrayList;
import java.util.HashMap;

public class Lista {

        private HashMap <String, ArrayList<String>> listas = new HashMap<>();

        public boolean criarLista(String s){
            if(listas.containsKey(s)==false){
                ArrayList<String> item = new ArrayList<>();
                listas.put(s,item);
                return true;
            }
            return false;
        }

        public boolean addNaLista(String s, String x){
            if(listas.containsKey(s)==true){
                ArrayList<String> aux = this.listas.get(s);
                aux.add(x);
                return true;
            }
            return false;
        }
        public boolean delNaLista(ArrayList<String> s, String x) {
            if(listas.containsKey(s)==true) {
                ArrayList<String> aux = this.listas.get(s);
                String item = aux.get(aux.size()-1);
                aux.remove(aux.size()-1);
                System.out.println("O último item da lista " + s + " é: " + item);
                return true;
            }
            return false;
        }

    }

//Desenvolva um aplicativo servidor que armazene em memória zero ou mais listas de
//String
//.
//O servidor deverá oferecer uma interface de forma a permitir ao cliente criar uma nova lista,
//adicionar valores em uma lista já existente, obter o último valor adicionado em uma lista, e
//por consequência, removê-lo dessa lista.  Desenvolva um aplicativo cliente capaz de fazer
//requisições a esse servidor.  Cliente e Servidor poderão ser desenvolvidos em diferentes
//linguagens de programação ou em uma mesma linguagem.

}
