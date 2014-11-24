package br.com.matheuscs.votenolivro.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.matheuscs.votenolivro.dao.LivroDAO;
import br.com.matheuscs.votenolivro.dao.LivroDAOImpl;
import br.com.matheuscs.votenolivro.entity.Livro;

@SuppressWarnings("unused")
public class Persistencia1 {

	@Test
	@Transactional
	public void lerTodos() throws Exception {
		LivroDAO dao = new LivroDAOImpl();
		System.out.println(dao.getTodosLivros());
	}
	

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		/*Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		order.getItems().add(new Item());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		Order other = (Order) session.get(Order.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());*/
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		/*Session session = sessionFactory.getCurrentSession();
		Order order = new Order();
		Item item = new Item();
		item.setProduct("foo");
		order.getItems().add(item);
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		Order other = (Order) session
				.createQuery( "select o from Order o join o.items i where i.product=:product")
				.setString("product", "foo").uniqueResult();
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());*/
	}

}
