package dao;

import java.util.ArrayList;

public interface IDAO_T <T> {

    public String salvar(T o);

    public String atualizar(T o, String dado_anterior);

    public String excluir(int id, String dado_anterior);

    public ArrayList<T> consultarTodos();

    public ArrayList<T> consultar(String criterio);

    public T consultarId(int id);    
    
    
}
