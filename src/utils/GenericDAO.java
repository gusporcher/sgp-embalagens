package utils;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	public T insert (T t) throws SQLException;
	public void update (T t) throws SQLException;
	public void delete (T t) throws SQLException;
	public T getObjeto (int id) throws SQLException;
	public List<T> readAll () throws SQLException;
}
