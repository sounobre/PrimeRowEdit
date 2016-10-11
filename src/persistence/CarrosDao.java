package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;


import model.Car;

public class CarrosDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void cadastrar(Car produto)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(produto);
		transaction.commit();
		session.close();
		
	}
	
	public List<Car> listar()throws Exception {
			session = HibernateUtil.getSessionFactory().openSession();
			criteria = session.createCriteria(Car.class);
			criteria.addOrder(Order.asc("nome"));
			List<Car> lista = criteria.list();
			session.close();
		
		return lista;
	}
	
	public void deletar(Car produto) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
		session.close();
	}
	
	public void editar(Car produto) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =session.beginTransaction();
		session.update(produto);
		transaction.commit();
		session.close();
			
	}
	
	public Car buscarid(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Car p = (Car) session.get(Car.class, id);
		session.close();
		return p;
		
	}
}
