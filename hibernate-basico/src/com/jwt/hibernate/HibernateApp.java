package com.jwt.hibernate;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Departamento dpto = new Departamento();
		
		dpto.setDescripcion("Finanzas");
				
		Persona persona = new Persona();

		persona.setDni(12345670);
		persona.setApellido("Sepulveda");
		persona.setNombre("Lolote");
		persona.setSexo('M');
		persona.setCodigo_depto(1);

		Transaction tx = session.beginTransaction();
		try {
			//session.saveOrUpdate(dpto);
			
			//session.saveOrUpdate(persona);
			//System.out.println("Se genero el registro con éxito.....!!");
			
			tx.commit();
			
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
			cq.from(Persona.class);
			//Root<Persona> rp = cq.from(Persona.class);
			//cq.select(rp).where(cb.like(rp.get("nombre"), "f%"));
			List<Persona> lista = session.createQuery(cq).getResultList();
			for(Persona p : lista) {
				System.out.println(p);
			}			
			
			System.out.println("\nSolo DNI de las Personas");
			
			Query q = session.getNamedQuery("DniPersonas");
			List<Integer> listaConDni = q.getResultList();
			for(Integer i : listaConDni)
				System.out.println(i);
			
			System.out.println("\nOtra forma de consultar personas");
			q = session.createQuery("Select p from Persona p");
			List<Persona> listaDePersonas = q.getResultList();
			for(Persona p : listaDePersonas)
				System.out.println(p);
			
			System.out.println("\nSolo las personas de sexo femenino");
			q = session.createQuery("Select p from Persona p where p.sexo = 'F'");
			listaDePersonas = q.getResultList();
			for(Persona p : listaDePersonas)
				System.out.println(p);
			
			long totalPersonas = (long) session.createQuery("select count(p) from Persona p").uniqueResult();
			System.out.println("\nCantidad de personas: " + totalPersonas);
			
			System.out.println("\nPersonas y su Departamento");
			q = session.createQuery("Select p.dni, p.apellido, d.descripcion from Persona p, Departamento d where p.codigo_depto = d.codigo");
			List<Object[]> listaDeDatos = q.getResultList();
			for(Object[] registro : listaDeDatos)
				System.out.println(registro[0] + " " + registro[1] + " (" + registro[2] + ")");
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
